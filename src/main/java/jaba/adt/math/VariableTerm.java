package jaba.adt.math;

/**
 * Created by Administrador on 29/06/2017.
 */
public class VariableTerm {
    private int coefficient;
    private String literalPart;
    private int grade;

    @java.beans.ConstructorProperties({"coefficient", "literalPart", "grade"})
    public VariableTerm(int coefficient, String literalPart, int grade) {
        this.coefficient = coefficient;
        this.literalPart = literalPart;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return (coefficient == 0 ? "" : coefficient) + literalPart + (grade == 0 ? "" : "^" +grade);
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

    public int getCoefficient() {
        return this.coefficient;
    }

    public String getLiteralPart() {
        return this.literalPart;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public void setLiteralPart(String literalPart) {
        this.literalPart = literalPart;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
