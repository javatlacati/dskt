package jaba.tree.iterative;

import lombok.Getter;
import lombok.Setter;

/** Created by Administrador on 01/07/2017. */
@Getter
@Setter
public class IterativeBinaryTreeNode<Item> {
  private Item value;
  private IterativeBinaryTreeNode<Item> left;
  private IterativeBinaryTreeNode<Item> right;

  boolean isParent() {
    return null != left || null != right;
  }

  boolean isLeaf() {
    return left == null && right == null;
  }

  int getHeight() {
    // TODO hacer for DFS
    return 0;
  }

  IterativeBinaryTree<Item> getSubtree() {
    return new IterativeBinaryTree<>(this);
  }

  IterativeBinaryTreeNode<Item> duplicate() {
    // TODO implement me
    return null;
  }

  public int countElements() {
    // TODO implement me
    return 0;
  }
}
