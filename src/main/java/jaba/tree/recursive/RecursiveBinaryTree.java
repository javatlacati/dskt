package jaba.tree.recursive;

import jaba.tree.iterative.IterativeBinaryTreeNode;

/**
 * Created by Administrador on 02/07/2017.
 */
public class RecursiveBinaryTree<Item> {
    RecursiveBinaryTreeNode<Item> root;

    public boolean isRootNode(IterativeBinaryTreeNode<Item> node) {
        return root.equals(node);
    }

    public boolean isInternalNode(IterativeBinaryTreeNode<Item> node) {
        if (!isRootNode(node)) {
            if (node.getRight() != null || node.getLeft() != null) {
                return true;
            }
        }
        return false;
    }

    public boolean isLeafNode(IterativeBinaryTreeNode<Item> node) {
        return !isRootNode(node) && node.getRight() == null && node.getLeft() == null;
    }

    public boolean isSiblingNode(IterativeBinaryTreeNode<Item> node1, IterativeBinaryTreeNode<Item> node2) {
        if (isLeafNode(node1) && isLeafNode(node2)) {
            //todo implementar con dfs
            return false;
        } else {
            return false;
        }
    }

    public boolean isParentNode(IterativeBinaryTreeNode<Item> parentCandidate, IterativeBinaryTreeNode<Item> childCandidate) {
        return parentCandidate.getLeft().equals(childCandidate) || parentCandidate.getRight().equals(childCandidate);
    }

    public boolean isChildNode(IterativeBinaryTreeNode<Item> childCandidate, IterativeBinaryTreeNode<Item> parentCandidate) {
        return isParentNode(parentCandidate, childCandidate);
    }


    public RecursiveBinaryTreeNode<Item> getRoot() {
        return this.root;
    }
}
