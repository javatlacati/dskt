package jaba.tree.recursive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/** Created by Administrador on 01/07/2017. */
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class RecursiveBinaryTreeNode<Item> {
  @NonNull private Item value;
  private RecursiveBinaryTreeNode<Item> left;
  private RecursiveBinaryTreeNode<Item> right;

    boolean isParent() {
        return null != left || null != right;
    }

    boolean isLeaf() {
        return left == null && right == null;
    }


}
