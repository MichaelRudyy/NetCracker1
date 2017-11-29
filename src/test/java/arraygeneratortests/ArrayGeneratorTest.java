package arraygeneratortests;

import com.netcracker.generators.ArrayGenerator;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Michael Rudyy on 02-Nov-17.
 */

public class ArrayGeneratorTest {
    private int lenght = 10;

    @Test
    public void testSortedArray() {
        int[] array = ArrayGenerator.getSortedArray(lenght);
        int[] testArray = ArrayGenerator.getSortedArray(lenght);
        Arrays.sort(testArray);
        assertArrayEquals(testArray, array);
    }

    @Test
    public void testSortedWithLastRandomElementArray() {

        int[] array = ArrayGenerator.getSortedWithLastRandomElementArray(lenght);
        int[] testArray = ArrayGenerator.getSortedWithLastRandomElementArray(lenght);

        array[lenght - 1] = lenght + 1;
        testArray[lenght - 1] = lenght + 1;

        Arrays.sort(array);

        assertArrayEquals(array, testArray);
    }

    @Test
    public void testReverseSortedArray() {
        int[] array = ArrayGenerator.getReverseSortedArray(lenght);
        int[] sortedArray = array.clone();

        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }

        Arrays.sort(sortedArray);

        assertArrayEquals(array, sortedArray);
    }
}
