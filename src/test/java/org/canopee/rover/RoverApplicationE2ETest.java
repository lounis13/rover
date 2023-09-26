package org.canopee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.file.Paths;

public class RoverApplicationE2ETest {

    @ParameterizedTest
    @CsvSource({
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
