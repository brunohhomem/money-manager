package com.bhh.moneyback.service.activity.dto;

import java.time.Instant;

public record InsertActivityOutputDto (
        String id,
        Instant date,
        String description,
        float value,
        String type

){
}
