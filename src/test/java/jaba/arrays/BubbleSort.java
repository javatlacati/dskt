package jaba.arrays;

import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkHistoryChart;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;
import com.carrotsearch.junitbenchmarks.annotation.LabelType;
import lombok.extern.java.Log;
import org.jetbrains.annotations.Contract;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;

@Log
@BenchmarkMethodChart(filePrefix = "benchmark-lists2")
@BenchmarkHistoryChart(labelWith = LabelType.RUN_ID)
public class BubbleSort {

    @Rule
    public BenchmarkRule benchmarkRun = new BenchmarkRule();

    private Random r = new Random();

    @BeforeClass
    public static void loadProperties() throws IOException {
        final Properties p = new Properties();
        p.load(new FileInputStream(new File("src/test/resources/jub.properties")));
        for (String k : p.stringPropertyNames()) {
            System.setProperty(k, p.getProperty(k));
        }
    }

    @Test
    public void randomData() {
        int[] targetArray = IntStream.generate(r::nextInt).limit(r.nextInt(7000)).toArray();
        log.info(Arrays.toString(targetArray));
        final int[] sorted = bubbleSort(targetArray);
//        log.info(Arrays.toString(sorted));
        int[] sortedByJava = Arrays.copyOfRange(targetArray, 0, targetArray.length);
        Arrays.sort(sortedByJava);
        Assert.assertThat(sorted, is(sortedByJava));
    }

    private int[] bubbleSort(int[] targetArr) {
        int[] targetArray = Arrays.copyOfRange(targetArr, 0, targetArr.length);
        while (!isSorted(targetArray)) {
            IntStream.range(0, (targetArray.length - 1)).filter(i -> targetArray[i] > targetArray[i + 1]).forEachOrdered(i -> swap(targetArray, i, i + 1));
        }
        return targetArray;
    }

    @Contract(pure = true)
    private boolean isSorted(final int[] targetArray) {
        return IntStream.range(0, targetArray.length - 1).noneMatch(i -> targetArray[i] > targetArray[i + 1]);
    }


    private void swap(int[] targetArray, int i, int i1) {
        final int aux = targetArray[i];
        targetArray[i] = targetArray[i1];
        targetArray[i1] = aux;
    }

}
