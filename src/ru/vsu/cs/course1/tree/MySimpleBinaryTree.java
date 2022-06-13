package ru.vsu.cs.course1.tree;

import org.w3c.dom.Node;

public class MySimpleBinaryTree extends SimpleBinaryTree<Integer> {

    public void makeNLevelTree (int N) throws IndexOutOfBoundsException {
        if (root != null) clear();
        if (N < 0) throw new IndexOutOfBoundsException();
        root = new SimpleTreeNode(0);
        addNextLevel(N, root);
    }

    private void addNextLevel (int maxLevel, SimpleTreeNode Node) {
        if (Node.value < maxLevel) {
            Node.left = new SimpleTreeNode(Node.value + 1);
            Node.right = new SimpleTreeNode(Node.value + 1);
            addNextLevel(maxLevel, Node.left);
            addNextLevel(maxLevel, Node.right);
        }
    }
}
