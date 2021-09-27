package com.company;

import java.util.ArrayList;

class RedBlackNode<String> {


    public static final int BLACK = 0;

    public static final int RED = 1;

    public String key;

    public RedBlackNode next;


    RedBlackNode<String> parent;

    RedBlackNode<String> left;

    RedBlackNode<String> right;

    public int numLeft = 0;

    public int numRight = 0;

    public int color;

    public String string;

    public ArrayList<Integer> rows;

    RedBlackNode(){
        color = BLACK;
        numLeft = 0;
        numRight = 0;
        parent = null;
        left = null;
        right = null;
    }
    RedBlackNode(String s, ArrayList<Integer> rows){
        color = BLACK;
        numLeft = 0;
        numRight = 0;
        parent = null;
        left = null;
        right = null;
        key=s;
        this.rows = rows;

    }

    // Constructor which sets key to the argument.
    RedBlackNode(String key){
        this();
        this.key = key;
    }
}