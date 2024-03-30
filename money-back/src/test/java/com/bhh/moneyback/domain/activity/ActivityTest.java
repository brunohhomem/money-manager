package com.bhh.moneyback.domain.activity;

import com.bhh.moneyback.domain.activity.type.Type;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ActivityTest {

    // Given
    // When
    // Then
    @Test
    public void givenValidParams_whenBuildingNewActivity_thenReturnNewValidActivity() {

        final var aDescription = "A description";
        final var aValue = 3.55f;
        final var aDate = Instant.now();
        final var aType = Type.REVENUE;

        final var anActivity = Activity.newActivity(aDate, aDescription, aValue, aType);

        assertNotNull(anActivity);
        assertNotNull(anActivity.getId());
        assertEquals(36, anActivity.getId().length());
        assertEquals(aDescription, anActivity.getDescription());
        assertEquals(aDate, anActivity.getDate());
        assertEquals(aValue, anActivity.getValue(), 0.001);
        assertEquals(aType, anActivity.getType());
        assertNotNull(anActivity.getCreatedAt());
        assertNotNull(anActivity.getUpdatedAt());
    }

}
