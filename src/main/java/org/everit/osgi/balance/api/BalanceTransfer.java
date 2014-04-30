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
import java.sql.Timestamp;
import java.util.Calendar;

public class BalanceTransfer implements Serializable {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = -3058892777928892426L;

    private static Calendar convert(final Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        return calendar;
    }

    private final long transferId;

    private final String transferPairId;

    private final Calendar createdAt;

    private final Calendar accomplishedAt;

    private final String transferCode;

    private final long creditorAccountId;

    private final long debtorAccountId;

    private final BigDecimal amount;

    private final TransferStatus transferStatus;

    private final BigDecimal lastCreditorAvailableBalance;

    private final BigDecimal lastCreditorBlockedBalance;

    private final String notes;

    private final long resourceId;

    public BalanceTransfer(final long transferId, final String transferPairId, final Calendar createdAt,
            final Calendar accomplishedAt, final String transferCode, final BigDecimal amount,
            final TransferStatus transferStatus, final BigDecimal lastCreditorAvailableBalance,
            final BigDecimal lastCreditorBlockedBalance, final String notes, final long creditorAccountId,
            final long debtorAccountId, final long resourceId) {
        super();
        this.transferId = transferId;
        this.transferPairId = transferPairId;
        this.createdAt = createdAt;
        this.accomplishedAt = accomplishedAt;
        this.transferCode = transferCode;
        this.amount = amount;
        this.transferStatus = transferStatus;
        this.lastCreditorAvailableBalance = lastCreditorAvailableBalance;
        this.lastCreditorBlockedBalance = lastCreditorBlockedBalance;
        this.notes = notes;
        this.creditorAccountId = creditorAccountId;
        this.debtorAccountId = debtorAccountId;
        this.resourceId = resourceId;
    }

    public BalanceTransfer(final Long transferId, final String transferPairId, final Timestamp createdAt,
            final Timestamp accomplishedAt, final String transferCode, final Double amount,
            final String transferStatus, final Double lastCreditorAvailableBalance,
            final Double lastCreditorBlockedBalance, final String notes, final Long creditorAccountId,
            final Long debtorAccountId, final Long resourceId) {
        this(
                transferId,
                transferPairId,
                BalanceTransfer.convert(createdAt),
                BalanceTransfer.convert(accomplishedAt),
                transferCode,
                BigDecimal.valueOf(amount),
                TransferStatus.valueOf(transferStatus),
                BigDecimal.valueOf(lastCreditorAvailableBalance),
                BigDecimal.valueOf(lastCreditorBlockedBalance),
                notes,
                creditorAccountId,
                debtorAccountId,
                resourceId);
    }

    public Calendar getAccomplishedAt() {
        return accomplishedAt;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public long getCreditorAccountId() {
        return creditorAccountId;
    }

    public long getDebtorAccountId() {
        return debtorAccountId;
    }

    public BigDecimal getLastCreditorAvailableBalance() {
        return lastCreditorAvailableBalance;
    }

    public BigDecimal getLastCreditorBlockedBalance() {
        return lastCreditorBlockedBalance;
    }

    public String getNotes() {
        return notes;
    }

    public long getResourceId() {
        return resourceId;
    }

    public String getTransferCode() {
        return transferCode;
    }

    public long getTransferId() {
        return transferId;
    }

    public String getTransferPairId() {
        return transferPairId;
    }

    public TransferStatus getTransferStatus() {
        return transferStatus;
    }

}
