package jaba.tree.recursive;

import jaba.tree.BinaryTree;
import jaba.tree.BinaryTreeNode;
import java.util.Collection;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
/**
 * Created by Administrador on 02/07/2017.
 */
public class RecursiveBinaryTree<Item> {
    RecursiveBinaryTreeNode<Item> root;

  public RecursiveBinaryTree(Item rootValue) {
    root = new RecursiveBinaryTreeNode<>(rootValue);
  }

  public boolean isRootNode(RecursiveBinaryTreeNode<Item> node) {
    return root.equals(node);
  }

  public boolean isInternalNode(RecursiveBinaryTreeNode<Item> node) {
    return !isRootNode(node) && ((null != node.getRight()) || (null != node.getLeft()));
  }

  public boolean isLeafNode(RecursiveBinaryTreeNode<Item> node) {
    return !isRootNode(node) && (null == node.getRight()) && (null == node.getLeft());
  }

  public boolean isSiblingNode(
      RecursiveBinaryTreeNode<Item> node1, RecursiveBinaryTreeNode<Item> node2) {
    if (isLeafNode(node1) && isLeafNode(node2)) {
      // todo implementar con dfs
      return false;
    } else {
      return false;
    }
  }

  public boolean isParentNode(
      RecursiveBinaryTreeNode<Item> parentCandidate, RecursiveBinaryTreeNode<Item> childCandidate) {
    return parentCandidate.getLeft().equals(childCandidate)
        || parentCandidate.getRight().equals(childCandidate);
  }

  public boolean isChildNode(
      RecursiveBinaryTreeNode<Item> childCandidate, RecursiveBinaryTreeNode<Item> parentCandidate) {
    return isParentNode(parentCandidate, childCandidate);
  }

  @Override
  public String toString() {
    return showRecursive(root, 0);
  }

    public RecursiveBinaryTreeNode<Item> getRoot() {
        return this.root;
    }
    private String showRecursive(RecursiveBinaryTreeNode<Item> root, int h) {
        StringBuilder result=new StringBuilder();
        if(root == null){
            result.append(printNode(null,h));
        }else{
            result.append(showRecursive(root.getRight(),h+1));
            result.append(printNode(root.getValue(),h));
            result.append(showRecursive(root.getLeft(),h+1));
        }
        return result.toString();
    }

  private String printNode(Item value, int h) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < h; i++) {
      result.append(' ');
    }
    result.append('[').append(value).append(']');
    return result.toString();
  }

  @Override public boolean isRootNode(BinaryTreeNode<Item> node) {
    return root.equals(node);
  }

  @Override public int size() {
    if (root == null) {
      return 0;
    } else {
      return 1 ; // TODO recursive add
    }
  }

  @Override public boolean isEmpty() {
    return false;
  }

  @Override public boolean contains(Object o) {
    return false;
  }

  @NotNull @Override public Iterator<Item> iterator() {
    return null;
  }

  @NotNull @Override public Object[] toArray() {
    return new Object[0];
  }

  @NotNull @Override public <T> T[] toArray(@NotNull T[] a) {
    return null;
  }

  @Override public boolean add(Item item) {
    return false;
  }

  @Override public boolean remove(Object o) {
    return false;
  }

  @Override public boolean containsAll(@NotNull Collection<?> c) {
    return false;
  }

  @Override public boolean addAll(@NotNull Collection<? extends Item> c) {
    return false;
  }

  @Override public boolean removeAll(@NotNull Collection<?> c) {
    return false;
  }

  @Override public boolean retainAll(@NotNull Collection<?> c) {
    return false;
  }

  @Override public void clear() {

  }
}
