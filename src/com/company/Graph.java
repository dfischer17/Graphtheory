package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author TODO Bitte Gruppenmitglieder eintragen!
 */
public class Graph {

    public void read(File adjacencyMatrix) {
        try {
            // Read matrices rows from file
            List<String> lines = Files.readAllLines(adjacencyMatrix.toPath());

            // Write values into 2d array
            double[][] matrices = new double[50][50];
            for (int y = 0; y < matrices.length; y++) {
                for (int x = 0; x < matrices.length; x++) {
                    String[] lineValues = lines.get(y).split(";");
                    matrices[x][y] = Double.parseDouble(lineValues[x]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Path determineShortestPath(int sourceNodeId, int targetNodeId) {
        return null;
    }
    
    public Path determineShortestPath(int sourceNodeId, int targetNodeId, int... viaNodeIds) {
        return null;
    }
    
    public double determineMaximumFlow(int sourceNodeId, int targetNodeId) {
        return -1.0;
    }
    
    public List<Edge> determineBottlenecks(int sourceNodeId, int targetNodeId) {
        return null;
    }
}
