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
  private BinaryTreeNode<String> anotherTreeNode;

  @Parameterized.Parameters
  public static Collection<Object[]> instancesToTest() {
    return Arrays.asList(
        new Object[] {
          new RecursiveBinaryTreeNode<>("a"),
          new RecursiveBinaryTreeNode<>("b"),
          new RecursiveBinaryTreeNode<>(
              "c", new RecursiveBinaryTreeNode<>("d"), new RecursiveBinaryTreeNode<>("e"))
        },
        new Object[] {
          new IterativeBinaryTreeNodeNode<String>("a"),
          new IterativeBinaryTreeNodeNode<String>("b"),
          new IterativeBinaryTreeNodeNode<>(
              "c", new IterativeBinaryTreeNodeNode<>("d"), new IterativeBinaryTreeNodeNode<>("e"))
        });
  }

  public BinaryTreeNodeTest(
      BinaryTreeNode<String> myTreeNodeParent,
      BinaryTreeNode<String> myTreeNode,
      BinaryTreeNode<String> anotherTreeNode) {
    this.myTreeNode = myTreeNode;
    this.myTreeNodeParent = myTreeNodeParent;
    myTreeNodeParent.setLeft(myTreeNode);
    this.anotherTreeNode = anotherTreeNode;
  }

  @Test
  public void isParent() {
    assertTrue(myTreeNodeParent.isParent());
    assertFalse(myTreeNode.isParent());
    assertTrue(anotherTreeNode.isParent());
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
