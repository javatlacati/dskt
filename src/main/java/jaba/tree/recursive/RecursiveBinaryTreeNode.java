package jaba.tree.recursive;

import jaba.tree.AbStractBinaryTreeNode;
import jaba.tree.BinaryTreeNode;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/** Created by Administrador on 01/07/2017. */
@Getter
// @Setter
@AllArgsConstructor
@RequiredArgsConstructor
// TODO probar con constructor vacío
@EqualsAndHashCode
public class RecursiveBinaryTreeNode<Item extends Comparable<Item>>
    extends AbStractBinaryTreeNode<Item> {
  @NonNull private Item value;
  private RecursiveBinaryTreeNode<Item> left;
  private RecursiveBinaryTreeNode<Item> right;

  @Override
  public boolean isParent() {
    return null != left || null != right;
  }

  @Override
  public boolean isLeaf() {
    return left == null && right == null;
  }

  //  @Override
  //  public boolean isParentOf(BinaryTreeNode<Item> childCandidate) {
  //    return childCandidate instanceof RecursiveBinaryTreeNode
  //        && (left.equals(childCandidate) || right.equals(childCandidate));
  //  }

  @Override
  public int grade() {
    int grade = 0;
    if (left != null) {
      grade++;
    }
    if (right != null) {
      grade++;
    }
    return grade;
  }

  /** The grade of a tree is equal to the greatest grade of it's nodes. */
  public int subtreeGrade() {
    int gradeCurrent = grade();
    // BT optimization grade can't be greater than 2
    if (gradeCurrent == 2) {
      return 2;
    }
    return Math.max(
        getMaxGradeRecursive(left, gradeCurrent), getMaxGradeRecursive(right, gradeCurrent));
  }

  private int getMaxGradeRecursive(RecursiveBinaryTreeNode<Item> node, int gradeCurrent) {
    if (node == null) {
      return 0;
    } else {
      final int grade = node.grade();
      if (grade > gradeCurrent) {
        // BT optimization grade can't be greater than 2
        if (grade == 2) {
          return 2;
        }
        return Math.max(
            getMaxGradeRecursive(node.left, grade), getMaxGradeRecursive(node.right, grade));
      } else {
        return gradeCurrent;
      }
    }
  }

  @Override
  public void setLeft(BinaryTreeNode<Item> left) {
    if (left instanceof RecursiveBinaryTreeNode) {
      this.left = (RecursiveBinaryTreeNode<Item>) left;
    }
  }

  @Override
  public void setRight(BinaryTreeNode<Item> right) {
    if (right instanceof RecursiveBinaryTreeNode) {
      this.right = (RecursiveBinaryTreeNode<Item>) right;
    }
  }
}
