package org.canopee.rover.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlateauConfigTest {
    @BeforeEach
    public void resetSingleton() throws Exception {
        Field isInitializedField = PlateauConfig.class.getDeclaredField("isInitialized");
        isInitializedField.setAccessible(true);
        isInitializedField.set(PlateauConfig.INSTANCE, false);
    }

    @Test
    public void should_InitializePlateauCorrectly_When_GivenValidDimensions() {
        PlateauConfig.INSTANCE.initialize(7, 8, new TreeMap<>());

        assertEquals(7, PlateauConfig.INSTANCE.getWidth());
        assertEquals(8, PlateauConfig.INSTANCE.getHeight());
    }
}
