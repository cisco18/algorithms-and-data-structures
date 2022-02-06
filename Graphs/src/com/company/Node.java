package com.company;

import java.util.Comparator;

class Node implements Comparator<Node> {
    public int node;
    public int cost;

    public Node() {
    }

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.cost < node2.cost)
            return -1;
        if (node1.cost > node2.cost)
            return 1;
        return 0;
    }

    @Override
    public String toString() {
        switch (node) {
            case (0):
                return "Wrocław " + cost;
            case (1):
                return "Oława " + cost;
            case (2):
                return "Brzeg " + cost;
            case (3):
                return "Nysa " + cost;
            case (4):
                return "Opole " + cost;

        }
        return " ";
    }
}