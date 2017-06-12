package jaba.lists;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import static org.junit.Assert.*;

@BenchmarkMethodChart(filePrefix = "listPerformance")
public class ListPerformanceTest {
    private final int iterations = 7000;
    final Random random = new Random();

    @Rule
    public BenchmarkRule benchmarkRun = new BenchmarkRule();

    @BeforeClass
    public static void loadProperties() throws IOException {
        Properties p = new Properties();
        p.load(new FileInputStream(new File("src/test/resources/jub.properties")));
        for (String k : p.stringPropertyNames()) {
            System.setProperty(k, p.getProperty(k));
        }
    }

    @Test
    @BenchmarkOptions(concurrency = 0)
    public void sizeIteraiveSingleLinkedList() throws Exception {
        size(new jaba.lists.linkedlists.singlelinkedlists.iterative.SingleLinkedList());
    }

    @Test
    @BenchmarkOptions(concurrency = 0)
    public void sizeRecursiveSingleLinkedList() throws Exception {
        size(new jaba.lists.linkedlists.singlelinkedlists.recursive.SingleLinkedList());
    }

    @Test
    @BenchmarkOptions(concurrency = 0)
    public void toArrayIteraiveSingleLinkedList() throws Exception {
        toArray(new jaba.lists.linkedlists.singlelinkedlists.iterative.SingleLinkedList());
    }

    @Test
    @BenchmarkOptions(concurrency = 0)
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
