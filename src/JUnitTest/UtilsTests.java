package JUnitTest;

import ProjectUtils.AlgorithmTestResults;
import ProjectUtils.ArrayBuilder;
import ProjectUtils.StopWatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the utils classes. Didn't have time to research how to test exception throwing properly or if
 * files are placed on the hard drive (relative paths for different operating systems etc).
 */
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

    @Test
    void testAddData() {

        String expectedName = "ExpectedAlgorithm";
        int expectedOrderingTypes = 1;
        int expectedSizeDataLength = 1;

        AlgorithmTestResults testResults = new AlgorithmTestResults(expectedName, expectedOrderingTypes, expectedSizeDataLength);

        int expectedIndex = 0;
        int arraySize = 3;
        int[] expectedSizeData = {1, 2, 3};
        String[] expectedTimingData = {"10", "20", "30"};

        testResults.addData(expectedIndex, expectedSizeData, expectedTimingData);

        for (int i = 0; i < arraySize; i++) {
            assertEquals(expectedSizeData[i], testResults.getArraySizes(expectedIndex)[i]);
            assertEquals(expectedTimingData[i], testResults.getTimingData(expectedIndex)[i]);
        }
    }

    @Test
    void testStopWatchStartsAndEnds() {

        StopWatch watch = new StopWatch();
        watch.start();

        int wasteSomeTime = 100000000;
        for (int i = 0; i < wasteSomeTime; i++) {
            for (int j = 0; j < wasteSomeTime; j++) {
                int nothing = 1 + 1;
            }
        }
        watch.end();
        System.out.println(watch.getDuration());
        assertTrue(Integer.parseInt(watch.getDuration()) > 0);
    }
}
