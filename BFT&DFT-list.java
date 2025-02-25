import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphList {
    private LinkedList<Integer>[] adjacencyList;
    private int numVertices;

    public GraphList(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = (LinkedList<Integer>[]) new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int i, int j) {
        adjacencyList[i].add(j);
        adjacencyList[j].add(i); // For undirected graph
    }

    public void BFT(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int adj : adjacencyList[vertex]) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }

    public void DFT(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited[vertex]) {
                visited[vertex] = true;
                System.out.print(vertex + " ");

                for (int adj : adjacencyList[vertex]) {
                    if (!visited[adj]) {
                        stack.push(adj);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphList graph = new GraphList(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Breadth-First Traversal starting from vertex 0:");
        graph.BFT(0);

        System.out.println("\nDepth-First Traversal starting from vertex 0:");
        graph.DFT(0);
    }
}
