package org.canopee.rover;

import org.canopee.rover.config.PlateauConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Paths;

public class RoverApplicationE2ETest {

    @BeforeEach
    public void setup() throws IllegalAccessException, NoSuchFieldException {
        Field isInitializedField = PlateauConfig.class.getDeclaredField("isInitialized");
        isInitializedField.setAccessible(true);
        isInitializedField.set(PlateauConfig.INSTANCE, false);
    }

    @ParameterizedTest
    @CsvSource({
            "scenario0_input.txt, 1 2 W",
            "scenario1_input.txt, 1 3 N|5 1 E",
    })
    public void testScenarios(String inputFileName, String expectedOutput) throws IOException {
        String[] expectedOutputs = expectedOutput.split("\\|");

        // Load test input file from resources
        String inputFilePath = Paths.get("src/test/resources", inputFileName).toString();

        // Capture the output of the RoverApplication
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        // Run the application
        RoverApplication.main(new String[]{inputFilePath});

        // Check the output
        String[] lines = out.toString().split(System.lineSeparator());
        Assertions.assertEquals(expectedOutputs.length, lines.length);
        for (int i = 0; i < expectedOutputs.length; i++) {
            Assertions.assertEquals(expectedOutputs[i], lines[i]);
        }
    }
}
