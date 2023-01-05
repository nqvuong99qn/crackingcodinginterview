package org.example;

import java.util.LinkedList;
import java.util.Stack;

// find the largest element kTh in the BST
class FindKLargestElementBST {
    public static void main(String[] string) {

        System.out.println("--------  SAY HI ---------");
        Solution s = new Solution();
        Solution.BST tree = s.tree.mockBST();

        System.out.println(s.solution1(tree, 2));
        System.out.println(s.solution2(tree, 2));
    }
}

class Solution {
    public BST tree;

    public Solution() {
        this.tree = new BST();
    }

    public class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }

    public class BST {
        // Node
        private Node head;
        private int size = 0;

        void addNewNode(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                this.size++;
            } else {
                Node temp = head;
                Node currentRoot = head;
                while (temp != null) {
                    currentRoot = temp;
                    if (temp.value < value) {
                        temp = temp.right;
                    } else if (temp.value > value) {
                        temp = temp.left;
                    }
                }
                if (currentRoot.value > value) {
                    currentRoot.left = newNode;
                    this.size++;
                } else {
                    currentRoot.right = newNode;
                    this.size++;
                }
            }
        }

        void print(Node head) {
            if (head != null) {
                print(head.left);
                System.out.print(head.value + "-->");
                print(head.right);
            }
        }

        public LinkedList<Integer> inorderTraversal(Node head, LinkedList<Integer> result) {
            if (head != null) {
                inorderTraversal(head.left, result);
                result.add(head.value);
                inorderTraversal(head.right, result);
            }
            return result;
        }

        public BST mockBST() {
            BST tree = new BST();
            tree.addNewNode(1);
            tree.addNewNode(3);
            tree.addNewNode(2);
            return tree;
        }


    }

    int solution1(BST tree, int K) {
        //  get  inorderTraversal of BST
        LinkedList<Integer> listElementsSorted = tree.inorderTraversal(tree.head, new LinkedList<>());
        // get the index with Kth largest
        int index = tree.size - K;
        return listElementsSorted.get(index);
    }

    int solution2(BST tree, int K) {
        if (tree.head == null) {
            return -1;
        }
        Node head = tree.head;
        // use stack here
        // init stack
        Stack<Node> stack = new Stack<>();
        int count = 0;

        while (head != null || stack.size() > 0) {

            // traversal to right most
            while (head != null) {
                stack.push(head);
                head = head.right;
            }
            head = stack.pop();
            count++;
            if (count == K) {
                return head.value;
            }
            head = head.left;
        }
        return -1;
    }
}

