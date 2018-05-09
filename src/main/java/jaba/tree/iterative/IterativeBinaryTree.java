package jaba.tree.iterative;

import jaba.tree.BinaryTree;
import jaba.tree.BinaryTreeNode;
import java.util.Collection;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/** Created by Administrador on 02/07/2017. */
public class IterativeBinaryTree<Item> implements BinaryTree<Item> {
  private IterativeBinaryTreeNodeNode<Item> root;

  public IterativeBinaryTree(Item rootValue) {
    root = new IterativeBinaryTreeNodeNode<>(rootValue);
  }

  public IterativeBinaryTree() {}

  /** path size from root to specified node. */
  int getDepth(IterativeBinaryTreeNodeNode<Item> node) {
    // TODO do trough DFS
    return 0;
  }

  int getHeight() {
    return root.getHeight();
  }

  //  boolean isAncestor(IterativeBinaryTreeNodeNode possibleAncestor, IterativeBinaryTreeNodeNode
  // possibleDescendant){
  //      // TODO buscar padre por DFS
  //      IterativeBinaryTreeNodeNode<IterativeBinaryTree> parent = null;
  //
  //  }

  boolean areSiblings(IterativeBinaryTreeNodeNode<Item> node1, IterativeBinaryTreeNodeNode<Item> node2) {
    // TODO buscar padre por DFS
    IterativeBinaryTreeNodeNode<Item> parent = null;
    if (parent != null) {
      return node1.equals(parent.getLeft()) && node2.equals(parent.getRight())
          || node2.equals(parent.getLeft()) && node1.equals(parent.getRight());
    } else {
      return false;
    }
  }
  /*
  preorder
  inorder
  postorder
  * */

  /** make empty */
  public void clear() {
    root = null;
  }

  public boolean isEmpty() {
    return root == null;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @NotNull
  @Override
  public Iterator iterator() {
    return null;
  }

  @NotNull
  @Override
  public Object[] toArray() {
    return new Object[0];
  }

  @Override
  public boolean add(Object o) {
    return false;
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public boolean addAll(@NotNull Collection c) {
    return false;
  }

  @Override
  public boolean retainAll(@NotNull Collection c) {
    return false;
  }

  @Override
  public boolean removeAll(@NotNull Collection c) {
    return false;
  }

  @Override
  public boolean containsAll(@NotNull Collection c) {
    return false;
  }

  @NotNull
  @Override
  public Object[] toArray(@NotNull Object[] a) {
    return new Object[0];
  }

  public void merge(
      Item rootItemValue, IterativeBinaryTree<Item> tree1, IterativeBinaryTree<Item> tree2) {
    if (!tree1.getRoot().equals(tree2.getRoot()))
      if (tree1.getRoot() != null) {
        if (tree2.getRoot() != null) {
          this.root =
              new IterativeBinaryTreeNodeNode<Item>(rootItemValue, tree1.getRoot(), tree2.getRoot());
        }
      }
    // TODO insert all
  }

  /** returns the number of elements that conform this tree. */
  public int size() {
    if (root == null) {
      return 0;
    } else {
      return 1 + root.countElements();
    }
  }

  @Override
  public boolean isRootNode(BinaryTreeNode node) {
    return root.equals(node);
  }

  @Override
  public int grade() {
    return 0;
  }
  public IterativeBinaryTreeNode<Item> getRoot() {
    return root;
  }

  public void setRoot(IterativeBinaryTreeNode<Item> root) {
    this.root = root;
  }
}
