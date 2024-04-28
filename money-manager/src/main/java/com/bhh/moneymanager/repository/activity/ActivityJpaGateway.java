package com.bhh.moneymanager.repository.activity;

import com.bhh.moneymanager.domain.activity.Activity;
import com.bhh.moneymanager.domain.gateway.ActivityGateway;
import com.bhh.moneymanager.repository.activity.jpa.ActivityJpaEntity;
import com.bhh.moneymanager.repository.activity.jpa.ActivityJpaRepository;
import com.bhh.moneymanager.repository.exception.PersistenceException;
import org.springframework.dao.OptimisticLockingFailureException;

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


        try{
            this.activityRepository.save(anActivityEntity);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void delete(final String id) {
        try{
        this.activityRepository.deleteById(id);
        } catch (IllegalArgumentException e){
            throw new PersistenceException(e.getMessage());
        }

    }

    @Override
    public List<Activity> findAll() {
        final var aList = this.activityRepository.findAll();

        return aList.stream().map(ActivityJpaEntity::toModel)
                .collect(Collectors.toList());
    }
}
