package jaba.tree;

public interface BinaryTreeNode<Item extends Comparable<Item>> {
  boolean isParent();

  boolean isLeaf();

  boolean isParentOf(BinaryTreeNode<Item> childCandidate);

  int grade();

  BinaryTreeNode<Item> getLeft();

  BinaryTreeNode<Item> getRight();

  void setLeft(BinaryTreeNode<Item> left);

  void setRight(BinaryTreeNode<Item> right);
}
