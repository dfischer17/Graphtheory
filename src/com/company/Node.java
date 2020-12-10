package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {

    //Name der Node
    private String name;

    //Kürzester Pfad vom Start weg
    private List<Node> shortestPath = new LinkedList<>();

    //Nachbarn zuordnen
    Map<Node, Integer> adjacentNodes = new HashMap<>();

    //Höchster Wert
    private int distance = Integer.MAX_VALUE;

    public Node(String node)
    {
        this.name = node;
    }

    public void addDestination(Node dest, int dist)
    {
        adjacentNodes.put(dest, dist);
    }

    public String getNode() {
        return name;
    }

    public void setNode(String node) {
        this.name = node;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

}
