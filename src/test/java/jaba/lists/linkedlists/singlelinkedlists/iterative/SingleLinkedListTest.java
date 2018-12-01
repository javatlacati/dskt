package jaba.lists.linkedlists.singlelinkedlists.iterative;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by Core i7 on 31/05/2017.
 */
public class SingleLinkedListTest {
    SingleLinkedList<String> instance;

    @Before
    public void setUp() throws Exception {
        instance = new SingleLinkedList<>();
    }

    @Test
    public void getStrings() throws Exception {
        instance.addAtEnd("Adios");
        instance.addAtEnd("mundo");
        instance.addAtEnd("cruel");
        assertThat(instance.getStrings(), is("Node(item=Adios)Node(item=mundo)Node(item=cruel)"));
    }

    @Test
    public void equalstest() throws Exception {
    }

    @Test
    public void hashCodetest() throws Exception {
    }

    @Test
    public void canEqual() throws Exception {
    }

    @Test
    public void getRoot() throws Exception {
        instance = new SingleLinkedList<>();
        assertThat(instance.getRoot(), nullValue());
    }

    @Test
    public void setRoot() throws Exception {
        instance.setRoot(new Node<>("3"));
        assertThat(instance.getRoot(), notNullValue());
    }

    @Test
    public void addAtEnd() {
    }

    @Test
    public void addAtRoot() {
    }

    @Test
    public void addAtIndex() {
    }

    @Test
    public void addSingleLinkedListAtRoot() {
    }

    @Test
    public void addSingleLinkedListAtEnd() {
    }

    @Test
    public void printList() {
    }

    @Test
    public void removeLast() {
    }

    @Test
    public void size() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void contains() {
    }

    @Test
    public void iterator() {
    }

    @Test
    public void containsSameTypeVerified() {
    }

    @Test
    public void toArray() {
    }

    @Test
    public void toArray1() {
    }

    @Test
    public void add() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void removeChecked() {
    }

    @Test
    public void containsAll() {
    }

    @Test
    public void addAll() {
    }

    @Test
    public void removeAll() {
    }

    @Test
    public void retainAll() {
    }

    @Test
    public void swap() {
    }

    @Test
    public void reverse() {
        instance.addAtEnd("cruel");
        instance.addAtEnd("mundo");
        instance.addAtEnd("Adios");
        instance.reverse();
        assertThat(instance.getStrings(), is("Node(item=Adios)Node(item=mundo)Node(item=cruel)"));
    }


    @Test
    public void equals() {
    }

    @Test
    public void ahashCode() {
    }
}
