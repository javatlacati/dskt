package jaba.linkedlists.singlelinkedlists.iterative;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Core i7 on 30/05/2017.
 */
@Setter
@Getter
@EqualsAndHashCode(of = {"item"})
@ToString(of = "item")
public class Node {
    private Object item;
    private Node next;

    public Node(Object item) {
        this.item = item;
    }
}
