package jaba.tree.iterative;

import jaba.tree.AbStractBinaryTreeNode;
import jaba.tree.BinaryTreeNode;
/** Created by Administrador on 01/07/2017. */
public class IterativeBinaryTreeNodeNode<Item extends Comparable<Item>>
    extends AbStractBinaryTreeNode<Item> {
  private Item value;
  private IterativeBinaryTreeNodeNode<Item> left;
  private IterativeBinaryTreeNodeNode<Item> right;

  public IterativeBinaryTreeNodeNode(
      Item value, IterativeBinaryTreeNodeNode<Item> left, IterativeBinaryTreeNodeNode<Item> right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public IterativeBinaryTreeNodeNode(Item value) {
    this.value = value;
  }

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

  public Item getValue() {
    return this.value;
  }

  public IterativeBinaryTreeNodeNode getLeft() {
    return this.left;
  }

  public IterativeBinaryTreeNodeNode getRight() {
    return this.right;
  }

  public void setValue(Item value) {
    this.value = value;
  }
}
