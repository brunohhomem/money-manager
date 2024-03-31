package com.bhh.moneyback.service.activity;

import com.bhh.moneyback.service.activity.dto.InsertActivityInputDto;
import com.bhh.moneyback.service.activity.dto.InsertActivityOutputDto;
import com.bhh.moneyback.service.activity.dto.ListActivitiesOutputDto;

import java.util.List;

public interface ActivityService {
    public InsertActivityOutputDto insertActivity(final InsertActivityInputDto anInput);
    public void removeActivity(final String anId);
    public List<ListActivitiesOutputDto> listActivities();
    public float calculateBalance();


}
