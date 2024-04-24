package com.bhh.moneymanager.service.activity.dto;

import java.time.Instant;

public record InsertActivityOutputDTO(
        String id,
        Instant Date,
        String description,
        float value,
        com.bhh.moneymanager.domain.activity.type.Type.ActivityType type,
        Instant createdAt,
        Instant updatedAt
) {
}
