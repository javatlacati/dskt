package jaba.tree.iterative;

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
@EqualsAndHashCode
public class IterativeBinaryTreeNodeNode<Item> extends AbStractBinaryTreeNode<Item> {
  @NonNull private Item value;
  private IterativeBinaryTreeNodeNode<Item> left;
  private IterativeBinaryTreeNodeNode<Item> right;

  int getHeight() {
    // TODO hacer for DFS
    return 0;
  }

  IterativeBinaryTree<Item> getSubtree() {
    return new IterativeBinaryTree<>(this.value);
  }

  IterativeBinaryTreeNodeNode<Item> duplicate() {
    // TODO implement me
    return null;
  }

  public int countElements() {
    // TODO implement me
    return 0;
  }

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
  //    return childCandidate instanceof IterativeBinaryTreeNodeNode
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

  @Override
  public void setLeft(BinaryTreeNode<Item> left) {
    if (left instanceof IterativeBinaryTreeNodeNode) {
      this.left = (IterativeBinaryTreeNodeNode<Item>) left;
    }
  }

  @Override
  public void setRight(BinaryTreeNode<Item> right) {
    if (right instanceof IterativeBinaryTreeNodeNode) {
      this.right = (IterativeBinaryTreeNodeNode<Item>) right;
    }
  }
}
