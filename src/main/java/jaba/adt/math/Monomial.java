package jaba.adt.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Administrador on 29/06/2017.
 */
public class Monomial {
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

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Monomial))
      return false;
    Monomial monomial = (Monomial) o;
    return monomialCoefficient == monomial.monomialCoefficient && Objects
        .equals(variableTerms, monomial.variableTerms);
  }

  @Override public int hashCode() {

    return Objects.hash(monomialCoefficient, variableTerms);
  }

  @Override public String toString() {
    VariableTermStringJoiner joiner = new VariableTermStringJoiner();
    variableTerms.forEach(joiner::add);
    return (0 == monomialCoefficient ? "" : monomialCoefficient + "(") + joiner.toString() + (
        0 == monomialCoefficient ? "" : ")");
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


  private class VariableTermStringJoiner {
    private final String positiveValueDelimiter="+";
    private final String negativeValueDelimiter="";

    /*
     * StringBuilder value -- at any time, the characters constructed from the
     * prefix, the added element separated by the positiveValueDelimiter, but without the
     * suffix, so that we can more easily add elements without having to jigger
     * the suffix each time.
     */
    private StringBuilder value;

    public VariableTermStringJoiner() {
    }

    /**
     * Adds a copy of the given {@code CharSequence} value as the next
     * element of the {@code StringJoiner} value. If {@code newElement} is
     * {@code null}, then {@code "null"} is added.
     *
     * @param newElement The element to add
     * @return a reference to this {@code StringJoiner}
     */
    public VariableTermStringJoiner add(VariableTerm newElement) {
      prepareBuilder(newElement).append(newElement);
      return this;
    }

    private StringBuilder prepareBuilder(VariableTerm newElement) {
      if (value == null) {
        value = new StringBuilder();
      } else {
        value.append(newElement.getCoefficient()>-1 ? positiveValueDelimiter:negativeValueDelimiter);
      }
      return value;
    }

    @Override public String toString() {
      if (value == null) {
        return "";
      } else {
        return value.toString();
      }
    }
  }
}
