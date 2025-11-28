class Solution {
    static long count;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // Step 1: Build Adjacency List
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        count = 0;

        // Step 2: DFS from root (0)
        dfs(0, -1, graph, values, k);

        return (int)count;
    }

    static int dfs(int node, int parent, List<Integer>[] graph, int[] values, int k) {
        long sum = values[node];

        for (int next : graph[node]) {
            if (next == parent) continue;
            sum += (dfs(next, node, graph, values, k))%k;
        }

        // If this subtree forms a valid component
        if (sum % k == 0) {
            count++;
            return 0;   // cut here
        }

        return (int)(sum)%k;     // pass sum to parent
    }
}
