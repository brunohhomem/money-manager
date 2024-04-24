package com.bhh.moneymanager.service.activity.implementation;

import com.bhh.moneymanager.domain.activity.type.Type;
import com.bhh.moneymanager.domain.gateway.ActivityGateway;
import com.bhh.moneymanager.service.activity.ActivityService;
import com.bhh.moneymanager.service.activity.dto.InsertActivityInputDTO;
import com.bhh.moneymanager.service.activity.dto.InsertActivityOutputDTO;
import com.bhh.moneymanager.service.activity.dto.ListActivitiesOutputDTO;
import com.bhh.moneymanager.service.activity.dto.mapper.ActivityToInsertOutputMapper;
import com.bhh.moneymanager.service.activity.dto.mapper.ActivityToListActivitiesOutputMapper;
import com.bhh.moneymanager.service.activity.dto.mapper.InsertActivityInputToActivityMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ActivityServiceImplementation implements ActivityService {

    private ActivityGateway activityGateway;

    private ActivityServiceImplementation(final ActivityGateway aGateway){
        this.activityGateway = aGateway;
    }


    public static ActivityServiceImplementation build(final ActivityGateway aGateway) {
        return new ActivityServiceImplementation(aGateway);
    }

    @Override
    public InsertActivityOutputDTO insertActivity(final InsertActivityInputDTO input) {
        final var anActivity = InsertActivityInputToActivityMapper.build().apply(input);

        this.activityGateway.create(anActivity);

        return ActivityToInsertOutputMapper.build().apply(anActivity);
    }

    @Override
    public void removeActivity(String id) {
        this.activityGateway.delete(id);
    }

    @Override
    public List<ListActivitiesOutputDTO> listActivities() {
        final var aList = this.activityGateway.findAll();

        return aList.stream().map(a -> ActivityToListActivitiesOutputMapper
                .build().apply(a)).collect(Collectors.toList());
    }

    @Override
    public float calculateBalance() {
        final var aList = this.activityGateway.findAll();

        if (aList == null || aList.isEmpty()){
            return 0;
        }

        return (float) aList.stream().mapToDouble(a-> a.getType() == Type.ActivityType.REVENUE ? a.getValue() : -a.getValue())
                .sum();
    }
}
