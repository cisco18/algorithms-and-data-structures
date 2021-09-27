package com.company;

import java.util.*;


public class RedBlackTree<T> {

    // Root initialized to nil.
    // Add first element to overwrite it as root
    private RedBlackNode<String> nil = new RedBlackNode<String>(" ", new ArrayList<>());
    private RedBlackNode<String> root = nil;

    public RedBlackTree() {
        root.left = nil;
        root.right = nil;
        root.parent = nil;
    }


    private void leftRotate(RedBlackNode<String> x) {


        leftRotateFixup(x);

        RedBlackNode<String> y;
        y = x.right;
        x.right = y.left;


        if (!isNil(y.left))
            y.left.parent = x;
        y.parent = x.parent;


        if (isNil(x.parent))
            root = y;


        else if (x.parent.left == x)
            x.parent.left = y;


        else
            x.parent.right = y;


        y.left = x;
        x.parent = y;
    }

    //fixup is repairing Red and Black structure
    private void leftRotateFixup(RedBlackNode x) {


        if (isNil(x.left) && isNil(x.right.left)) {
            x.numLeft = 0;
            x.numRight = 0;
            x.right.numLeft = 1;
        } else if (isNil(x.left) && !isNil(x.right.left)) {
            x.numLeft = 0;
            x.numRight = 1 + x.right.left.numLeft +
                    x.right.left.numRight;
            x.right.numLeft = 2 + x.right.left.numLeft +
                    x.right.left.numRight;
        } else if (!isNil(x.left) && isNil(x.right.left)) {
            x.numRight = 0;
            x.right.numLeft = 2 + x.left.numLeft + x.left.numRight;

        } else {
            x.numRight = 1 + x.right.left.numLeft +
                    x.right.left.numRight;
            x.right.numLeft = 3 + x.left.numLeft + x.left.numRight +
                    x.right.left.numLeft + x.right.left.numRight;
        }

    }


    private void rightRotate(RedBlackNode<String> y) {


        rightRotateFixup(y);


        RedBlackNode<String> x = y.left;
        y.left = x.right;


        if (!isNil(x.right))
            x.right.parent = y;
        x.parent = y.parent;


        if (isNil(y.parent))
            root = x;


        else if (y.parent.right == y)
            y.parent.right = x;


        else
            y.parent.left = x;
        x.right = y;

        y.parent = x;

    }


    private void rightRotateFixup(RedBlackNode<String> y) {


        if (isNil(y.right) && isNil(y.left.right)) {
            y.numRight = 0;
            y.numLeft = 0;
            y.left.numRight = 1;
        } else if (isNil(y.right) && !isNil(y.left.right)) {
            y.numRight = 0;
            y.numLeft = 1 + y.left.right.numRight +
                    y.left.right.numLeft;
            y.left.numRight = 2 + y.left.right.numRight +
                    y.left.right.numLeft;
        } else if (!isNil(y.right) && isNil(y.left.right)) {
            y.numLeft = 0;
            y.left.numRight = 2 + y.right.numRight + y.right.numLeft;

        } else {
            y.numLeft = 1 + y.left.right.numRight +
                    y.left.right.numLeft;
            y.left.numRight = 3 + y.right.numRight +
                    y.right.numLeft +
                    y.left.right.numRight + y.left.right.numLeft;
        }

    }


    public void insert(String key, ArrayList<Integer> rows) {
        insert(new RedBlackNode<String>(key, rows));
    }


    private void insert(RedBlackNode<String> z) {


        RedBlackNode<String> y = nil;
        RedBlackNode<String> x = root;


        while (!isNil(x)) {
            y = x;


            if (z.key.compareTo(x.key) < 0) {


                x.numLeft++;
                x = x.left;
            } else {


                x.numRight++;
                x = x.right;
            }
        }

        z.parent = y;


        if (isNil(y))
            root = z;
        else if (z.key.compareTo(y.key) < 0)
            y.left = z;
        else
            y.right = z;


        z.left = nil;
        z.right = nil;
        z.color = RedBlackNode.RED;


        insertFixup(z);

    }

    private void insertFixup(RedBlackNode<String> z) {

        RedBlackNode<String> y = nil;

        while (z.parent.color == RedBlackNode.RED) {


            if (z.parent == z.parent.parent.left) {


                y = z.parent.parent.right;


                if (y.color == RedBlackNode.RED) {
                    z.parent.color = RedBlackNode.BLACK;
                    y.color = RedBlackNode.BLACK;
                    z.parent.parent.color = RedBlackNode.RED;
                    z = z.parent.parent;
                } else if (z == z.parent.right) {


                    z = z.parent;
                    leftRotate(z);
                } else {

                    z.parent.color = RedBlackNode.BLACK;
                    z.parent.parent.color = RedBlackNode.RED;
                    rightRotate(z.parent.parent);
                }
            } else {


                y = z.parent.parent.left;


                if (y.color == RedBlackNode.RED) {
                    z.parent.color = RedBlackNode.BLACK;
                    y.color = RedBlackNode.BLACK;
                    z.parent.parent.color = RedBlackNode.RED;
                    z = z.parent.parent;
                } else if (z == z.parent.left) {

                    z = z.parent;
                    rightRotate(z);
                } else {

                    z.parent.color = RedBlackNode.BLACK;
                    z.parent.parent.color = RedBlackNode.RED;
                    leftRotate(z.parent.parent);
                }
            }
        }

        root.color = RedBlackNode.BLACK;

    }

    public RedBlackNode<String> treeMinimum(RedBlackNode<String> node) {


        while (!isNil(node.left))
            node = node.left;
        return node;
    }


