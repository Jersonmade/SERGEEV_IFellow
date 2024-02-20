import org.junit.jupiter.api.*;

import java.util.Arrays;

public class RunTest {
    //its RunTest origin
    @BeforeEach
    public void beforeEach() {
        System.out.println("Запускается тест");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Тесты отработали");
    }

    @Test
    public void testBubbleSort() {
        int[] unsortedArr = {7, 15, 3, 9, 22, 8, 16, 4, 11, 19};
        int[] sortedArr = {3, 4, 7, 8, 9, 11, 15, 16, 19, 22};

        bubbleSort(unsortedArr);

        Assertions.assertArrayEquals(sortedArr, unsortedArr);
    }

    @Test
    public void testConvertToFarenheit() {
        int celsius = 25;
        float expected = 77.0F;
        float farenheit = convertToFarenheit(celsius);

        Assertions.assertEquals(expected, farenheit);
    }

    public static void bubbleSort(int[] sortArr){
        for (int i = 0; i < sortArr.length - 1; i++) {
            for(int j = 0; j < sortArr.length - i - 1; j++) {
                if(sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
            }
        }
    }

    public static float convertToFarenheit(int celcius) {
        return ((float) (celcius * 9) / 5) + 32;
    }
}
