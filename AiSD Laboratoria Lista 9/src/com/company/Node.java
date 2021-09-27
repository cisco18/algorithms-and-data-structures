package com.company;

public class Node {
    String value;
    Node left;
    Node right;
    Node next;

    Node(String value) {
        this.value = value;
        right = null;
        left = null;
        next = null;
    }

    public String getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}