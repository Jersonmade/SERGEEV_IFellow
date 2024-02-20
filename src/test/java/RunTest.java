import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RunTest {
    //its RunTest origin

    private static int[] arr = {7, 15, 3, 9, 22, 8, 16, 4, 11, 19};

    @BeforeAll
    public static void beforeAll() {
        Arrays.sort(arr);
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Тесты отработали");
    }
    @Test
    public void testBinarySearch_existing() {
        int value = 7;

        int expected = 2;
        int actual = binSearch(arr, value);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void negativeTestBinarySearch_existing() {
        int value = 7;

        int expected = 1;
        int actual = binSearch(arr, value);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testBinarySearch_nonExisting() {
        int value = 99;

        int expected = -1;
        int actual = binSearch(arr, value);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void negativeTestBinarySearch_nonExisting() {
        int value = 99;

        int expected = 5;
        int actual = binSearch(arr, value);

        Assertions.assertEquals(expected, actual);
    }

    private static int binSearch(int[] sortedArray, int value) {
        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (sortedArray[mid] < value) {
                low = mid + 1;
            } else if (sortedArray[mid] > value) {
                high = mid - 1;
            } else if (sortedArray[mid] == value) {
                return mid;
            }
        }

        return -1;
    }
}
