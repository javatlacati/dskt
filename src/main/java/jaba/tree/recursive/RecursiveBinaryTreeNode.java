package jaba.tree.recursive;

/**
 * Created by Administrador on 01/07/2017.
 */
public class RecursiveBinaryTreeNode<Item> {
    Item value;
    private RecursiveBinaryTreeNode left;
    private RecursiveBinaryTreeNode right;

    public Item getValue() {
        return this.value;
    }

    public RecursiveBinaryTreeNode getLeft() {
        return this.left;
    }

    public RecursiveBinaryTreeNode getRight() {
        return this.right;
    }

    public void setValue(Item value) {
        this.value = value;
    }

    public void setLeft(RecursiveBinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(RecursiveBinaryTreeNode right) {
        this.right = right;
    }
}
