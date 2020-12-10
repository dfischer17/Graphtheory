package com.company;

import java.io.File;
import java.util.List;

/**
 * @author Torsten Welsch
 */
public class Main {
    
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.read(new File("C:\\Users\\ManfredFröhler\\IdeaProjects\\Graphtheory\\src\\com\\company\\Linz_Suchproblem.csv"));
        graph.determineShortestPath(1,3);
    }
    
}
