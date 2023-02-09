package ProjectUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class for taking fileTestResults from the project runner and making a CSV file
 */

public class TestOutputWriter {

    /**
     * Primary function for writing the test results to a csv file. An individual file is created for each
     * algorithm type. The results will contain 5(array, time spent) sets of data coresponding to the array ordering.
     *
     * @param results A hashmap of test result objects using the algorithm name as a key
     * @throws IOException if the function is unable to write to the disk
     */
    public static void makeOutputCSVFile(HashMap<String, ProjectUtils.AlgorithmTestResults> results) throws IOException {

        for (ProjectUtils.AlgorithmTestResults result : results.values()) {

            //get the algorithm name and make a new file for that algorithm's data
            String fileName = result.getAlgorithmName();
            FileWriter csvFile = new FileWriter(fileName + ".csv");

            //set up and write the header row
            String headerLine = "Algorithm: " + fileName + ",";

            String[] orderingTypes = result.getOrderingTypes();
            for (int i = 0; i < orderingTypes.length; i++) {
                headerLine += "array: " + orderingTypes[i] + ",time(ms),";
            }

            //write the header
            csvFile.write(headerLine + "\n");

            int numArrays = result.getArraySizes(0).length;
            int numTypes = orderingTypes.length;

            //iterate through the data and append it to a string that will be written to the file
            String dataLine = " ,";
            for (int i = 0; i < numArrays; i++) {

                for (int j = 0; j < numTypes; j++) {

                    int[] arraySizes = result.getArraySizes(j);
                    String[] timingData = result.getTimingData(j);

                    dataLine += arraySizes[i] + ",";
                    dataLine += timingData[i] + ",";
                }

                dataLine += "\n";
                csvFile.write(dataLine);
                dataLine = " ,";
            }
            //close up the file so it can be opened by the user
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
