package jaba.linkedlists.singlelinkedlists;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrador on 22/05/2017.
 */
public class JosephusProblemTest {
    @Test
    public void getSurvivor() throws Exception {
        JosephusProblem josephusProblem = new JosephusProblem(10,10);
        Node survivor = josephusProblem.getSurvivor();
        System.out.println(survivor);
        Assert.assertNotNull(survivor);
    }

}