package com.bhh.moneymanager.service.activity;

import com.bhh.moneymanager.service.activity.dto.InsertActivityInputDTO;
import com.bhh.moneymanager.service.activity.dto.InsertActivityOutputDTO;
import com.bhh.moneymanager.service.activity.dto.ListActivitiesOutputDTO;

import java.util.List;

public interface ActivityService {

    public InsertActivityOutputDTO insertActivity(final InsertActivityInputDTO input);

    public void removeActivity(final String id);

    public List<ListActivitiesOutputDTO> listActivities();
    
    public float calculateBalance();

}

