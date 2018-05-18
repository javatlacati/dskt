package jaba.tree;

public abstract class AbStractBinaryTreeNode<Item extends Comparable<Item>>
    implements BinaryTreeNode<Item> {

  @Override
  public abstract boolean isParent();

  @Override
  public abstract boolean isLeaf();

  @Override
  public boolean isParentOf(BinaryTreeNode childCandidate) {
    return childCandidate != null
        && (childCandidate.equals(getLeft()) || childCandidate.equals(getRight()));
  }

  @Override
  public abstract int grade();

  @Override
  public abstract BinaryTreeNode<Item> getLeft();

  @Override
  public abstract BinaryTreeNode<Item> getRight();

  public abstract void setLeft(BinaryTreeNode<Item> left);

  public abstract void setRight(BinaryTreeNode<Item> right);
}
