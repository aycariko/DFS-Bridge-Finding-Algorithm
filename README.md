# DFS-Bridge-Finding-Algorithm
A Java implementation to detect and sort critical bridges in undirected graphs using DFS.

# Graph Bridge Detector 
This repository contains a Java implementation for detecting **bridges** (critical edges) in an undirected graph. A bridge is defined as an edge that, when removed, increases the number of connected components in the graph. The algorithm utilizes DFS to efficiently identify these critical connections.

## Features
* **Undirected Graph Implementation:** Uses an adjacency list to represent the graph efficiently.
* **Bridge Detection:** Calculates the initial number of connected components and tests each edge to find the critical ones.
* **Sorted Output:** Automatically sorts the detected bridges numerically for standardized output.
* **Automated Testing:** Includes a dedicated tester class to verify the algorithm against various graph scenarios (cycles, trees, and mixed components) without requiring manual input.

## Project Structure
* `Graph.java`: The core data structure. Handles the creation of the adjacency list, adding/removing edges, and the core DFS logic to count components and find bridges.
* `Main.java`: The entry point for manual testing. Takes standard user input (vertices and edges) to construct the graph and prints the resulting bridges.
* `BridgeTester.java`: A custom test suite containing hardcoded scenarios (Simple Cycle, Tree Graph, Mixed Graph) to validate the graph logic automatically.

## Getting Started

### Prerequisites
* Java Development Kit (JDK) 8 or higher.

### Compilation and Execution

**To run the automated tests:**
1. Compile the files:
   ```bash
   javac BridgeTester.java Graph.java
