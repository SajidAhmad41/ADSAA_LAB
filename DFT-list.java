import java.util.LinkedList;

public class Graph {
    private LinkedList<Integer>[] adjacencyList;
    private int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int i, int j) {
        adjacencyList[i].add(j);
        adjacencyList[j].add(i); // For undirected graph
    }

    public void DFT(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        DFTUtil(startVertex, visited);
    }

    private void DFTUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adjacencyList[vertex]) {
            if (!visited[neighbor]) {
                DFTUtil(neighbor, visited);
            }
        }
    }
}
