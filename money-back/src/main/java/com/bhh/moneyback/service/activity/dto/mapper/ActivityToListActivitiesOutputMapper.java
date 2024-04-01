package com.bhh.moneyback.service.activity.dto.mapper;

import com.bhh.moneyback.domain.activity.Activity;
import com.bhh.moneyback.service.activity.dto.ListActivitiesOutputDto;

import java.util.function.Function;

public class ActivityToListActivitiesOutputMapper implements Function<Activity, ListActivitiesOutputDto> {

    public static ActivityToListActivitiesOutputMapper build() {
        return new ActivityToListActivitiesOutputMapper();
    }

    @Override
    public ListActivitiesOutputDto apply(final Activity input) {
        return new ListActivitiesOutputDto(
                input.getId(),
                input.getDate(),
                input.getDescription(),
                input.getValue(),
                input.getType().getValue(),
                input.getCreatedAt(),
                input.getUpdatedAt());
    }
}