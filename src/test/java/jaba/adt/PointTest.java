package jaba.adt;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PointTest {
    private Point point;
    private Point point1;

    @Before
    public void setUp() throws Exception {
        point = new Point();
        point1 = new Point();
    }

    @Test
    public void r() throws Exception {
    }

    @Test
    public void theta() throws Exception {
    }

    @Test
    public void distance() throws Exception {
        assertNotNull(point.distance(point1));
    }

}