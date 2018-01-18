package jaba.tree.recursive;

/**
 * Created by Administrador on 02/07/2017.
 */
public class RecursiveBinaryTree<Item> {
    RecursiveBinaryTreeNode<Item> root;

    public boolean isRootNode(RecursiveBinaryTreeNode<Item> node) {
        return root.equals(node);
    }

    public boolean isInternalNode(RecursiveBinaryTreeNode<Item> node) {
        return !isRootNode(node) && ((null != node.getRight()) || (null != node.getLeft()));
    }

    public boolean isLeafNode(RecursiveBinaryTreeNode<Item> node) {
        return !isRootNode(node) && (null == node.getRight()) && (null == node.getLeft());
    }

    public boolean isSiblingNode(RecursiveBinaryTreeNode<Item> node1, RecursiveBinaryTreeNode<Item> node2) {
        if (isLeafNode(node1) && isLeafNode(node2)) {
            //todo implementar con dfs
            return false;
        } else {
            return false;
        }
    }

    public boolean isParentNode(RecursiveBinaryTreeNode<Item> parentCandidate, RecursiveBinaryTreeNode<Item> childCandidate) {
        return parentCandidate.getLeft().equals(childCandidate) || parentCandidate.getRight().equals(childCandidate);
    }

    public boolean isChildNode(RecursiveBinaryTreeNode<Item> childCandidate, RecursiveBinaryTreeNode<Item> parentCandidate) {
        return isParentNode(parentCandidate, childCandidate);
    }

    @Override
    public String toString() {
        return showRecursive(root,0);
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
            result.append(printNode(root.value,h));
            result.append(showRecursive(root.getLeft(),h+1));
        }
        return result.toString();
    }

    private String printNode(Item value, int h) {
        StringBuilder result=new StringBuilder();
        for (int i = 0; i < h; i++) {
            result.append(' ');
        }
        result.append('[').append(value).append(']');
        return result.toString();
    }
}
