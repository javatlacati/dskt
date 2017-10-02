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

    Node getSurvivor() {
        Node tail = new Node(0);
        Node survivor = tail;
        for (int i = 1; i <= romanSoldiersNumber; i++) {
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
    
    public static void main(String[] args) {
        JosephusProblem josephusProblem = new JosephusProblem(10,10);
        Node survivor = josephusProblem.getSurvivor();
        System.out.println(survivor);
    }
}
