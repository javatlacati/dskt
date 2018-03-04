package jaba.adt.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.EqualsAndHashCode;

/**
 * Created by Administrador on 29/06/2017.
 */
@EqualsAndHashCode public class Monomial {
  private int monomialCoefficient;
  private List<VariableTerm> variableTerms;

  public Monomial(int coefficient) {
    this.monomialCoefficient = coefficient;
    variableTerms = new ArrayList<>();
  }

  public Monomial(int monomialCoefficient, List<VariableTerm> variableTerms) {
    this.monomialCoefficient = monomialCoefficient;
    this.variableTerms = variableTerms;
  }

  int getGrade() {
    return variableTerms.stream().mapToInt(VariableTerm::getGrade).max().orElse(Integer.MIN_VALUE);
  }

  //    void normalize(){
  //
  //    }

  //    String getLiteralPart(){
  //
  //    }

  //    boolean isSemejant(Monomial fist, Monomial second){
  //        return fist.getL
  //    }


  @Override public String toString() {
    return (0 == monomialCoefficient ? "" : monomialCoefficient + "(") + Arrays
        .toString(variableTerms.toArray()) + (0 == monomialCoefficient ? "" : ")");
  }

  public void addTerm(VariableTerm variableTerm) {
    //        if (isLiteralPartAndGradePesent(variableTerm.getLiteralPart(), variableTerm.getGrade())) {
    //sum to normalize
    //        } else {
    variableTerms.add(variableTerm);
    //        }
  }

  private boolean isLiteralPartAndGradePesent(String literalPart, int grade) {
    return false;
  }


}
