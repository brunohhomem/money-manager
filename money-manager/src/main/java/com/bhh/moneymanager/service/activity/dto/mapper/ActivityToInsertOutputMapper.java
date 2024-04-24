package com.bhh.moneymanager.service.activity.dto.mapper;

import com.bhh.moneymanager.domain.activity.Activity;
import com.bhh.moneymanager.service.activity.dto.InsertActivityOutputDTO;

import java.util.function.Function;

public class ActivityToInsertOutputMapper implements Function<Activity, InsertActivityOutputDTO> {

    public static ActivityToInsertOutputMapper build(){
        return new ActivityToInsertOutputMapper();
    }

    @Override
    public InsertActivityOutputDTO apply(Activity input) {
        return new InsertActivityOutputDTO(
                input.getId(),
                input.getDate(),
                input.getDescription(),
                input.getValue(),
                input.getType(),
                input.getCreatedAt(),
                input.getUpdatedAt());
    }
}
