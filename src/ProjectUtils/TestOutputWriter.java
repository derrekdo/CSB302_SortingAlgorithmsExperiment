package ProjectUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class for taking fileTestResults from the project runner and making a CSV file
 */

public class TestOutputWriter {

    public static void makeOutputCSVFile(HashMap<String, ProjectUtils.AlgorithmTestResults> results) throws IOException {

        for (ProjectUtils.AlgorithmTestResults result : results.values()) {

            //get the algorithm name and make a new file for that algorithm's data
            String fileName = result.getAlgorithmName();
            FileWriter csvFile = new FileWriter(fileName + ".csv");

            //set up and write the header row
            String headerLine = fileName + ",";

            String[] orderingTypes = result.getOrderingTypes();
            for (int i = 0; i < orderingTypes.length; i++) {
                headerLine += orderingTypes[i] + ", ,";
            }

            csvFile.write(headerLine + "\n");

            //iterate through the data and append it to a string that will be written to the file
            String dataLine = " ,";
            for (int i = 0; i < orderingTypes.length; i++) {

                int[] arraySizes = result.getArraySizes(i);
                String[] timingData = result.getTimingData(i);

                for (int j = 0; j < arraySizes.length; j++) {

                    dataLine += arraySizes[j] + ",";
                    dataLine += timingData[j] + ",";
                    dataLine += "\n";
                    csvFile.write(dataLine);
                    dataLine = " ,";
                }
            }
            csvFile.close();
        }
    }

    /**
     * Basic helper function for printing out the contents of our 'print' results data.
     * This is different from the file test results because that data object is processed in another class
     * to make .csv files. This function just prints the test results to terminal
     *
     * @param printResults a list of strings containing the formatted results of each test.
     */
    public static void printResults(ArrayList<String> printResults) {

        ProjectUtils.StopWatch watch = new ProjectUtils.StopWatch();

        watch.start();

        for (String result : printResults) {
            System.out.println(result);
        }
        watch.end();

        System.out.println("print duration: " + watch.getDuration());
    }
}
