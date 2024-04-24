package com.bhh.moneymanager.domain.activity;

import com.bhh.moneymanager.domain.activity.type.Type;
import com.bhh.moneymanager.utils.InstantUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ActivityTest {

    //Given
    //When
    //Then

    @Test
    public void givenValidParams_whenBuildingNewActivity_thenReturnNewValidActivity(){
        final var aDescription = "Description Test";
        final var aValue = 3.55f;
        final var aDate = InstantUtils.now();
        final var aType = Type.ActivityType.REVENUE;

        final var anActivity = Activity.newActivity(aDate, aDescription, aValue, aType);

        assertNotNull(anActivity);
        assertNotNull(anActivity.getId());
        assertTrue(anActivity.getId().length() == 36);
        assertEquals(aDescription, anActivity.getDescription());
        assertEquals(aDate, anActivity.getDate());
        assertEquals(aValue, anActivity.getValue(), 0.001);
        assertEquals(aType, anActivity.getType());
        assertNotNull(anActivity.getCreatedAt());
        assertNotNull(anActivity.getUpdatedAt());
    }
}