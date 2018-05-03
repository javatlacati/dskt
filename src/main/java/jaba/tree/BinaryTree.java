package jaba.tree;

import java.util.Collection;

public interface BinaryTree<Item> extends Collection<Item> {
  boolean isRootNode(BinaryTreeNode<Item> node);
  int grade();
}
