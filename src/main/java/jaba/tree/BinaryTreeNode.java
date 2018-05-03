package jaba.tree;

public interface BinaryTreeNode<Item> {
  boolean isParent();

  boolean isLeaf();

  boolean isParentOf(BinaryTreeNode<Item> childCandidate);

  int grade();
}
