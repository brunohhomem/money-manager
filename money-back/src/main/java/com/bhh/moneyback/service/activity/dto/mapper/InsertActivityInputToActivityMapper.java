package com.bhh.moneyback.service.activity.dto.mapper;

import com.bhh.moneyback.domain.activity.Activity;
import com.bhh.moneyback.domain.activity.type.Type;
import com.bhh.moneyback.service.activity.dto.InsertActivityInputDto;
import com.bhh.moneyback.service.exceptions.ServiceException;

import java.util.function.Function;

public class InsertActivityInputToActivityMapper implements Function<InsertActivityInputDto, Activity> {

    public static InsertActivityInputToActivityMapper build(){
        return new InsertActivityInputToActivityMapper();
    }
    @Override
    public Activity apply(final InsertActivityInputDto input) {
        if (input.type().equals(Type.ActivityType.REVENUE)){
            final var anActivity = Activity.newActivity(
                    input.date(),
                    input.description(),
                    input.value(),
                    Type.ActivityType.REVENUE);
            return anActivity;
        } else if (input.type().equals(Type.ActivityType.EXPENSE)){
            final var anActivity = Activity.newActivity(
                    input.date(),
                    input.description(),
                    input.value(),
                    Type.ActivityType.EXPENSE);
            return anActivity;
        } else {
            throw new ServiceException("Invalid activity type");
        }
    }
}
