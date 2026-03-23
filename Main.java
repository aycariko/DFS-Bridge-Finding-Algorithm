import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int Y = scanner.nextInt();//vertex number
        int U = scanner.nextInt();//edge number

        Graph graph = new Graph(Y);

        // Add bridges to the graph with start and end nodes
        for (int i = 0; i < U; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        scanner.close();
        //calling the findBridges method,store the critical bridges in a list named bridges.
        List<Graph.Edge> bridges = graph.findBridges();

        Collections.sort(bridges);

        System.out.println("Bridge list:");
        for (Graph.Edge edge : bridges) {
            System.out.println(edge.u + " " + edge.v);
        }

        System.out.println("Total bridges: " + bridges.size());
    }
}
