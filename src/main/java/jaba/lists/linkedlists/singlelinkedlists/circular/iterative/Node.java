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
public class Node {
    @NonNull private Object item;
    @NonNull private Node next;
}
