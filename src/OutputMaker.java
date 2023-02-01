import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class for taking results from the project runner and making a CSV file
 */

public class OutputMaker {


    public static void makeCSV(ArrayList<String[]> results) throws IOException {

        FileWriter csvFile = new FileWriter("Results.csv");
        csvFile.write("Algorithm, Array Type, No. Elements, Sort Time \n");
        for (String[] result : results) {

            for (int i = 0; i < result.length; i++) {
                csvFile.write(result[i] + ",");
            }
            csvFile.write("\n");
        }
        csvFile.close();
    }
}
