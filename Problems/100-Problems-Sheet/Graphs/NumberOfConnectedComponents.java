class NumberOfConnectedComponents {

  public ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
  public int count = 0;

  public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {

    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      int from = edge[0];
      int to = edge[1];
      graph.get(from).add(to);
      graph.get(to).add(from);
    }

    boolean[] visited = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        ans.add(new ArrayList<>());
        bfs(graph, visited, i);
      }
    }
    return ans;
  }

  public void bfs(List<List<Integer>> graph, boolean[] visited, int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    visited[start] = true;
    ans.get(count).add(start);

    while (!queue.isEmpty()) {
      int node = queue.poll();
      for (int neighbour : graph.get(node)) {
        if (!visited[neighbour]) {
          visited[neighbour] = true;
          queue.offer(neighbour);
          ans.get(count).add(neighbour);
        }
      }
    }
    count++;
  }
}