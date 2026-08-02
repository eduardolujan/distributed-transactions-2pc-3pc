package com.educational.threepc.domain.model.transfer;

import com.educational.threepc.domain.model.account.AccountId;
import com.educational.threepc.domain.model.money.Money;

import java.util.Objects;

public final class Transfer {

    private final TransferId id;
    private final AccountId sourceAccountId;
    private final AccountId destinationAccountId;
    private final Money amount;

    public Transfer(TransferId id, AccountId sourceAccountId, AccountId destinationAccountId, Money amount) {
        this.id = Objects.requireNonNull(id, "Transfer ID is required");
        this.sourceAccountId = Objects.requireNonNull(sourceAccountId, "Source account ID is required");
        this.destinationAccountId = Objects.requireNonNull(destinationAccountId, "Destination account ID is required");
        this.amount = Objects.requireNonNull(amount, "Transfer amount is required");
        if (sourceAccountId.equals(destinationAccountId)) {
            throw new IllegalArgumentException("Source and destination accounts must differ");
        }
        if (!amount.isPositive()) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }
    }

    public TransferId id() {
        return id;
    }

    public AccountId sourceAccountId() {
        return sourceAccountId;
    }

    public AccountId destinationAccountId() {
        return destinationAccountId;
    }

    public Money amount() {
        return amount;
    }
}
