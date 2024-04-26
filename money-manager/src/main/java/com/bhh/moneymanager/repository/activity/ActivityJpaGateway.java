package com.bhh.moneymanager.repository.activity;

import com.bhh.moneymanager.domain.activity.Activity;
import com.bhh.moneymanager.domain.gateway.ActivityGateway;
import com.bhh.moneymanager.repository.activity.jpa.ActivityJpaEntity;
import com.bhh.moneymanager.repository.activity.jpa.ActivityJpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ActivityJpaGateway implements ActivityGateway {

    private ActivityJpaRepository activityRepository;

    private ActivityJpaGateway(final ActivityJpaRepository aRepository){
        this.activityRepository = aRepository;
    }

    private static ActivityJpaGateway build(final ActivityJpaRepository aRepository){
        return new ActivityJpaGateway(aRepository);
    }

    @Override
    public void create(final Activity anActivity) {
        final var anActivityEntity = ActivityJpaEntity.from(anActivity);

        this.activityRepository.save(anActivityEntity);
    }

    @Override
    public void delete(final String id) {
        this.activityRepository.deleteById(id);
    }

    @Override
    public List<Activity> findAll() {
        final var aList = this.activityRepository.findAll();

        return aList.stream().map(ActivityJpaEntity::toModel)
                .collect(Collectors.toList());
    }
}
