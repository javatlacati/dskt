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


    public RecursiveBinaryTreeNode<Item> getRoot() {
        return this.root;
    }
}
