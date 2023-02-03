import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * Class for taking testResults from the project runner and making a CSV file
 */

public class OutputMaker {

    public static void makeCSV(HashMap<String, AlgorithmTestResults> results) throws IOException {

        for (AlgorithmTestResults result : results.values()) {

            //get the algorithm name and make a new file for that algorithm's data
            String fileName = result.getAlgorithmName() + ".csv";
            FileWriter csvFile = new FileWriter(fileName);

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
}
