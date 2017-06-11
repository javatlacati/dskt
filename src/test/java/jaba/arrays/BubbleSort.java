package jaba.arrays;

import lombok.val;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class BubbleSort {
    private int[] targetArray;
    private Random r = new Random();

    @Before
    public void setUp() throws Exception {
        targetArray = IntStream.generate(r::nextInt).limit(r.nextInt(10)).toArray();
        System.out.println(Arrays.toString(targetArray));
    }

    @Test
    public void randomData() throws Exception {
        int[] sorted = bubbleSort(targetArray);
//        System.out.println(Arrays.toString(sorted));
        int[] sortedByJava = Arrays.copyOfRange(targetArray, 0, targetArray.length);
        Arrays.sort(sortedByJava);
        Assert.assertArrayEquals(sortedByJava, sorted);
    }

    private int[] bubbleSort(int[] targetArr) {
        int[] targetArray = Arrays.copyOfRange(targetArr, 0, targetArr.length);
        while (!isSorted(targetArray)) {
            for (int i = 0; i < targetArray.length - 1; i++) {
                if (targetArray[i] > targetArray[i + 1]) {
                    swap(targetArray, i, i + 1);
                }
            }
        }
        return targetArray;
    }

    private boolean isSorted(final int[] targetArray) {
        for (int i = 0; i < targetArray.length - 1; i++) {
            if (targetArray[i] > targetArray[i + 1]) {
                return false;
            }
        }
        return true;
    }


    private void swap(int[] targetArray, int i, int i1) {
        val aux = targetArray[i];
        targetArray[i] = targetArray[i1];
        targetArray[i1] = aux;
    }

}
