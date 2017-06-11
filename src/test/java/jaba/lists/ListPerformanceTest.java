package jaba.lists;

import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkHistoryChart;
import com.carrotsearch.junitbenchmarks.annotation.LabelType;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Administrador on 10/06/2017.
 */
@BenchmarkHistoryChart(filePrefix = "map-types-benchmark-history-chart", labelWith = LabelType.RUN_ID, maxRuns = 40)
public class ListPerformanceTest {
    private final int iterations = 7000;
    final Random random = new Random();

    @Rule
    public BenchmarkRule benchmarkRun = new BenchmarkRule();

    @Test
    public void sizeIteraiveSingleLinkedList() throws Exception {
        size(new jaba.lists.linkedlists.singlelinkedlists.iterative.SingleLinkedList());
    }

    @Test
    public void sizeRecursiveSingleLinkedList() throws Exception {
        size(new jaba.lists.linkedlists.singlelinkedlists.recursive.SingleLinkedList());
    }

    @Test
    public void toArrayIteraiveSingleLinkedList() throws Exception {
        toArray(new jaba.lists.linkedlists.singlelinkedlists.iterative.SingleLinkedList());
    }

    @Test
    public void toArrayRecursiveSingleLinkedList() throws Exception {
        toArray(new jaba.lists.linkedlists.singlelinkedlists.recursive.SingleLinkedList());
    }

    private void size(MyList list) {
        assertNotNull(list.size());
        assertEquals(0, list.size());

        for (int i = 1; i < iterations; i++) {
            list.add(Math.abs(random.nextInt()));
            assertEquals(i, list.size());
        }

        list.clear();
        assertEquals(0, list.size());
    }

    private void toArray(MyList myList) throws Exception {
        assertArrayEquals(new Object[0], myList.toArray());
        ArrayList list = new ArrayList();
        for (int i = 0; i < iterations; i++) {
            int randomVal = Math.abs(random.nextInt());
            list.add(randomVal);
            myList.add(randomVal);
        }
        assertArrayEquals(list.toArray(), myList.toArray());
    }

}
