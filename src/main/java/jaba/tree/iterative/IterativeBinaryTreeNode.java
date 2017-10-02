package jaba.tree.iterative;

/**
 * Created by Administrador on 01/07/2017.
 */
public class IterativeBinaryTreeNode<Item>  {
    Item value;
    private IterativeBinaryTreeNode left;
    private IterativeBinaryTreeNode right;


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
