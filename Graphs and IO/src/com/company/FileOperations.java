package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileOperations {
    public void operate(){
        System.out.println("Podaj nazwe pliku do odczytu: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            File file = new File(name);
            Scanner scanner1 = new Scanner(file);
            String firstLine = scanner1.nextLine();
            String[] strings = firstLine.split(" ");
            System.out.println(strings[0] + " " + strings[1]);
            Graph graph = new Graph(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
            int i = 0;
            while (scanner1.hasNext()){
                String line = scanner1.nextLine();
                String[] lineSplit = line.split(" ");
                graph.edge[i].src = Integer.parseInt(lineSplit[0])-1;
                graph.edge[i].dest = Integer.parseInt(lineSplit[1])-1;
                graph.edge[i].weight = Integer.parseInt(lineSplit[2]);
                System.out.println(lineSplit[0] + lineSplit[1] + lineSplit[2]);
                i++;
            }
            graph.kruskalAlgorithm();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
