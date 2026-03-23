// Title: Graph class
// Author: İrem Ayça/Uçankale
// ID: 12293337022
// Section: 02
// Assignment: HW1 Q1
/* Description: This class, which implements an undirected graph data structure, is designed to identify “bridges” (critical edges that split the graph into more fragments when removed)
within the graph using the DFS algorithm.*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    public int V;// number of vertecies
    public LinkedList<Integer> adj []; // An array that will hold the neighbors of each node
    public boolean markedTo [];// track whether a node has been visited in the DFS algorithm
    //The class's constructor method. Runs when a new graph object is created.
    public Graph(int V){
        this.V = V;
        adj = (LinkedList<Integer>[]) new LinkedList[V];// cast

        for(int v = 0; v<V ; v++){
            adj [v]= new LinkedList<Integer>();// inside of bag array structure
        }
    }
    // since our graph is undirected, two-way connection is established.
    public void addEdge(int u, int v) {
        adj[v].add(u);
        adj[u].add(v);

    }
    // remove edges
    private void removeEdge(int u, int v) {
        // we use Integer because we want to delete the object that is the node itself.
        adj[u].remove(Integer.valueOf(v));
        adj[v].remove(Integer.valueOf(u));
    }

    // basic dfs algorithm
    private void dfs(int u, boolean[] markedTo) {
        markedTo[u] = true;
        for (int v : adj[u]) {
            if (!markedTo[v]) {
                dfs(v, markedTo);
            }
        }
    }
//It implements the Comparable interface so that we can sort the bridges later.
    public static class Edge implements Comparable<Graph.Edge> {
        public int u;//One end of the edge
        public int v;//The other end of the edge
        // smallest number always come first
        public Edge(int u, int v) {
            this.u = Math.min(u, v);
            this.v = Math.max(u, v);
        }

       // @Override sort logic
        public int compareTo(Graph.Edge other) {
            // First, compare the ‘u’ nodes. If the ‘u's are different, the edge with the smaller 'u’ takes precedence.
            if (this.u != other.u) {
                return Integer.compare(this.u, other.u);
            }
            return Integer.compare(this.v, other.v);
        }
    }

    // A method for determining the number of connected components.
    private int countComponents() {
        boolean[] visited = new boolean[V];//an array of boolean for if island visited or not
        int count = 0; // ada sayacı
        for (int i = 0; i < V; i++) {
            // If island ‘i’ has not yet been visited, this means we have encountered a new component island group .
            if (!visited[i]) {
                dfs(i, visited); // marked visited
                count++;
            }
        }
        return count;
    }
//critical edges that increase the number of components in a graph when removed
    public List<Edge> findBridges() {
        List<Edge> bridges = new LinkedList<>();
        List<Edge> allEdges = new ArrayList<>();

        // start by making a list of all existing bridges
        for (int u = 0; u < V; u++) {
            for (int v : adj[u]) {
                if (u < v) { // to avoid counting doubles
                    allEdges.add(new Edge(u, v));
                }
            }
            }
        //We’re counting how many pieces the country is in, even though not a single bridge has been destroyed.
        int initialComponents = countComponents();
        // remove temporarily
        for (Edge edge : allEdges) {
            removeEdge(edge.u, edge.v);

            int currentComponents = countComponents();
           // If the number of pieces has increased, it means it has been divided
            if (currentComponents > initialComponents) {
                bridges.add(edge);
            }
         // for testing other graphs again add edges
            addEdge(edge.u, edge.v);
        }

        return bridges;
    }

}

