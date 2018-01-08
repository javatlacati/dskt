package jaba.lists.linkedlists.singlelinkedlists.iterative;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public class TailedSingleLinkedListTest {
    private TailedSingleLinkedList<String> instance;

    @Before
    public void setUp() throws Exception {
        instance = new TailedSingleLinkedList<>();
    }

    @Test
    public void setRoot() throws Exception {
        instance.setHead(new Node<>("hola"));
        Assert.assertThat(instance.getHead(), notNullValue());
    }

    @Test
    public void getStrings() throws Exception {
        instance.add("Adios");
        instance.add("mundo");
        instance.add("cruel");
        Assert.assertThat(instance.getStrings(), is("Node(item=Adios)Node(item=mundo)Node(item=cruel)"));
    }

}