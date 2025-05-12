import java.util.*;

public class Main {
    static class Edge {
        char dest;
        int weight;

        Edge(char dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Graph {
        Map<Character, List<Edge>> adjList = new HashMap<>();

        void addEdge(char src, char dest, int weight) {
            adjList.putIfAbsent(src, new ArrayList<>());
            adjList.get(src).add(new Edge(dest, weight));
        }

        void buildGraph() {
            addEdge('A', 'B', 4);
            addEdge('A', 'E', 7);
            addEdge('B', 'A', 4);
            addEdge('B', 'C', 1);
            addEdge('B', 'D', 2);
            addEdge('C', 'B', 1);
            addEdge('C', 'C', 6);
            addEdge('D', 'B', 2);
            addEdge('D', 'C', 6);
            addEdge('E', 'A', 7);
        }

        void printGraph() {
            for (char vertex : adjList.keySet()) {
                System.out.print(vertex + "->\n");
                for (Edge edge : adjList.get(vertex)) {
                    System.out.println(edge.dest + ": " + edge.weight + ", ");
                }
                System.out.println();
            }
        }

        void printConnectedVerticesCount() {
            for (char vertex : adjList.keySet()) {
                Set<Character> uniqueNeighbors = new HashSet<>();
                for (Edge edge : adjList.get(vertex)) {
                    uniqueNeighbors.add(edge.dest);
                }
                System.out.println(vertex + ": " + uniqueNeighbors.size());
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.buildGraph();

        System.out.println("- Print the vertices of the Graph");
        graph.printGraph();

        System.out.println("— Print the number of connected vertices of the Graph");
        graph.printConnectedVerticesCount();
    }
}