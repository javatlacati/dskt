package jaba.tree.iterative;

import jaba.stack.AutoGrowingArrayBasedStack;
import jaba.tree.BinaryTree;
import jaba.tree.BinaryTreeNode;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.var;
import org.jetbrains.annotations.NotNull;

/** Created by Administrador on 02/07/2017. */
@Getter
@NoArgsConstructor
public class IterativeBinaryTree<Item extends Comparable<Item>> implements BinaryTree<Item> {
  private IterativeBinaryTreeNodeNode<Item> root;

  public IterativeBinaryTree(Item rootValue) {
    root = new IterativeBinaryTreeNodeNode<>(rootValue);
  }

  /** path size from root to specified node. */
  int getDepth(IterativeBinaryTreeNodeNode<Item> node) {
    // TODO do trough DFS
    return 0;
  }

  int getHeight() {
    return root.getHeight();
  }

  //  boolean isAncestor(IterativeBinaryTreeNodeNode possibleAncestor, IterativeBinaryTreeNodeNode
  // possibleDescendant){
  //      // TODO buscar padre por DFS
  //      IterativeBinaryTreeNodeNode<IterativeBinaryTree> parent = null;
  //
  //  }

  boolean areSiblings(
      IterativeBinaryTreeNodeNode<Item> node1, IterativeBinaryTreeNodeNode<Item> node2) {
    // TODO buscar padre por DFS
    IterativeBinaryTreeNodeNode<Item> parent = null;
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
  @Override
  public void clear() {
    root = null;
  }

  public boolean isEmpty() {
    return root == null;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @NotNull
  @Override
  public Iterator iterator() {
    return null;
  }

  @NotNull
  @Override
  public Item[] toArray() {
    AutoGrowingArrayBasedStack<IterativeBinaryTreeNodeNode<Item>> auxiliaryStack =
        new AutoGrowingArrayBasedStack<>();

    var currentNode = root;
    addLeftNodesToStack(auxiliaryStack, currentNode);

    while (auxiliaryStack.size() > 0) {
      currentNode = auxiliaryStack.peek();

      if (currentNode.getLeft() != null) {
        if (currentNode.getRight() != null) {
          addLeftNodesToStack(auxiliaryStack, currentNode.getRight());
        }
      }
    }

    return (Item[])
        Stream.of(auxiliaryStack.toArray())
            .map(IterativeBinaryTreeNodeNode::getValue)
            .collect(Collectors.toList())
            .toArray();
  }

  @Override
  public boolean add(Item item) {
    if (root == null) {
      root = new IterativeBinaryTreeNodeNode<>(item);
      return true;
    } else {
      var currentNode = root;
      while (item.compareTo(currentNode.getValue()) < 0) {
        if (currentNode.getLeft() != null) {
          currentNode = currentNode.getLeft();
        } else {
          currentNode.setLeft(new IterativeBinaryTreeNodeNode<>(item));
          break;
        }
      }
      while (item.compareTo(currentNode.getValue()) >= 0) {
        if (currentNode.getRight() != null) {
          currentNode = currentNode.getRight();
        } else {
          currentNode.setRight(new IterativeBinaryTreeNodeNode<>(item));
          break;
        }
      }
      return true;
    }
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public boolean addAll(@NotNull Collection c) {
    return false;
  }

  @Override
  public boolean retainAll(@NotNull Collection c) {
    return false;
  }

  @Override
  public boolean removeAll(@NotNull Collection c) {
    return false;
  }

  @Override
  public boolean containsAll(@NotNull Collection c) {
    return false;
  }

  @NotNull
  @Override
  public Object[] toArray(@NotNull Object[] a) {
    return new Object[0];
  }

  public void merge(
      Item rootItemValue, IterativeBinaryTree<Item> tree1, IterativeBinaryTree<Item> tree2) {
    if (!tree1.getRoot().equals(tree2.getRoot()))
      if (tree1.getRoot() != null) {
        if (tree2.getRoot() != null) {
          this.root =
              new IterativeBinaryTreeNodeNode<>(rootItemValue, tree1.getRoot(), tree2.getRoot());
        }
      }
    // TODO insert all
  }

  /** returns the number of elements that conform this tree. */
  public int size() {
    if (root == null) {
      return 0;
    } else {
      int numberOfElements = 0;
      AutoGrowingArrayBasedStack<IterativeBinaryTreeNodeNode<Item>> auxiliaryStack =
          new AutoGrowingArrayBasedStack<>();

      var currentNode = root;
      addLeftNodesToStack(auxiliaryStack, currentNode);

      while (!auxiliaryStack.isEmpty()) {
        currentNode = auxiliaryStack.pop();
        numberOfElements = numberOfElements + 1;
        if (currentNode.getLeft() != null) {
          if (currentNode.getRight() != null) {
            //            numberOfElements = numberOfElements + 1;
            addLeftNodesToStack(auxiliaryStack, currentNode.getRight());
          }
        }
      }

      return numberOfElements;
    }
  }

  @Override
  public boolean isRootNode(BinaryTreeNode node) {
    return root != null && root.equals(node); // TODO send to abstract class
  }

  @Override
  public int grade() {
    return root == null ? 0 : getMaxSubtreeGrade();
  }

  private int getMaxSubtreeGrade() {
    int maxGrade = 0;
    AutoGrowingArrayBasedStack<IterativeBinaryTreeNodeNode<Item>> auxiliaryStack =
        new AutoGrowingArrayBasedStack<>();

    var currentNode = root;
    addLeftNodesToStack(auxiliaryStack, currentNode);

    while (auxiliaryStack.size() > 0) {
      currentNode = auxiliaryStack.pop();
      int grade = 0;
      if (currentNode.getLeft() != null) {
        grade++;
        if (currentNode.getRight() != null) {
          grade++;
          addLeftNodesToStack(auxiliaryStack, currentNode.getRight());
          if (grade == 2) {
            return grade;
          }
        }

        if (grade > maxGrade) {
          maxGrade = grade;
        }
      }
    }

    return maxGrade;
  }

  private void addLeftNodesToStack(
      AutoGrowingArrayBasedStack<IterativeBinaryTreeNodeNode<Item>> auxiliaryStack,
      IterativeBinaryTreeNodeNode<Item> currentNode) {
    while (currentNode != null) {
      auxiliaryStack.push(currentNode);
      currentNode = currentNode.getLeft();
    }
  }

  private void addLeftNodesToStackAndCount(
      AutoGrowingArrayBasedStack<IterativeBinaryTreeNodeNode<Item>> auxiliaryStack,
      IterativeBinaryTreeNodeNode<Item> currentNode,
      int numberOfElements) {
    while (currentNode != null) {
      numberOfElements = numberOfElements + 1;
      auxiliaryStack.push(currentNode);
      currentNode = currentNode.getLeft();
    }
  }
}
