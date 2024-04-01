package com.bhh.moneyback.service.activity.implementation;

import com.bhh.moneyback.domain.activity.type.Type;
import com.bhh.moneyback.domain.gateway.ActivityGateway;
import com.bhh.moneyback.service.activity.ActivityService;
import com.bhh.moneyback.service.activity.dto.InsertActivityInputDto;
import com.bhh.moneyback.service.activity.dto.InsertActivityOutputDto;
import com.bhh.moneyback.service.activity.dto.ListActivitiesOutputDto;
import com.bhh.moneyback.service.activity.dto.mapper.ActivityToInsertActivityOutputMapper;
import com.bhh.moneyback.service.activity.dto.mapper.ActivityToListActivitiesOutputMapper;
import com.bhh.moneyback.service.activity.dto.mapper.InsertActivityInputToActivityMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ActivityServiceImplementation implements ActivityService {

    private ActivityGateway activityGateway;

    private ActivityServiceImplementation(final ActivityGateway aGateway) {
        this.activityGateway = aGateway;
    }

    @Override
    public InsertActivityOutputDto insertActivity(final InsertActivityInputDto anInput) {
        final var anActivity = InsertActivityInputToActivityMapper.build().apply(anInput);

        this.activityGateway.create(anActivity);

        return ActivityToInsertActivityOutputMapper.build().apply(anActivity);
    }

    @Override
    public void removeActivity(String anId) {
        this.activityGateway.delete(anId);
    }

    @Override
    public List<ListActivitiesOutputDto> listActivities() {
        final var aList = this.activityGateway.findAll();

        return aList.stream()
                .map(a -> ActivityToListActivitiesOutputMapper.build().apply(a))
                .collect(Collectors.toList());
    }

    @Override
    public float calculateBalance() {
        final var aList = this.activityGateway.findAll();

        if (aList == null || aList.isEmpty()){
            return 0;
        }

        return (float) aList.stream()
                .mapToDouble(
                        a -> a.getType() == Type.ActivityType.REVENUE
                                ? a.getValue()
                                : -a.getValue())
                .sum();
    }
}
