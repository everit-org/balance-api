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

import java.io.Serializable;
import java.math.BigDecimal;

public class BalanceAccount implements Serializable {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 5961579688483349050L;

    private final long accountId;

    private final boolean active;

    private final BigDecimal availableBalance;

    private final BigDecimal blockedBalance;

    private final long ownerResourceId;

    private final long resourceId;

    public BalanceAccount(final long accountId, final boolean active, final double availableBalance,
            final double blockedBalance, final long ownerResourceId, final long resourceId) {
        super();
        this.accountId = accountId;
        this.active = active;
        this.availableBalance = BigDecimal.valueOf(availableBalance);
        this.blockedBalance = BigDecimal.valueOf(blockedBalance);
        this.ownerResourceId = ownerResourceId;
        this.resourceId = resourceId;
    }

    public long getAccountId() {
        return accountId;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public BigDecimal getBlockedBalance() {
        return blockedBalance;
    }

    public long getOwnerResourceId() {
        return ownerResourceId;
    }

    public long getResourceId() {
        return resourceId;
    }

    public boolean isActive() {
        return active;
    }

}
