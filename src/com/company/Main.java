package com.company;

import java.io.File;
import java.util.List;

/**
 * @author Torsten Welsch
 */
public class Main {
    
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.read(new File("C:\\Users\\Daniel\\OneDrive\\HTL Unterlagen\\4. Jhg\\AUD\\Graphentheorie\\Graphtheory\\Suchproblem.csv"));
    }
    
}
