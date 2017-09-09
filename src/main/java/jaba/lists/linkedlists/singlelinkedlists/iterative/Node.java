package jaba.lists.linkedlists.singlelinkedlists.iterative;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Javatlacati on 30/05/2017.
 * @param <Type> Type of contained objects
 * @author Javatlacati
 */
@Setter
@Getter
@EqualsAndHashCode(of = {"item"})
@ToString(of = "item")
public class Node<Type> {
    private Type item;
    private Node<Type> next;

    public Node(Type item) {
        this.item = item;
    }
}
