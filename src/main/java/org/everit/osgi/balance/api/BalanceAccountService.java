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

import org.everit.commons.selection.Limit;
import org.everit.commons.selection.LimitedResult;

/**
 * Service interface for balance account management.
 */
public interface BalanceAccountService {

    /**
     * Activates an inactive account.
     *
     * @param accountId
     *            the ID of the account to activate.
     * @return the number of activated accounts
     */
    long activateAccount(long accountId);

    /**
     * Creates an active/inactive account.
     *
     * @param ownerResourceId
     *            The resource ID of the owner of the account, if <code>null</code> a new resource will be created.
     * @param active
     *            To create an active or an inactive account.
     * @return The ID of the created account.
     */
    long createAccount(Long ownerResourceId, boolean active);

    /**
     * Deactivates an active account.
     *
     * @param accountId
     *            The ID of the account to deactivate.
     * @return the number of activated accounts
     */
    long deactivateAccount(long accountId);

    /**
     * Finds an account by its id.
     *
     * @param accountId
     *            The id of the account to be found.
     * @return An {@link Account} or <code>null</code> if there is no matches.
     */
    BalanceAccount findAccountById(long accountId);

    /**
     * Finds an account by its resource id.
     *
     * @param resourceId
     *            the resource id of the account to be found
     * @return the account or <code>null</code> if there is no matches
     */
    BalanceAccount findAccountByResourceId(long resourceId);

    /**
     * Returns the {@link LimitedResult} of accounts ordered by accountId.
     *
     * @param ownerResourceId
     *            The resource ID of the owner of the interested accounts or <code>null</code> if all accounts are
     *            interested.
     * @param limit
     *            the limit of the query, cannot be <code>null</code>
     * @return The {@link LimitedResult} of accounts.
     */
    LimitedResult<BalanceAccount> findAccountsByOwnerResourceId(Long ownerResourceId, Limit limit);

    /**
     * Locks the given accounts to be able to create transfers on them. This method must be invoked before a balance of
     * an account will be changed by calling the following methods:
     * <ul>
     * <li>{@link BalanceTransferService#createInstantTransfer(String, long, long, java.math.BigDecimal, String)}</li>
     * <li>{@link BalanceTransferService#createBlockedTransfer(String, long, long, java.math.BigDecimal, String)}</li>
     * <li>{@link BalanceTransferService#acceptBlockedTransfer(long)}</li>
     * <li>{@link BalanceTransferService#rejectBlockedTransfer(long)}</li>
     * </ul>
     * <p>
     * <b>Note 1</b>: A transaction must be available (mandatory) while calling this method, otherwise an exception will
     * be thrown!
     * </p>
     * <p>
     * <b>Note 2</b>: A deadlock could happen if this method is invoked from different places at the same time!
     * </p>
     *
     * @param accountIds
     *            the ID of the accounts to lock
     * @return the locked account IDs
     */
    long[] lockAccounts(long... accountIds);

}
