package com.bhh.moneymanager.domain.gateway;

import com.bhh.moneymanager.domain.activity.Activity;

import java.util.List;

public interface ActivityGateway {
    public void create(final Activity anActivity);
    public void delete(final Activity anActivity);
    public List<Activity> findAll();
}
