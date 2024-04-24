package com.bhh.moneymanager.service.activity.dto.mapper;

import com.bhh.moneymanager.domain.activity.Activity;
import com.bhh.moneymanager.service.activity.dto.ListActivitiesOutputDTO;

import java.util.function.Function;

public class ActivityToListActivitiesOutputMapper implements Function<Activity, ListActivitiesOutputDTO> {

    public static ActivityToListActivitiesOutputMapper build(){
        return new ActivityToListActivitiesOutputMapper();
    }

    @Override
    public ListActivitiesOutputDTO apply(final Activity input) {
        return new ListActivitiesOutputDTO(
                input.getId(),
                input.getDate(),
                input.getDescription(),
                input.getValue(),
                input.getType(),
                input.getCreatedAt(),
                input.getUpdatedAt());
    }
}
