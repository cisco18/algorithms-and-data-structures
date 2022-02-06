package com.company;

import java.util.Arrays;

class Graph {
    //edge to polaczenie miedzy punktami grafu w naszym przypadku liny oswietlenia
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    //subset do algorytmu union find algorithm
    private static class subset {
        int parent, rank;
    }

    int vertices, edges;
    Edge[] edge;

    //tworzymy graf o v liczbie punktow i e liczbie polaczen
    public Graph(int v, int e) {
        vertices = v;
        edges = e;
        edge = new Edge[edges];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    // funkcja rekursywna wglab subsetu zwracajaca root lub subset jesli wykryty zostanie cykl

    public int find(subset[] subsets, int i) {

        if (subsets[i].parent != i)
            subsets[i].parent
                    = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }


    // laczymy subsety w drzewo

    void union(subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank
                < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank
                > subsets[yroot].rank)
            subsets[yroot].parent = xroot;


        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }


    public void kruskalAlgorithm() {
//tworzymy minimalnie rozpinajace drzewo o liczbie polaczen rownej liczbie punktow -1
//metoda sprawdza czy dodajac krawedz tworzy cykl jesli nie to uwzglednia ja
        Edge[] result = new Edge[vertices];


        int i;
        for (i = 0; i < vertices; ++i)
            result[i] = new Edge();

        Arrays.sort(edge);

        subset[] subsets = new subset[vertices];
        for (i = 0; i < vertices; ++i)
            subsets[i] = new subset();


        for (int v = 0; v < vertices; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;

        int e = 0;
        //liczba bedzie rowna vertices - 1 zgodnie z algorytmem
        while (e < vertices - 1) {

            Edge next_edge = edge[i];
            i++;
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);


            if (x != y) {
                result[e++] = next_edge;
                union(subsets, x, y);
            }

        }

        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
            minimumCost += result[i].weight;
        }
        System.out.println("Dlugosc w centrymetrach to "
                + minimumCost);
    }
}