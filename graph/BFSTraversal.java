package graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFSTraversal {
    public List<Integer> bfs(List<List<Integer>> graph, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(source);
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[graph.size()];
        visited[source] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res.add(curr);

            for (Integer node : graph.get(curr)) {
                if (visited[node]) {
                    continue;
                }
                queue.add(node);
                visited[node] = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>());
        graph.add(List.of(2, 3));
        graph.add(List.of(1, 4, 5));
        graph.add(List.of(1, 4));
        graph.add(List.of(2, 3, 5));
        graph.add(List.of(2, 4));

        System.out.println(new BFSTraversal().bfs(graph, 5));
    }
}