    public RedBlackNode<String> treeSuccessor(RedBlackNode<String> x) {


        if (!isNil(x.left))
            return treeMinimum(x.right);

        RedBlackNode<String> y = x.parent;


        while (!isNil(y) && x == y.right) {

            x = y;
            y = y.parent;
        }

        return y;
    }


    public void remove(String s) {

        RedBlackNode<String> z = search(s);


        RedBlackNode<String> x = nil;
        RedBlackNode<String> y = nil;


        if (isNil(z.left) || isNil(z.right))
            y = z;


        else y = treeSuccessor(z);


        if (!isNil(y.left))
            x = y.left;
        else
            x = y.right;


        x.parent = y.parent;


        if (isNil(y.parent))
            root = x;


        else if (!isNil(y.parent.left) && y.parent.left == y)
            y.parent.left = x;


        else if (!isNil(y.parent.right) && y.parent.right == y)
            y.parent.right = x;


        if (y != z) {
            z.key = y.key;
        }


        fixNodeData(x, y);

        if (y.color == RedBlackNode.BLACK)
            removeFixup(x);
    }


    private void fixNodeData(RedBlackNode<String> x, RedBlackNode<String> y) {


        RedBlackNode<String> current = nil;
        RedBlackNode<String> track = nil;


        if (isNil(x)) {
            current = y.parent;
            track = y;
        } else {
            current = x.parent;
            track = x;
        }


        while (!isNil(current)) {

            if (y.key != current.key) {


                if (y.key.compareTo(current.key) > 0)
                    current.numRight--;


                if (y.key.compareTo(current.key) < 0)
                    current.numLeft--;
            } else {

                if (isNil(current.left))
                    current.numLeft--;
                else if (isNil(current.right))
                    current.numRight--;


                else if (track == current.right)
                    current.numRight--;
                else if (track == current.left)
                    current.numLeft--;
            }


            track = current;
            current = current.parent;

        }

    }

    private void removeFixup(RedBlackNode<String> x) {

        RedBlackNode<String> w;


        while (x != root && x.color == RedBlackNode.BLACK) {


            if (x == x.parent.left) {


                w = x.parent.right;


                if (w.color == RedBlackNode.RED) {
                    w.color = RedBlackNode.BLACK;
                    x.parent.color = RedBlackNode.RED;
                    leftRotate(x.parent);
                    w = x.parent.right;
                }


                if (w.left.color == RedBlackNode.BLACK &&
                        w.right.color == RedBlackNode.BLACK) {
                    w.color = RedBlackNode.RED;
                    x = x.parent;
                } else {

                    if (w.right.color == RedBlackNode.BLACK) {
                        w.left.color = RedBlackNode.BLACK;
                        w.color = RedBlackNode.RED;
                        rightRotate(w);
                        w = x.parent.right;
                    }

                    w.color = x.parent.color;
                    x.parent.color = RedBlackNode.BLACK;
                    w.right.color = RedBlackNode.BLACK;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {


                w = x.parent.left;


                if (w.color == RedBlackNode.RED) {
                    w.color = RedBlackNode.BLACK;
                    x.parent.color = RedBlackNode.RED;
                    rightRotate(x.parent);
                    w = x.parent.left;
                }


                if (w.right.color == RedBlackNode.BLACK &&
                        w.left.color == RedBlackNode.BLACK) {
                    w.color = RedBlackNode.RED;
                    x = x.parent;
                } else {

                    if (w.left.color == RedBlackNode.BLACK) {
                        w.right.color = RedBlackNode.BLACK;
                        w.color = RedBlackNode.RED;
                        leftRotate(w);
                        w = x.parent.left;
                    }


                    w.color = x.parent.color;
                    x.parent.color = RedBlackNode.BLACK;
                    w.left.color = RedBlackNode.BLACK;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }


        x.color = RedBlackNode.BLACK;
    }


    public RedBlackNode<String> search(String key) {


        RedBlackNode<String> current = root;


        while (!isNil(current)) {


            if (current.key.equals(key))


                return current;


            else if (current.key.compareTo(key) < 0)
                current = current.right;


            else
                current = current.left;
        }


        return null;


    }


    private void getGreaterThan(RedBlackNode<String> node, String key,
                                List<String> list) {
        if (isNil(node)) {
            return;
        } else if (node.key.compareTo(key) > 0) {
            getGreaterThan(node.left, key, list);
            list.add(node.key);
            getGreaterThan(node.right, key, list);
        } else {
            getGreaterThan(node.right, key, list);
        }
    }


    private boolean isNil(RedBlackNode node) {

        // return appropriate value
        return node == nil;

    }


    public int size() {


        return root.numLeft + root.numRight + 1;
    }

    public void inOrderHelper() {
        inOrderHelper(root);
    }

    public void inOrderHelper(RedBlackNode node) {
        if (node != nil) {
            inOrderHelper(node.left);
            System.out.println(node.key + " " + node.rows + " ");

            inOrderHelper(node.right);
        }
    }



    public void wszerz() {
        Queue queue = new Queue();
        queue.enqueueB(root);
        while (queue.front!=nil&& queue.front!=null)
        {


            RedBlackNode tempNode = queue.dequeueB();
            System.out.println(tempNode.key + " " + tempNode.rows + " ");


            if (tempNode.left != nil&&tempNode.right != null) {
                queue.enqueue(tempNode.left);
            }


            if (tempNode.right != nil&&tempNode.right != null) {
                queue.enqueue(tempNode.right);
            }

        }
        }


    }

