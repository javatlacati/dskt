package jaba.tree.recursive;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrador on 01/07/2017.
 */
@Getter
@Setter

public class RecursiveBinaryTreeNode<Item> {
    Item value;
    private RecursiveBinaryTreeNode left;
    private RecursiveBinaryTreeNode right;
}
