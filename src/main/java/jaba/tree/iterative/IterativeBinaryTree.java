package jaba.tree.iterative;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/** Created by Administrador on 02/07/2017. */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IterativeBinaryTree<Item> {
  private IterativeBinaryTreeNode<Item> root;

  /** path size from root to node. */
  //    int getDepth(IterativeBinaryTreeNode<Item> node){
  // TODO do trough DFS
  //    }

  int getHeight() {
    return root.getHeight();
  }

  //  boolean isAncestor(IterativeBinaryTreeNode possibleAncestor, IterativeBinaryTreeNode
  // possibleDescendant){
  //      // TODO buscar padre por DFS
  //      IterativeBinaryTreeNode<IterativeBinaryTree> parent = null;
  //
  //  }

  boolean areSiblings(
      IterativeBinaryTreeNode<IterativeBinaryTree> node1,
      IterativeBinaryTreeNode<IterativeBinaryTree> node2) {
    // TODO buscar padre por DFS
    IterativeBinaryTreeNode<IterativeBinaryTree> parent = null;
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

  public void merge(
      IterativeBinaryTreeNode<Item> rootItem,
      IterativeBinaryTree<Item> tree1,
      IterativeBinaryTree<Item> tree2) {
    this.root = rootItem;
    // TODO insert all
  }

  /** returns the number of elements that conform this tree. */
  public int size() {
      if(root==null){
          return 0;
      }else{
          return  1+root.countElements();
      }
  }
}
