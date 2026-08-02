package com.educational.twopc.domain.model.account;

import com.educational.twopc.domain.model.money.Money;

import java.util.Objects;

public final class Account {

    private final AccountId id;
    private Money balance;

    public Account(AccountId id, Money openingBalance) {
        this.id = Objects.requireNonNull(id, "Account ID is required");
        this.balance = Objects.requireNonNull(openingBalance, "Opening balance is required");
    }

    public AccountId id() {
        return id;
    }

    public Money balance() {
        return balance;
    }

    public void debit(Money amount) {
        Objects.requireNonNull(amount, "Debit amount is required");
        if (!amount.isPositive()) {
            throw new IllegalArgumentException("Debit amount must be positive");
        }
        if (amount.isGreaterThan(balance)) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance = balance.subtract(amount);
    }

    public void credit(Money amount) {
        Objects.requireNonNull(amount, "Credit amount is required");
        if (!amount.isPositive()) {
            throw new IllegalArgumentException("Credit amount must be positive");
        }
        balance = balance.add(amount);
    }
}
