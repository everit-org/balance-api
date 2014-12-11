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

/**
 * The statuses of the transfers.
 */
public enum TransferStatus {

    /**
     * A successful transfer. Successful transfer counts in the available balance of the account.
     */
    SUCCESSFUL,

    /**
     * A blocked transfer that can be accepted ({@link #SUCCESSFUL}) or rejected ({@link #REJECTED}). Blocked transfers
     * counts in the blocked balance.
     */
    BLOCKED,

    /**
     * A rejected transfer. Rejected transfers are not count in the balances.
     */
    REJECTED;

    @Override
    public String toString() {
        return TransferStatus.class.getName() + "." + super.toString();
    }

}
