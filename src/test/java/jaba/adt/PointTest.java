package jaba.adt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;

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
        Assert.assertThat(point.distance(point1), notNullValue());
    }

}