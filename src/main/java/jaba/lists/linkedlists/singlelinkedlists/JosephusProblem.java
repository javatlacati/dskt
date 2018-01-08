package jaba.lists.linkedlists.singlelinkedlists;

import jaba.lists.linkedlists.singlelinkedlists.recursive.Node;

/**
 * Created by Administrador on 22/05/2017.
 */
public class JosephusProblem {

    final int romanSoldiersNumber;
    final int iteration;

    @java.beans.ConstructorProperties({"romanSoldiersNumber", "iteration"})
    public JosephusProblem(int romanSoldiersNumber, int iteration) {
        this.romanSoldiersNumber = romanSoldiersNumber;
        this.iteration = iteration;
    }

    Node<Integer> getSurvivor() {
        Node<Integer> tail = new Node<>(0);
        Node<Integer> survivor = tail;
        for (int i = 1; i <= romanSoldiersNumber; i++) {
            survivor.setNext(new Node<>(i));
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

    public static void main(final String[] args) {
        final JosephusProblem josephusProblem = new JosephusProblem(10, 10);
        final Node<Integer> survivor = josephusProblem.getSurvivor();
        //log.info(survivor.toString());
    }
}
