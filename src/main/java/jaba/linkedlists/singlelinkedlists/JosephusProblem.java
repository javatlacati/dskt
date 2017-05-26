package jaba.linkedlists.singlelinkedlists;

import lombok.AllArgsConstructor;

/**
 * Created by Administrador on 22/05/2017.
 */
@AllArgsConstructor
public class JosephusProblem {

    final int romanSoldiersNumber;
    final int iteration;

    Node getSurvivor() {
        Node tail = new Node(1);
        Node survivor = tail;
        for (int i = 0; i < romanSoldiersNumber; i++) {
            survivor.setNext(new Node(i));
            survivor = survivor.getNext();
        }
        survivor.setNext(tail);
//        while (!survivor.equals(survivor.getNext())) {
        while (survivor != survivor.getNext()) {
            for (int i = 0; i < iteration; i++) {
                survivor = survivor.getNext();
                survivor.setNext(survivor.getNext().getNext());
            }
        }
        return survivor;
    }
}
