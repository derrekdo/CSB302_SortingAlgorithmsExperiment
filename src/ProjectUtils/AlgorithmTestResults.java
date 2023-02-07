package ProjectUtils;

/**
 * Basic class for housing test results so that saving and retrieving them is easier
 **/
public class AlgorithmTestResults {

    private String algorithmName;
    private String[] orderingTypes; // random, 1/2 random, reverse ordered etc
    private int[][] arraySizeData;
    private String[][] sortTimingData;


    public AlgorithmTestResults(String name, int numOrderingTypes, int numArrays) {

        algorithmName = name;
        orderingTypes = new String[numOrderingTypes];
        arraySizeData = new int[numOrderingTypes][numArrays];
        sortTimingData = new String[numOrderingTypes][numArrays];
    }

    public void addData(int typeIndex, int[] sizeData, String[] timingData) {

        arraySizeData[typeIndex] = sizeData;
        sortTimingData[typeIndex] = timingData;
    }

    public void addOrderingType(int typeIndex, String typeName) {
        orderingTypes[typeIndex] = typeName;
    }

    public String[] getOrderingTypes() {
        return orderingTypes;
    }

    public int[] getArraySizes(int index) {
        return arraySizeData[index];
    }

    public String[] getTimingData(int index) {
        return sortTimingData[index];
    }

    public String getAlgorithmName() {
        return algorithmName;
    }
}
