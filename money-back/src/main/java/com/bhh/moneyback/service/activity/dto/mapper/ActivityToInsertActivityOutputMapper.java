package com.bhh.moneyback.service.activity.dto.mapper;

import com.bhh.moneyback.domain.activity.Activity;
import com.bhh.moneyback.service.activity.dto.InsertActivityOutputDto;

import java.util.function.Function;

public class ActivityToInsertActivityOutputMapper implements Function<Activity, InsertActivityOutputDto> {

    public static ActivityToInsertActivityOutputMapper build() {
        return new ActivityToInsertActivityOutputMapper();
    }
    @Override
    public InsertActivityOutputDto apply(final Activity input) {
        return new InsertActivityOutputDto(
                input.getId(),
                input.getDate(),
                input.getDescription(),
                input.getValue(),
                input.getType().getValue(),
                input.getCreatedAt(),
                input.getUpdatedAt());
    }
}
