package jaba.tree.iterative;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrador on 01/07/2017.
 */
@Getter
@Setter
public class IterativeBinaryTreeNode<Item> {
    Item value;
    private IterativeBinaryTreeNode left;
    private IterativeBinaryTreeNode right;
}
