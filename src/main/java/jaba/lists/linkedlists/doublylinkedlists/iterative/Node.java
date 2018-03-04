package jaba.lists.linkedlists.doublylinkedlists.iterative;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Core i7
 */
@Getter
@Setter
@AllArgsConstructor
@ToString(of = "item")
@EqualsAndHashCode(of = "item")
public class Node<Type> {

    private Type item;
    private Node<Type> previous;
    private Node<Type> next;

    public Node(Type item) {
        this.item = item;
    }

}
