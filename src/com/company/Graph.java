package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author Daniel Fischer, Pepe Fröhler, Matthias Kroiß
 */
public class Graph {
    int matrices[][] = new int[51][51];

    private Set<Node> nodes = new HashSet<>();

    public void read(File adjacencyMatrix) {

        try {
            // Read matrices rows from file
            List<String> lines = Files.readAllLines(adjacencyMatrix.toPath());

            // Write values into 2d array
            for (int y = 0; y < matrices.length; y++) {
                for (int x = 0; x < matrices.length; x++) {
                    String[] lineValues = lines.get(y).split(";");
                    matrices[x][y] = Integer.parseInt(lineValues[x]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Node getLowestDistanceNode(Set < Node > unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
    private static void CalculateMinimumDistance(Node evaluationNode, int edgeWeigh, Node sourceNode) {
        int sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<Node>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    public Path determineShortestPath(int sourceNodeId, int targetNodeId) {
        //Anfangs Node
        Node startNode = new Node(String.valueOf(sourceNodeId));
        startNode.setDistance(0);

        //End Node
        Node endNode = new Node(String.valueOf(targetNodeId));

        for(int y = 0; y<matrices.length;y++)
        {
            for(int x = 0; x<matrices.length;x++)
            {
                if(matrices[x][y]!=0)
                {
                    Node nodeA = new Node(String.valueOf(y+1)); //Node wo man sich befindet
                    Node nodeB = new Node(String.valueOf(x+1)); //Nächste Node
                    if(nodes.size()==0)
                    {
                        nodeA.addDestination(nodeB,matrices[x][y]);
                        nodes.add(nodeA);
                    }
                    else {
                        boolean added = false;
                        for (Node n : nodes)
                        {
                            if (nodeA.getNode().equals(n.getNode()))
                            {
                                n.addDestination(nodeB, matrices[x][y]);
                                added = true;
                            }
                        }
                        if(added == false)
                        {
                            nodeA.addDestination(nodeB, matrices[x][y]); //matrices[x][y] = Distanz zwischen den beiden nodes && Node Nachbarn werden zur Stammnode hinzugefügt
                            nodes.add(nodeA);
                        }
                    }
                }
            }
        }

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
        unsettledNodes = nodes;

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);

            for (Map.Entry< Node, Integer> adjacencyPair: currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                int edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    CalculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        Path path = new Path();

        return path;
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

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }
}
