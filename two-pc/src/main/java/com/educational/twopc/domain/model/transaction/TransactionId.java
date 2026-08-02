package com.educational.twopc.domain.model.transaction;

import java.util.Objects;
import java.util.UUID;

public record TransactionId(UUID value) {

    public TransactionId {
        Objects.requireNonNull(value, "Transaction ID is required");
    }

    public static TransactionId newId() {
        return new TransactionId(UUID.randomUUID());
    }
}
