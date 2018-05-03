package jaba.tree.iterative;

import jaba.tree.BinaryTreeNode;
/**
 * Created by Administrador on 01/07/2017.
 */
//@AllArgsConstructor
//@RequiredArgsConstructor
public class IterativeBinaryTreeNode<Item>  implements BinaryTreeNode<Item> {
    //@NonNull
    private Item value;
    private IterativeBinaryTreeNode<Item> left;
    private IterativeBinaryTreeNode<Item> right;

  @Override
  public boolean isParent() {
    return null != left || null != right;
  }

  @Override
  public boolean isLeaf() {
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
