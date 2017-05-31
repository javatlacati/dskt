package jaba.linkedlists.singlelinkedlists.iterative;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Core i7 on 30/05/2017.
 */
@Setter
@Getter
@EqualsAndHashCode(of = "root")
public class SingleLinkedList {
    private Node root;

    public String getStrings() {
        if (root == null) {
            return "";
        } else {
            String salida = root.toString();
            Node actual = root;
            while (actual.getNext() != null) {
                actual = actual.getNext();
                salida += actual.toString();
            }
            return salida;
        }
    }

    public void addAtEnd(Node newNode) {
        if (root == null) {
            root = newNode;
        } else {
            Node actual = root;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(newNode);
        }
    }
}
