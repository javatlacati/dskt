package jaba.adt;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrador on 22/05/2017.
 */
@Getter
@Setter
public class LabeledPoint extends Point {
    String label;

    /**Returns a string representation of the object. */
    @Override
    public String toString() {
        return label + super.toString();
    }
}
