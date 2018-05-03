package jaba.tree.iterative;

import jaba.tree.BinaryTreeNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/** Created by Administrador on 01/07/2017. */
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class IterativeBinaryTreeNode<Item> implements BinaryTreeNode<Item> {
  @NonNull private Item value;
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
}
