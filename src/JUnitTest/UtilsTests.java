package JUnitTest;

import ProjectUtils.AlgorithmTestResults;
import ProjectUtils.ArrayBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UtilsTests {

    @Test
    void testArrayBuilderIndices() {
        int[] expectedIndices = {0, 1, 2, 3, 4, 5};

        for (ArrayBuilder.arrayTypes type : ArrayBuilder.arrayTypes.values()) {
            assertEquals(type.getIndex(), expectedIndices[type.getIndex()]);
        }
    }

    @Test
    void testArrayBuilderDoesntMakeEmptyArrays() {

        HashMap<ArrayBuilder.arrayTypes, int[][]> allArrays = ArrayBuilder.buildAllArrays();

        for (ArrayBuilder.arrayTypes type : ArrayBuilder.arrayTypes.values()) {

            int[][] arraysOfAType = allArrays.get(type);

            for (int i = 0; i < arraysOfAType.length; i++) {
                for (int j = 0; j < arraysOfAType[i].length; j++) {
                    Assertions.assertNotNull(arraysOfAType[i][j]);
                }
            }
        }
    }

    @Test
    void testArrayBuilderBuildsRandomArrays() {

        //make two sets of randomized arrays
        int[][] randomArrays = ArrayBuilder.buildRandomArrays();
        int[][] otherRandomArrays = ArrayBuilder.buildRandomArrays();

        int sameTracker = 0;
        int totalsTracker = 0;

        //compare them and see how similar they are
        for (int i = 0; i < randomArrays.length; i++) {

            int[] innerArray = randomArrays[i];
            int[] otherInnerArray = otherRandomArrays[i];

            for (int j = 0; j < innerArray.length; j++) {

                totalsTracker++;

                if (innerArray[j] == otherInnerArray[j]) {
                    sameTracker++;
                }
            }
        }

        Assertions.assertNotEquals(sameTracker, totalsTracker);
    }

    @Test
    void testAlgorithmTestResultsInitializes() {

        String expectedName = "ExpectedAlgorithm";
        int expectedOrderingTypes = 5;
        int expectedSizeDataLength = 7;
        int expectedValue = 0;

        AlgorithmTestResults testResults = new AlgorithmTestResults(expectedName, expectedOrderingTypes, expectedSizeDataLength);
        assertEquals(expectedName, testResults.getAlgorithmName());

        int[] sizes = testResults.getArraySizes(0);
        for (int i = 0; i < sizes.length; i++) {
            assertEquals(expectedValue, sizes[i]);
        }

        String[] timeDatas = testResults.getTimingData(0);
        for (int i = 0; i < timeDatas.length; i++) {
            assertNull(timeDatas[i]);
        }
    }
}
