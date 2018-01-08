package jaba.lists.linkedlists.singlelinkedlists;

import jaba.lists.linkedlists.singlelinkedlists.recursive.Node;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrador on 22/05/2017.
 */
public class JosephusProblemTest {
    @Test
    public void getSurvivor() {
        final JosephusProblem josephusProblem = new JosephusProblem(9,5);
        final Node survivor = josephusProblem.getSurvivor();
        System.out.println(survivor);
        Assert.assertNotNull(survivor);
    }

}