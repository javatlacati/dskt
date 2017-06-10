package jaba.lists;

import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkHistoryChart;
import com.carrotsearch.junitbenchmarks.annotation.LabelType;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Administrador on 10/06/2017.
 */
@BenchmarkHistoryChart(filePrefix = "map-types-benchmark-history-chart", labelWith = LabelType.RUN_ID, maxRuns = 40)
public class ListPerformanceTest {
    private final int iterations = 5000;

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

    private void size(MyList list) {
        assertNotNull(list.size());
        assertEquals(0, list.size());

        for (int i = 1; i < iterations; i++) {
            list.add(i);
            assertEquals(i,list.size());
        }

        list.clear();
        assertNotNull(list.size());
        assertEquals(0, list.size());
    }

}
