package mst;

import java.util.*;

/**
 * Represents an undirected weighted graph.
 */
public class Graph {
    private final int vertices;
    private final List<Edge> edges;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    /**
     * Add an edge to the graph.
     */
    public void addEdge(int source, int destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }

    public int getVertices() {
        return vertices;
    }

    public List<Edge> getEdges() {
        return new ArrayList<>(edges);
    }

    /**
     * Build MST using Kruskal's algorithm.
     */
    public List<Edge> buildMST() {
        List<Edge> mstEdges = new ArrayList<>();
        List<Edge> sortedEdges = new ArrayList<>(edges);
        Collections.sort(sortedEdges);

        UnionFind uf = new UnionFind(vertices);

        for (Edge edge : sortedEdges) {
            if (uf.union(edge.getSource(), edge.getDestination())) {
                mstEdges.add(edge);
                if (mstEdges.size() == vertices - 1) {
                    break;
                }
            }
        }

        return mstEdges;
    }

    /**
     * Find components after removing an edge from MST.
     */
    public Set<Integer>[] findComponents(List<Edge> mstEdges) {
        UnionFind uf = new UnionFind(vertices);

        for (Edge edge : mstEdges) {
            uf.union(edge.getSource(), edge.getDestination());
        }

        // Group vertices by component
        Map<Integer, Set<Integer>> componentMap = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            int root = uf.find(i);
            componentMap.putIfAbsent(root, new HashSet<>());
            componentMap.get(root).add(i);
        }

        @SuppressWarnings("unchecked")
        Set<Integer>[] components = new Set[componentMap.size()];
        int idx = 0;
        for (Set<Integer> component : componentMap.values()) {
            components[idx++] = component;
        }

        return components;
    }

    /**
     * Find the best replacement edge to reconnect two components.
     * Returns the edge with minimum weight that connects the two components.
     */
    public Edge findReplacementEdge(Set<Integer> component1, Set<Integer> component2) {
        Edge minEdge = null;
        int minWeight = Integer.MAX_VALUE;

        for (Edge edge : edges) {
            boolean connects = (component1.contains(edge.getSource()) && component2.contains(edge.getDestination())) ||
                              (component2.contains(edge.getSource()) && component1.contains(edge.getDestination()));

            if (connects && edge.getWeight() < minWeight) {
                minWeight = edge.getWeight();
                minEdge = edge;
            }
        }

        return minEdge;
    }

    /**
     * Calculate total weight of edges.
     */
    public static int calculateTotalWeight(List<Edge> edges) {
        return edges.stream().mapToInt(Edge::getWeight).sum();
    }
}

