package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Daniel Fischer, Pepe Fröhler, Matthias Kroiß
 */
public class Graph {
    double matrices[][] = new double[50][50];
    public void read(File adjacencyMatrix) {
        try {
            // Read matrices rows from file
            List<String> lines = Files.readAllLines(adjacencyMatrix.toPath());

            // Write values into 2d array
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

        //Set values
        boolean visited[] = new boolean[50];
        double distance[] = new double[50];

        for(int i = 0; i<50;i++)
        {
            distance[i] = Double.MAX_VALUE;
            visited[i] = false;

        }
        distance[sourceNodeId] = 0.0;

        //Update distances
        double shortestDistance = 0.0;
        for(int i = 0; i<50;i++)
        {
            int index = shortestDistanceIndex(visited,distance);
            visited[index] = true;
            for(int j = 0;j<50;j++)
            {
                if(distance[index]+matrices[index][j]<distance[j]&&!(visited[j])&&matrices[index][j]!=0.0&&distance[index]!=Integer.MAX_VALUE)
                {
                    distance[j] = distance[index]+ matrices[index][j];
                    if(targetNodeId == j)
                    {
                        shortestDistance = distance[j];
                        break;
                    }
                }
            }
        }
        System.out.println(shortestDistance);
        return null;
    }
    public int shortestDistanceIndex(boolean visited[], double distance[])
    {
        double min = Double.MAX_VALUE;
        int index = -1;
        for(int i =0; i<50; i++)
        {
            if(distance[i]<=min && !visited[i])
            {
                min = distance[i];
                index = i;
            }
        }
        return index;
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
