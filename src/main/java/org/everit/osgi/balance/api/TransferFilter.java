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

import org.everit.commons.selection.util.CalendarRange;

/**
 * Filter parameters for listing transfers.
 */
public class TransferFilter {

    /**
     * The ID of the creditor account or <code>null</code> if all creditor accounts are interested.
     */
    private final Long creditorAccountId;
    /**
     * The ID of the debtor account or <code>null</code> if all debtor accounts are interested.
     */
    private final Long debtorAccountId;
    /**
     * Only the transfers created in this interval (inclusively) will be listed. If <code>null</code> then no begin
     * timestamp will be used in the query.
     */
    private final CalendarRange createdRange;
    /**
     * Only the transfers accomplished in this interval (inclusively) will be listed. If <code>null</code> then no end
     * timestamp will be used in the query.
     */
    private final CalendarRange accomplishedRange;
    /**
     * Only the transfers with the given transferCode will be listed. Ignored if <code>null</code> value.
     */
    private final String transferCode;
    /**
     * Only the transfers with the given transferStatus will be listed. Ignored if <code>null</code> value.
     */
    private final TransferStatus transferStatus;

    /**
     * Constructor for setting final fields.
     * 
     * @param creditorAccountId
     *            The ID of the creditor account or <code>null</code> if all creditor accounts are interested.
     * @param debtorAccountId
     *            The ID of the debtor account or <code>null</code> if all debtor accounts are interested.
     * @param createdRange
     *            Only the transfers created in this interval (inclusively) will be listed. If <code>null</code> then no
     *            begin timestamp will be used in the query.
     * @param accomplishedRange
     *            Only the transfers completed in this interval (inclusively) will be listed. If <code>null</code> then
     *            no end timestamp will be used in the query.
     * @param transferCode
     *            Only the transfers with the given transferCode will be listed. Ignored if <code>null</code> value.
     * @param transferStatus
     *            Only the transfers with the given transferStatus will be listed. Ignored if <code>null</code> value.
     */
    public TransferFilter(final Long creditorAccountId, final Long debtorAccountId,
            final CalendarRange createdRange, final CalendarRange accomplishedRange, final String transferCode,
            final TransferStatus transferStatus) {
        super();
        this.creditorAccountId = creditorAccountId;
        this.debtorAccountId = debtorAccountId;
        this.createdRange = createdRange;
        this.accomplishedRange = accomplishedRange;
        this.transferCode = transferCode;
        this.transferStatus = transferStatus;
    }

    public CalendarRange getAccomplishedRange() {
        return accomplishedRange;
    }

    public CalendarRange getCreatedRange() {
        return createdRange;
    }

    public Long getCreditorAccountId() {
        return creditorAccountId;
    }

    public Long getDebtorAccountId() {
        return debtorAccountId;
    }

    public String getTransferCode() {
        return transferCode;
    }

    public TransferStatus getTransferStatus() {
        return transferStatus;
    }

}
