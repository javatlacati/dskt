package jaba.linkedlists.singlelinkedlists.iterative;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Core i7 on 30/05/2017.
 */
@Setter
@Getter
public class SingleLinkedList {
    private Node root;

    private String getStrings() {
        if (root == null) {
            return "";
        } else {
            String salida = root.toString();
            Node actual = root;
            while (actual.getNext() != null) {
                actual = actual.getNext();
                salida += salida.toString();
            }
            return salida;
        }
    }
}
