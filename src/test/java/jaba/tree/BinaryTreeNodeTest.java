package jaba.tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import jaba.tree.iterative.IterativeBinaryTreeNodeNode;
import jaba.tree.recursive.RecursiveBinaryTreeNode;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BinaryTreeNodeTest {

  private final BinaryTreeNode<String> myTreeNodeParent;
  private BinaryTreeNode<String> myTreeNode;

  @Parameterized.Parameters
  public static Collection<Object[]> instancesToTest() {
    return Arrays.asList(
        new Object[] {
          new RecursiveBinaryTreeNode<String>("a"), new RecursiveBinaryTreeNode<String>("b")
        },
        new Object[] {
          new IterativeBinaryTreeNodeNode<String>("a"), new IterativeBinaryTreeNodeNode<String>("b")
        });
  }

  public BinaryTreeNodeTest(
      BinaryTreeNode<String> myTreeNode, BinaryTreeNode<String> myTreeNodeParent) {
    this.myTreeNode = myTreeNode;
    this.myTreeNodeParent = myTreeNodeParent;
    myTreeNodeParent.setLeft(myTreeNode);
  }

  @Test
  public void isParent() {
    assertTrue(myTreeNodeParent.isParent());
    assertFalse(myTreeNode.isParent());
  }

  @Test
  public void isLeaf() {
    assertTrue(myTreeNode.isLeaf());
    assertFalse(myTreeNodeParent.isLeaf());
  }

  @Test
  public void isParentOf() {
    assertTrue(myTreeNodeParent.isParentOf(myTreeNode));
    assertFalse(myTreeNode.isParentOf(myTreeNodeParent));
  }

  @Test
  public void grade() {
    assertEquals(0, myTreeNode.grade());
    assertEquals(1, myTreeNodeParent.grade());
  }
}
