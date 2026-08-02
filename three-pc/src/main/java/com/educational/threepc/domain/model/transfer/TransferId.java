package com.educational.threepc.domain.model.transfer;

import java.util.Objects;
import java.util.UUID;

public record TransferId(UUID value) {

    public TransferId {
        Objects.requireNonNull(value, "Transfer ID is required");
    }

    public static TransferId newId() {
        return new TransferId(UUID.randomUUID());
    }
}
