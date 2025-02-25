import java.util.*;

public class BiconnectedComponents {
    private int V;
    private List<Integer>[] adj;
    private int time;

    @SuppressWarnings("unchecked")
    public BiconnectedComponents(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        time = 0;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // For undirected graph
    }

    private void BCCUtil(int u, int disc[], int low[], Stack<Integer> stack, boolean stackMember[]) {
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : adj[u]) {
            if (disc[v] == -1) {
                children++;
                stack.push(u);
                stack.push(v);
                stackMember[v] = true;

                BCCUtil(v, disc, low, stack, stackMember);

                low[u] = Math.min(low[u], low[v]);

                if ((disc[u] == 1 && children > 1) || (disc[u] > 1 && low[v] >= disc[u])) {
                    while (stack.peek() != u && stack.peek() != v) {
                        System.out.print(stack.pop() + " ");
                    }
                    System.out.println(stack.pop() + " " + stack.pop());
                }
            } else if (stackMember[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public void BCC() {
        int disc[] = new int[V];
        int low[] = new int[V];
        boolean stackMember[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(stackMember, false);

        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                BCCUtil(i, disc, low, stack, stackMember);
            }

            int j = 0;
            while (!stack.isEmpty()) {
                stackMember[stack.pop()] = false;
                j++;
            }
            if (j > 1) {
                System.out.print(j + " ");
            }
        }
    }

    public static void main(String[] args) {
        BiconnectedComponents g = new BiconnectedComponents(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(1, 3);
        g.addEdge(3, 4);

        System.out.println("Biconnected components in the graph:");
        g.BCC();
    }
}
