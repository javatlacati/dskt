package jaba.adt.math;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrador on 29/06/2017.
 */
@AllArgsConstructor
@Setter
@Getter
public class VariableTerm {
    int coefficient;
    String literalPart;
    int grade;

    @Override
    public String toString() {
        return (coefficient == 0 ? "" : coefficient) + literalPart + (grade == 0 ? "" : "^" +grade);
    }
}
