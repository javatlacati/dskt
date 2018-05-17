package jaba.tree;

import java.util.Collection;

public interface BinaryTree<Item extends Comparable<Item>> extends Collection<Item> {
  boolean isRootNode(BinaryTreeNode<Item> node);
  void clear();
  int grade();
}
