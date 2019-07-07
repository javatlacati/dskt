package jaba.adt;

/**
 * Created by Administrador on 22/05/2017.
 */
public class LabeledPoint extends Point {
    String label;

    /**Returns a string representation of the object. */
    @Override
    public String toString() {
        return label + super.toString();
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
