package org.example;


import java.util.LinkedList;

/**
 * Problem: https://afteracademy.com/blog/average-of-levels-in-binary-tree/
 */
/*
Analysis:
Binary tree is the tree which the root with two childs
  1
 /  \
2   3

get all Node for each level then compute

 */

class AverageOfLevelsInBinaryTree {

    public static void main(String[] args) {
        S1 s = new S1();

        BTree b = new BTree();
        BTree tree = b.buildBTree();
        tree.print(tree.head);
        s.solution(tree);
    }
}

class BTree {

    public Node head = null;

    void print(Node node) {
        if (node != null) {
            print(node.left);
            System.out.print(node.value + "-->");
            print(node.right);
        }
    }

    BTree buildBTree() {
        Node n1 = new Node(1);
        Node n2 = new Node(5);
        Node n3 = new Node(3);
        BTree tree = new BTree();
        tree.head = n1;
        n1.left = n2;
        n1.right = n3;
        return tree;
    }
}

class Node {
    Node left;
    Node right;
    int value;

    public Node(int value) {
        this.left = null;
        this.right = null;
        this.value = value;
    }

}


class S1 {
    public LinkedList<Integer> solution(BTree tree) {

        // ideal
            /*
            use the temp queue
            push root to queue.

            while(queue is not empty){
              dequeue element to handle
              sum temp to sum all element in this level
              currentLevelNoNode to save the number of node of current level
              {
                 loop all elements of this level
                 right traversal
                 left traversal
                 push element to queue
                 increase the number of node

              } => computer the average then save to result list.

            }
             */

        // corner case first
        if (tree.head == null) {
            throw new RuntimeException("STOP");
        }

        LinkedList<Node> queue = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();

        queue.add(tree.head);
        // add the first  to queue result
        result.add(tree.head.value);


        while (!queue.isEmpty()) {
            int previousLevelNoNode = queue.size();
            int sum = 0;
            Node currNode = queue.remove();
            int currLevelNoNode = 0;

            while (previousLevelNoNode > 0) {
                if (currNode.left != null) {
                    currLevelNoNode++;
                    queue.add(currNode.left);
                    sum += currNode.left.value;
                }
                if (currNode.right != null) {
                    currLevelNoNode++;
                    queue.add(currNode.right);
                    sum += currNode.right.value;
                }
                previousLevelNoNode--;
            }
            if (currLevelNoNode > 0) {
                result.add((sum / currLevelNoNode));
            }
        }
        return result;
    }
}
