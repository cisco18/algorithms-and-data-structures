package com.company;


public class HuffmanNode implements Comparable<HuffmanNode> {
    char character;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;
    HuffmanNode next;
    String binaryCode;

    HuffmanNode(char value) {
        this.character = value;
        right = null;
        left = null;
        next = null;
        binaryCode = "";
    }

    public char getCharacter() {
        return character;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public HuffmanNode getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "character=" + character +
                ", frequency=" + frequency +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return frequency-o.frequency;
    }
}
