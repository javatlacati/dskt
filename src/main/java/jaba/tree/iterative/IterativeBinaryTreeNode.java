package jaba.tree.iterative;

import jaba.tree.BinaryTreeNode;
/** Created by Administrador on 01/07/2017. */
public class IterativeBinaryTreeNode<Item> implements BinaryTreeNode<Item> {
  private Item value;
  private IterativeBinaryTreeNode<Item> left;
  private IterativeBinaryTreeNode<Item> right;

  public IterativeBinaryTreeNode(
      Item value, IterativeBinaryTreeNode<Item> left, IterativeBinaryTreeNode<Item> right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public IterativeBinaryTreeNode(Item value) {
    this.value = value;
  }

  int getHeight() {
    // TODO hacer for DFS
    return 0;
  }

  IterativeBinaryTree<Item> getSubtree() {
    return new IterativeBinaryTree<>(this.value);
  }

  IterativeBinaryTreeNode<Item> duplicate() {
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

  @Override
  public boolean isParentOf(BinaryTreeNode<Item> childCandidate) {
    return childCandidate instanceof IterativeBinaryTreeNode
        && (left.equals(childCandidate) || right.equals(childCandidate));
  }

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

  public Item getValue() {
    return this.value;
  }

  public IterativeBinaryTreeNode getLeft() {
    return this.left;
  }

  public IterativeBinaryTreeNode getRight() {
    return this.right;
  }

  public void setValue(Item value) {
    this.value = value;
  }

  public void setLeft(IterativeBinaryTreeNode left) {
    this.left = left;
  }

  public void setRight(IterativeBinaryTreeNode right) {
    this.right = right;
  }
}
