package com.bhh.moneymanager.service.activity.dto.mapper;

import com.bhh.moneymanager.domain.activity.Activity;
import com.bhh.moneymanager.domain.activity.type.Type;
import com.bhh.moneymanager.service.activity.dto.InsertActivityInputDTO;
import com.bhh.moneymanager.service.exception.ServiceException;

import java.util.function.Function;

public class InsertActivityInputToActivityMapper implements Function<InsertActivityInputDTO, Activity> {

    public static InsertActivityInputToActivityMapper build(){
        return new InsertActivityInputToActivityMapper();
    }

    @Override
    public Activity apply(final InsertActivityInputDTO input) {

        if (input.type().equals(Type.ActivityType.REVENUE.toString())){
            final var anActivity = Activity.newActivity(input.date(), input.description(), input.value(), Type.ActivityType.REVENUE);

            return anActivity;
        } else if (input.type().equals(Type.ActivityType.EXPANSE.toString())) {
            final var anActivity = Activity.newActivity(input.date(), input.description(), input.value(), Type.ActivityType.EXPANSE);

            return anActivity;

        }else {
            throw new ServiceException("Invalid activity type");
        }
    }
}
