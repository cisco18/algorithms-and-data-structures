package com.company;

import java.util.*;

public class Graph {
    private final int[] distance;
    private final Set<Integer> settled;
    private final PriorityQueue<Node> priorityQueue;
    private final int vertices;
    List<List<Node>> adjacent;

    public Graph(int V) {
        this.vertices = V;
        distance = new int[V];
        settled = new HashSet<Integer>();
        priorityQueue = new PriorityQueue<Node>(V, new Node());
    }

    //Graph is based on this djikstra's algorithm and isn't designed to work without it
    public void dijkstra(List<List<Node>> adj, int src) {
        //assign list to the Graph
        this.adjacent = adj;

        for (int i = 0; i < vertices; i++)
            //if output has this number it means there is a hole in the algorithm or a bug
            distance[i] = 3333333;

//Add our source of the Graph and after recursion we add neighboring elements
        priorityQueue.add(new Node(src, 0));

//distance from place A to place A means the distance is 0 so we assign value 0 to it
        distance[src] = 0;
        while (settled.size() != vertices) {
            int u = priorityQueue.remove().node;
            settled.add(u);
            goToNeighbors(u);
        }
    }

    //function to go on to neighbors of Node and check their distances
    private void goToNeighbors(int u) {
        int edgeDistance;
        int newDistance;


        for (int i = 0; i < adjacent.get(u).size(); i++) {
            Node v = adjacent.get(u).get(i);


            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = distance[u] + edgeDistance;


                if (newDistance < distance[v.node])
                    distance[v.node] = newDistance;


                priorityQueue.add(new Node(v.node, distance[v.node]));
            }
        }
    }

    //get function to acces private distance in other Classes
    public int[] getDistance() {
        return distance;
    }

    //recursive function
    void DepthFirstSearch(boolean[] visited, int source) {

        visited[source] = true;
        System.out.print(source + " ");


        Iterator<Node> i = adjacent.get(source).listIterator();


            while (i.hasNext()) {
                int n = i.next().node;
                if (!visited[n]) {
                    DepthFirstSearch(visited, n);

                }
            }
        }


    //recursive helper to start the function

    void DepthFirstSearchHelper(int v, int source) {
//create a table of which nodes were already visited
        boolean[] visited = new boolean[v + 1];

        DepthFirstSearch(visited, source);
    }
}