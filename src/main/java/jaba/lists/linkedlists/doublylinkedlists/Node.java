package jaba.lists.linkedlists.doublylinkedlists;

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

    Type item;
    Node previous;
    Node next;

    public Node(Type item) {
        this.item = item;
    }

}
