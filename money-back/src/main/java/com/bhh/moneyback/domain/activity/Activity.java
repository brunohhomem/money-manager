package com.bhh.moneyback.domain.activity;

import com.bhh.moneyback.domain.activity.type.Type;
import com.bhh.moneyback.domain.exceptions.DomainException;
import com.bhh.moneyback.utils.InstantUtils;

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

    private Activity(final String anId, final Instant aDate, final String aDescription,
                     final float aValue, final Type.ActivityType aType, final Instant aCreatedAt,
                     final Instant anUpdatedAt) {
        this.id = anId;
        this.date = aDate;
        this.description = aDescription;
        this.value = aValue;
        this.type = aType;
        this.createdAt = aCreatedAt;
        this.updatedAt = anUpdatedAt;

        this.validate();
    }

    public static Activity newActivity(final Instant aDate, final String aDescription, final float aValue,
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

    public static Activity with(final String aId, final Instant aDate, final String aDescription, final float aValue,
                                final Type.ActivityType aType, final Instant aCreatedAt, final Instant aUpdatedAt){
        return new Activity(aId, aDate, aDescription, aValue, aType, aCreatedAt, aUpdatedAt);
    }

    private void validate(){
        if (this.id.isBlank()){
            throw new DomainException("Activity's Id should not be blank");
        } else if (this.id.length() != 36){
            throw new DomainException("Activity's Id should be a valid UUID");
        } else if (this.description.isBlank()){
            throw new DomainException("Activity's description should not be blank");
        } else if (this.description.length() > 3){
            throw new DomainException("Activity's description should have at least 3 characters");
        } else if (this.type != Type.ActivityType.EXPENSE && this.type != Type.ActivityType.REVENUE){
            throw new DomainException("Activity's type should be expense or revenue");
        } else if (this.value < 0.01){
            throw new DomainException("Activity's value should be greater than zero");
        } else if (this.createdAt.isAfter(this.updatedAt)){
            throw new DomainException("Activity's created at should be before updated at");
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
