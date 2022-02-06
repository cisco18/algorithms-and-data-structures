package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operations {
    public String sourceToString(int source) {
        switch (source) {
            case (0):
                return "Wrocław";
            case (1):
                return "Oława";
            case (2):
                return "Brzeg";
            case (3):
                return "Nysa";
            case (4):
                return "Opole";

        }
        return "";
    }

    public void print(Graph dpq, int source) {
        Operations operations = new Operations();
        System.out.println("The shorted path from node : " + sourceToString(source));
        for (int i = 0; i < dpq.getDistance().length; i++)
            System.out.println(operations.sourceToString(source) + " to " + operations.sourceToString(i) + " is "
                    + dpq.getDistance()[i]);

    }

    public void addToTheList(List<List<Node>> adj, int a, int b, int c) {
        adj.get(a).add(new Node(b, c));
        adj.get(b).add(new Node(a, c));
    }

    public void createDPQ(int source){
        Operations operations = new Operations();
        int V = 7;


        List<List<Node>> adj = new ArrayList<List<Node>>();


        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

//adding the "cities" from the university homework list
        operations.addToTheList(adj, 0, 1, 10);
        operations.addToTheList(adj, 0, 3, 30);
        operations.addToTheList(adj, 0, 4, 100);
        operations.addToTheList(adj, 2, 4, 10);
        operations.addToTheList(adj, 1, 2, 50);
        operations.addToTheList(adj, 3, 2, 20);
        operations.addToTheList(adj, 3, 4, 60);
        operations.addToTheList(adj, 1, 5, 100);
        operations.addToTheList(adj, 4, 6, 30);


        // Calculate the single source shortest path
        Graph dpq = new Graph(V);
        dpq.dijkstra(adj, source);
        System.out.println("Algorytm DFS, wezly przechodzone sa kolejno:");
        //dla pokazania testowania najlepsze kombinacje source 1 i 4
        dpq.DepthFirstSearchHelper(6, source);
        System.out.println();

    }




    // function to relieve main and ask user for input
    public List<List<Node>> askLoop() {
        System.out.println("Prosze podaj numer miasta od ktorego dystans liczymy");
        System.out.println("0 = Wrocław " + "1 = Oława " + "2 = Brzeg " + "3 = Nysa " + "4 = Opole");

        Scanner scanner = new Scanner(System.in);
        int source = Integer.parseInt(scanner.nextLine());
        Operations operations = new Operations();
        int V = 5;


        List<List<Node>> adj = new ArrayList<List<Node>>();


        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

//adding the "cities" from the university homework list
        operations.addToTheList(adj, 0, 1, 10);
        operations.addToTheList(adj, 0, 3, 30);
        operations.addToTheList(adj, 0, 4, 100);
        operations.addToTheList(adj, 2, 4, 10);
        operations.addToTheList(adj, 1, 2, 50);
        operations.addToTheList(adj, 3, 2, 20);
        operations.addToTheList(adj, 3, 4, 60);

        // Calculate the single source shortest path
        Graph dpq = new Graph(V);
        dpq.dijkstra(adj, source);

        operations.print(dpq, source);

        System.out.println();
        System.out.println("Algorytm DFS, wezly przechodzone sa kolejno:");
        dpq.DepthFirstSearchHelper(4, 0);
        System.out.println();

        return adj;

    }
//print the list as the task asked
    public void showTheList(List<List<Node>> adj) {
        System.out.println("\n Lista prezentuje sie nastepujaco \n");
        int i = 0;
        for (List<Node> list : adj) {
            if (i == 0)
                System.out.println("Wrocław:");
            if (i == 1)
                System.out.println("Oława:");
            if (i == 2)
                System.out.println("Brzeg:");
            if (i == 3)
                System.out.println("Nysa:");
            if (i == 4)
                System.out.println("Opole:");


            i++;
            for (Node node : list) {
                System.out.println(node.toString());
            }
        }


    }
}
