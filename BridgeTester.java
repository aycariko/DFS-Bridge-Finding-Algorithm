import java.util.Collections;
import java.util.List;

public class BridgeTester {

    public static void main(String[] args) {

        System.out.println("--- Test 1: Simple Cycle (No Bridges) ---");
        // Vertices: 0, 1, 2, 3
        // Edges: 0-1, 1-2, 2-3, 3-0 (Removing any single edge will not disconnect the graph)
        // Expected output: Total bridges: 0
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};
        runTest(4, edges1);

        System.out.println("\n--- Test 2: Tree Graph (All Edges are Bridges) ---");
        // Vertices: 0, 1, 2, 3
        // Edges: 0-1, 1-2, 2-3 (Straight line. Removing any edge splits the graph)
        // Expected output: 0-1, 1-2, 2-3
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}};
        runTest(4, edges2);

        System.out.println("\n--- Test 3: Mixed Graph (Two Triangles Connected by a Bridge) ---");
        // Vertices: 0, 1, 2, 3, 4, 5
        // Triangle 1: 0-1, 1-2, 2-0
        // Triangle 2: 3-4, 4-5, 5-3
        // Connecting Bridge: 2-3
        // Expected output: Bridge list: 2 3 (Total bridges: 1)
        int[][] edges3 = {{0, 1}, {1, 2}, {2, 0}, {2, 3}, {3, 4}, {4, 5}, {5, 3}};
        runTest(6, edges3);
    }

    // Helper test method simulating the logic in the Main class for Q1
    private static void runTest(int V, int[][] edges) {
        Graph graph = new Graph(V);

        // Add edges to the graph
        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
        }

        // Find bridges using the method from the Graph class
        List<Graph.Edge> bridges = graph.findBridges();

        // Sort the bridges as required
        Collections.sort(bridges);

        // Print the results
        System.out.println("Bridge list:");
        for (Graph.Edge edge : bridges) {
            System.out.println(edge.u + " " + edge.v);
        }

        System.out.println("Total bridges: " + bridges.size());
    }
}
