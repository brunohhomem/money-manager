package com.bhh.moneymanager.domain.activity;

import com.bhh.moneymanager.domain.activity.type.Type;
import com.bhh.moneymanager.utils.InstantUtils;

import java.time.Instant;
import java.util.UUID;

public class Activity {

    private String id;
    private Instant date;
    private String description;
    private float value;
    private Type.ActivityType type;
    private Instant createdAt;
    private Instant updatedAt;

    private Activity(final String anId, final Instant aDate, final String aDescription, float aValue,
                     final Type.ActivityType aType, final Instant aCreatedAt, final Instant aUpdatedAt) {
        this.id = anId;
        this.date = aDate;
        this.description = aDescription;
        this.value = aValue;
        this.type = aType;
        this.createdAt = aCreatedAt;
        this.updatedAt = aUpdatedAt;

        this.validate();
    }

    public static Activity newActivity(final Instant aDate, final String aDescription, float aValue,
                              final Type.ActivityType aType){
        return new Activity(
                UUID.randomUUID().toString().toLowerCase(),
                aDate,
                aDescription,
                aValue,
                aType,
                InstantUtils.now(),
                InstantUtils.now());
    }

    public static Activity with(final String anId, final Instant aDate, final String aDescription,
                                float aValue, final Type.ActivityType aType, final Instant aCreatedAt, final Instant aUpdatedAt){
        return new Activity(anId, aDate, aDescription, aValue, aType, aCreatedAt, aUpdatedAt);
    }

    public void validate(){
        if (this.id.isBlank() && this.id.length() != 36){
            throw new RuntimeException("Activity's ID should be valid");
        }

        if (this.description.isBlank() && this.description.length() > 3){
            throw new RuntimeException("Description should be valid");
        }

        if (this.type != Type.ActivityType.EXPANSE && this.type != Type.ActivityType.REVENUE){
            throw new RuntimeException("Activity's Type should be either EXPANSE or REVENUE");
        }

        if (this.value < 0.01){
            throw new RuntimeException("Activity's value should be greater than zero");
        }

        if ((this.createdAt.isAfter(this.updatedAt))){
            throw new RuntimeException("Activity's creation date should be before updated");
        }
    }

    public String getId() {
        return id;
    }

    public Instant getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public float getValue() {
        return value;
    }

    public Type.ActivityType getType() {
        return type;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", type=" + type +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
