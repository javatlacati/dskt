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
    private int coefficient;
    private String literalPart;
    private int grade;

    @Override
    public String toString() {
        return ((0 == coefficient) ? "" : coefficient) + literalPart + ((0 == grade) ? "" : ("^" + grade));
    }

    public void sum(VariableTerm otherTerm){
        if(literalPart==otherTerm.getLiteralPart()){
            if(grade==otherTerm.getGrade()){
                coefficient+=otherTerm.getCoefficient();
            }else{
                //binomial
            }
        }
    }


    public Object sum1(VariableTerm otherTerm){
        if(literalPart==otherTerm.getLiteralPart()){
            if(grade==otherTerm.getGrade()){
                return new VariableTerm(coefficient+otherTerm.getCoefficient(),literalPart,grade);
            }else{
                final Monomial monomial = new Monomial(0);
                monomial.addTerm(this);
                monomial.addTerm(otherTerm);
                return monomial;
            }
        }
        final Monomial monomial = new Monomial(0);
        monomial.addTerm(this);
        monomial.addTerm(otherTerm);
        return monomial;
    }
}
