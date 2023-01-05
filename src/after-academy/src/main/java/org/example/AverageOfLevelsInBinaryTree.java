package org.example;


import java.util.LinkedList;
import java.util.List;

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

public class AverageOfLevelsInBinaryTree {

    private BTree bTree;

    private Solution solution;

    public AverageOfLevelsInBinaryTree() {
        this.bTree = new BTree(null);

        this.solution = new Solution();
    }

    public class BTree {

        public Node head;

        public BTree(Node head) {
            this.head = head;
        }

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
            BTree tree = new BTree(n1);
            n1.left = n2;
            n1.right = n3;
            return tree;
        }

    }

    public class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }


    public class Solution {

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

    public static void main(String[] args) {
        AverageOfLevelsInBinaryTree a = new AverageOfLevelsInBinaryTree();

        BTree tree = a.bTree.buildBTree();

        tree.print(tree.head);

        LinkedList<Integer> result = a.solution.solution(tree);

        System.out.println(result);

    }
}
