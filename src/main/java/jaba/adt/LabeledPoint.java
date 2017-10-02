package jaba.adt;

/**
 * Created by Administrador on 22/05/2017.
 */
public class LabeledPoint extends Point {
    String label;

    @Override
    public String toString() {
        return label + super.toString();
    }
}
