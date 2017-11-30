package sorttests;

import com.netcracker.sorts.*;
import com.netcracker.sorts.abstracts.AbstractBubbleSort;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Michael Rudyy on 02-Nov-17.
 */

public class SortTest {

    @Test
    public void testBubbleSort() {
        int[] testArray = new int[]{5, 3, 7, 2, 3};
        int[] sortArray = testArray.clone();
        Arrays.sort(sortArray);
        //BubbleSort sort = BubbleSort.getInstance();
        //sort.sort(testArray);
        assertArrayEquals(sortArray, testArray);
    }

    @Test
    public void testBubbleSortReverse(){
        int[] testArray = new int[]{5, 3, 7, 2, 3};
        int[] sortArray = testArray.clone();
        Arrays.sort(sortArray);
        BubbleSortReverse sort = BubbleSortReverse.getInstance();
        sort.sort(testArray);
        assertArrayEquals(sortArray, testArray);
    }

    @Test
    public void testExchangeSort(){
        int[] testArray = new int[]{5, 3, 7, 2, 3};
        int[] sortArray = testArray.clone();
        Arrays.sort(sortArray);
        ExchangeSort sort = ExchangeSort.getInstance();
        sort.sort(testArray);
        assertArrayEquals(sortArray, testArray);
    }

    @Test
    public void testMergeSort(){
        int[] testArray = new int[]{5, 3, 7, 2, 3};
        int[] sortArray = testArray.clone();
        Arrays.sort(sortArray);
        MergeSort sort = MergeSort.getInstance();
        sort.sort(testArray);
        assertArrayEquals(sortArray, testArray);
    }

    @Test
    public void testQuickSort(){
        int[] testArray = new int[]{5, 3, 7, 2, 3};
        int[] sortArray = testArray.clone();
        Arrays.sort(sortArray);
        QuickSort sort = QuickSort.getInstance();
        sort.sort(testArray);
        assertArrayEquals(sortArray, testArray);
    }

}
