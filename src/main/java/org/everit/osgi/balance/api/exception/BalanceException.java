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
package org.everit.osgi.balance.api.exception;

/**
 * Abstract service exception for balance API.
 */
public abstract class BalanceException extends RuntimeException {

    private static final long serialVersionUID = 4304245473885648095L;

    public BalanceException(final String message) {
        super(message);
    }

    public BalanceException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
