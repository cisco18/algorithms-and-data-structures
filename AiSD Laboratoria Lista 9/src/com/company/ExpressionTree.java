package com.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

public class ExpressionTree {
    Node root;
    // A utility function to check if 'c'
    // is an operator

    public char[] changeToChars(String string) {

        return string.toCharArray();
    }

    boolean isOperator(String c) {
        return c.equals("+") || c.equals("-")
                || c.equals("*") || c.equals("/")
                || c.equals("^") || c.equals("(")
                || c.equals(")");
    }

    public void constructTree(String[] characters) {
        Stack<Node> stack = new Stack<Node>();
        for (String c : characters) {
            Node node = new Node(c);
            if (isOperator(c)) {
                node.right = stack.pop();
                node.left = stack.pop();
                stack.push(node);
            } else {
                stack.push(node);
            }
        }
        root = stack.pop();

    }

    int getLeafCount() {
        return getLeafCount(root);
    }

    int getLeafCount(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        else
            return getLeafCount(node.left) + getLeafCount(node.right);
    }

    int findHeight() {
        return findHeight(root);
    }

    public char integerToCharacter(int integer) {
        String string1 = String.valueOf(integer);
        return string1.charAt(0);

    }

    int calculate(Node node) {
        Node nodeLeft = null;
        Node nodeRight = null;
        if (node.value.equals("*")) {
            if (isOperator(node.left.value)) {
                nodeLeft = new Node(String.valueOf(calculate(node.left)));
            } else {
                nodeLeft = new Node(node.left.value);
            }
            if (isOperator(node.right.value)) {
                nodeRight = new Node(String.valueOf(calculate(node.right)));
            } else {
                nodeRight = new Node(node.right.value);
            }

            int nodeLeftValue = Integer.parseInt(nodeLeft.value);
            int nodeRightValue = Integer.parseInt(nodeRight.value);
            return nodeLeftValue * nodeRightValue;

        }
        if (node.value.equals("/")) {
            if (isOperator(node.left.value)) {
                nodeLeft = new Node(String.valueOf(calculate(node.left)));
            } else {
                nodeLeft = new Node(node.left.value);
            }
            if (isOperator(node.right.value)) {
                nodeRight = new Node(String.valueOf(calculate(node.right)));
            } else {
                nodeRight = new Node(node.right.value);
            }

            int nodeLeftValue = Integer.parseInt(nodeLeft.value);
            int nodeRightValue = Integer.parseInt(nodeRight.value);
            return nodeLeftValue / nodeRightValue;

        }
        if (node.value.equals("+")) {
            if (isOperator(node.left.value)) {
                nodeLeft = new Node(String.valueOf(calculate(node.left)));
            } else {
                nodeLeft = new Node(node.left.value);
            }
            if (isOperator(node.right.value)) {
                nodeRight = new Node(String.valueOf(calculate(node.right)));
            } else {
                nodeRight = new Node(node.right.value);
            }

            int nodeLeftValue = Integer.parseInt(nodeLeft.value);
            int nodeRightValue = Integer.parseInt(nodeRight.value);
            return nodeLeftValue + nodeRightValue;

        }
        if (node.value.equals("-")) {
            if (isOperator(node.left.value)) {
                nodeLeft = new Node(String.valueOf(calculate(node.left)));
            } else {
                nodeLeft = new Node(node.left.value);

            }
            if (isOperator(node.right.value)) {
                nodeRight = new Node(String.valueOf(calculate(node.right)));
            } else {
                nodeRight = new Node(node.right.value);

            }
            int nodeLeftValue = Integer.parseInt(nodeLeft.value);
            int nodeRightValue = Integer.parseInt(nodeRight.value);

            return nodeLeftValue - nodeRightValue;

        }
        if (node.value.equals("^")) {
            if (isOperator(node.left.value)) {
                nodeLeft = new Node(String.valueOf(calculate(node.left)));
            } else {
                nodeLeft = new Node(node.left.value);
            }
            if (isOperator(node.right.value)) {
                nodeRight = new Node(String.valueOf(calculate(node.right)));
            } else {
                nodeRight = new Node(node.right.value);
            }
            int nodeLeftValue = Integer.parseInt(nodeLeft.value);
            int nodeRightValue = Integer.parseInt(nodeRight.value);
            return (int) Math.pow(nodeLeftValue, nodeRightValue);

        }


        return 0;
    }

    int calculate() {
        return calculate(root);
    }

    int findHeight(Node node) {
        if (node == null) {
            return -1;
        }

        int leftH = findHeight(node.left);
        int rightH = findHeight(node.right);

        if (leftH > rightH) {
            return leftH + 1;
        } else {
            return rightH + 1;
        }
    }

    int getNodeCount() {
        return getNodeCount(root);
    }

    int getNodeCount(Node node) {
        if (node == null) {
            return 0;
        } else return getNodeCount(node.left) + getNodeCount(node.right) + 1;
    }

    public void zadanieDodatkowe(Node node) {
        Queue queue = new Queue();
        queue.enqueue(node);
       while (queue.front != null) {
           while (queue.front != null) {
               Node temp = queue.front;
               System.out.print(queue.front.value + " ");
               queue.dequeue();
               if (temp.left!=null)
               queue.enqueue(temp.left);
               if (temp.right!=null)
               queue.enqueue(temp.right);
           }
        }


    }
}
