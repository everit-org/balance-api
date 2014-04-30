/**
 * This file is part of org.everit.osgi.balance.api.
 *
 * org.everit.osgi.balance.api is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * org.everit.osgi.balance.api is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with org.everit.osgi.balance.api.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.osgi.balance.api;

import java.math.BigDecimal;

import org.everit.commons.selection.Limit;
import org.everit.commons.selection.LimitedResult;

/**
 * Service interface for balance transfer management.
 */
// TODO update javadocs
public interface BalanceTransferService {

    /**
     * Accepts the given transfer. The following steps must be done in one transaction:
     * <ul>
     * <li>the creditor and debtor accounts must be locked</li>
     * <li>the status of the accepted transfer must equal to {@link org.everit.balance.api.model.TransferStatus#BLOCKED}
     * </li>
     * <li>the status of the accepted transfer must be changed to
     * {@link org.everit.balance.api.model.TransferStatus#SUCCESSFUL}</li>
     * <li>a new {@link org.everit.balance.api.model.TransferStatus#SUCCESSFUL} transfer must be created with reversed
     * accounts and opposite sign of credit amount</li>
     * <li>the balances of the accounts must be recalculated</li>
     * </ul>
     *
     * @param transferId
     *            The ID of the transfer to accept.
     */
    void acceptBlockedTransfer(long transferId);

    /**
     * Creates a new transfer with status {@link org.everit.balance.api.model.TransferStatus#BLOCKED}. The following
     * steps must be done in one transaction:
     * <ul>
     * <li>the creditor account must be locked</li>
     * <li>a new {@link org.everit.balance.api.model.TransferStatus#BLOCKED} transfer must be created with the given
     * parameters</li>
     * <li>the balances of the creditor account must be recalculated</li>
     * </ul>
     *
     * @param transferCode
     *            The external code of the transfer to support filtering and grouping certain transfers.
     * @param creditorAccountId
     *            The ID of the creditor account.
     * @param debtorAccountId
     *            The ID of the debtor account.
     * @param amount
     *            The amount of the transfered credit. Must be a positive number. Cannot be null.
     * @param notes
     *            The notes belonging of the transfer.
     * @return The ID of the created transfer.
     */
    long createBlockedTransfer(String transferCode, long creditorAccountId, long debtorAccountId,
            BigDecimal amount, String notes);

    /**
     * Creates two new transfer with status {@link org.everit.balance.api.model.TransferStatus#SUCCESSFUL}. The
     * following steps must be done in one transaction:
     * <ul>
     * <li>the creditor and debtor accounts must be locked</li>
     * <li>a new {@link org.everit.balance.api.model.TransferStatus#SUCCESSFUL} transfer must be created with the given
     * parameters</li>
     * <li>another new {@link org.everit.balance.api.model.TransferStatus#SUCCESSFUL} transfer must be created with
     * reversed accounts and opposite sign of credit amount</li>
     * <li>the balances of the accounts must be recalculated</li>
     * </ul>
     *
     * @param transferCode
     *            The external code of the transfer to support filtering and grouping certain transfers.
     * @param creditorAccountId
     *            The ID of the creditor account.
     * @param debtorAccountId
     *            The ID of the debtor account.
     * @param amount
     *            The amount of the transfered credit. Must be a positive number. Cannot be null.
     * @param notes
     *            The notes belonging of the transfer.
     * @return the ID of the created credit transfer
     */
    long createInstantTransfer(String transferCode, long creditorAccountId, long debtorAccountId,
            BigDecimal amount, String notes);

    BalanceTransfer findTransferById(long transferId);

    /**
     * Finds the transfers based on the parameters. All primitive properties of the returned {@link BalanceTransfer}
     * instances will be returned, furthermore the {@link org.everit.balance.api.dto.Account#getAccountId() Id} property
     * of the {@link BalanceTransfer#getCreditorAccount() creditor account} and the
     * {@link BalanceTransfer#getDebtorAccount() debtor account} will also be loaded, but the further properties of the
     * accounts won't be queried.
     *
     * @param filter
     *            Filter parameters for listing transfers.
     * @param order
     *            The desired ordering of the result list. Cannot be null.
     * @param limit
     *            The {@link Limit} of the query. Cannot be null.
     * @return the transfers
     */
    LimitedResult<BalanceTransfer> findTransfers(TransferFilter filter, TransferOrder order, Limit limit);

    BalanceTransfer[] findTransfersByPairId(String transferPairId);

    /**
     * Rejects the given transfer. The following steps must be done in one transaction:
     * <ul>
     * <li>the creditor account must be locked</li>
     * <li>the status of the rejected transfer must equal to {@link org.everit.balance.api.model.TransferStatus#BLOCKED}
     * </li>
     * <li>the status of the rejected transfer must be changed to
     * {@link org.everit.balance.api.model.TransferStatus#REJECTED}</li>
     * <li>the balances of the creditor account must be recalculated</li>
     * </ul>
     *
     * @param transferId
     *            The ID of the transfer to reject.
     */
    void rejectBlockedTransfer(long transferId);

}
