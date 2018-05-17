package jaba.tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import jaba.tree.iterative.IterativeBinaryTree;
import jaba.tree.iterative.IterativeBinaryTreeNodeNode;
import jaba.tree.recursive.RecursiveBinaryTree;
import jaba.tree.recursive.RecursiveBinaryTreeNode;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BinaryTreeTest {

  private final BinaryTree<String> tree;

  @Parameterized.Parameters
  public static Collection<Object[]> instancesToTest() {
    return Arrays.asList(
        new Object[] {new RecursiveBinaryTree<String>()},
        new Object[] {new IterativeBinaryTree<String>()});
  }

  @After
  public void tearDown() throws Exception {
    tree.clear();
  }

  public BinaryTreeTest(BinaryTree<String> tree) {
    this.tree = tree;
  }

  @Test
  public void isRootNode() {
    assertFalse(tree.isRootNode(new RecursiveBinaryTreeNode<>("a")));
    tree.add("a");
    assertTrue(
        tree.isRootNode(
            tree instanceof RecursiveBinaryTree
                ? new RecursiveBinaryTreeNode<>("a")
                : new IterativeBinaryTreeNodeNode<>("a")));
  }

  @Test
  public void grade() {
    assertEquals(0, tree.grade());
    tree.add("b");
    assertEquals(0, tree.grade());
    tree.add("a");
    assertEquals(1, tree.grade());
    tree.add("c");
    assertEquals(2, tree.grade());
    tree.add("d");
    assertEquals(2, tree.grade());
  }
}
