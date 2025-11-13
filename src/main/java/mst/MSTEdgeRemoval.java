package mst;

import java.util.*;

/**
 * Main class demonstrating MST edge removal and replacement.
 */
public class MSTEdgeRemoval {

    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("MST Edge Removal and Replacement Demonstration");
        System.out.println("=".repeat(70));
        System.out.println();

        // Create a sample graph
        Graph graph = createSampleGraph();

        // Step 1: Build the MST
        System.out.println("STEP 1: Building Minimum Spanning Tree (MST)");
        System.out.println("-".repeat(70));
        List<Edge> mst = graph.buildMST();
        displayMST(mst);
        System.out.println();

        // Step 2: Remove an edge from MST
        if (mst.isEmpty()) {
            System.out.println("MST is empty. Cannot proceed.");
            return;
        }

        Edge removedEdge = mst.get(2); // Remove the 3rd edge (arbitrary choice)
        System.out.println("STEP 2: Removing Edge from MST");
        System.out.println("-".repeat(70));
        System.out.println("Removed edge: " + removedEdge);
        System.out.println();

        // Create new MST without the removed edge
        List<Edge> mstAfterRemoval = new ArrayList<>(mst);
        mstAfterRemoval.remove(removedEdge);

        // Step 3: Find components after removal
        System.out.println("STEP 3: Finding Components After Edge Removal");
        System.out.println("-".repeat(70));
        Set<Integer>[] components = graph.findComponents(mstAfterRemoval);
        displayComponents(components);
        System.out.println();

        // Step 4: Find replacement edge
        System.out.println("STEP 4: Finding Replacement Edge");
        System.out.println("-".repeat(70));
        if (components.length != 2) {
            System.out.println("Expected 2 components, but found " + components.length);
            return;
        }

        Edge replacementEdge = graph.findReplacementEdge(components[0], components[1]);
        if (replacementEdge != null) {
            System.out.println("Replacement edge found: " + replacementEdge);
            System.out.println();

            // Step 5: Display new MST
            System.out.println("STEP 5: New MST After Reconnection");
            System.out.println("-".repeat(70));
            List<Edge> newMST = new ArrayList<>(mstAfterRemoval);
            newMST.add(replacementEdge);
            displayMST(newMST);
            System.out.println();

            // Summary
            System.out.println("=".repeat(70));
            System.out.println("SUMMARY");
            System.out.println("=".repeat(70));
            System.out.println("Original MST weight: " + Graph.calculateTotalWeight(mst));
            System.out.println("New MST weight:      " + Graph.calculateTotalWeight(newMST));
            System.out.println("Edge removed:        " + removedEdge);
            System.out.println("Edge added:          " + replacementEdge);
            System.out.println("=".repeat(70));
        } else {
            System.out.println("No replacement edge found to reconnect the components!");
        }
    }

    /**
     * Create a sample graph for demonstration.
     */
    private static Graph createSampleGraph() {
        // Create a graph with 6 vertices
        Graph graph = new Graph(6);

        // Add edges (vertex1, vertex2, weight)
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 6);
        graph.addEdge(4, 5, 3);
        graph.addEdge(2, 4, 5);

        System.out.println("Sample Graph Created:");
        System.out.println("Vertices: 6 (labeled 0-5)");
        System.out.println("Edges:");
        for (Edge edge : graph.getEdges()) {
            System.out.println("  " + edge);
        }
        System.out.println();

        return graph;
    }

    /**
     * Display MST edges and total weight.
     */
    private static void displayMST(List<Edge> mst) {
        System.out.println("MST Edges:");
        int totalWeight = 0;
        for (int i = 0; i < mst.size(); i++) {
            Edge edge = mst.get(i);
            System.out.println("  " + (i + 1) + ". " + edge);
            totalWeight += edge.getWeight();
        }
        System.out.println("Total MST Weight: " + totalWeight);
    }

    /**
     * Display components after edge removal.
     */
    private static void displayComponents(Set<Integer>[] components) {
        System.out.println("Number of components: " + components.length);
        for (int i = 0; i < components.length; i++) {
            System.out.println("  Component " + (i + 1) + ": " + components[i]);
        }
    }
}

