package jaba.lists.linkedlists.singlelinkedlists.circular;

/**
 * Created by Administrador on 22/05/2017.
 */
public class FancyJosephusProblem {
    int romanSoldiersNumber;
    int numberOfPeopleSkipped;


    @java.beans.ConstructorProperties({"romanSoldiersNumber", "numberOfPeopleSkipped"})
    public FancyJosephusProblem(int romanSoldiersNumber, int numberOfPeopleSkipped) {
        this.romanSoldiersNumber = romanSoldiersNumber;
        this.numberOfPeopleSkipped = numberOfPeopleSkipped;
    }
}
