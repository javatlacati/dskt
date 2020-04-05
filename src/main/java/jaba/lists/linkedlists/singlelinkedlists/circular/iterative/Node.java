package jaba.lists.linkedlists.singlelinkedlists.circular.iterative;

import lombok.*;

/**
 * Created by Core i7 on 30/05/2017.
 */
@Setter
@Getter
@EqualsAndHashCode(of = {"item"})
@ToString(of = "item")
@AllArgsConstructor
public class Node<Type> {
    @NonNull private Type item;
    @NonNull private Node<Type> next;

    public Node(@NonNull Type item) {
        this.item = item;
        next = this;
    }
}
