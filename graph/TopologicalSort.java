package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    public ArrayList<Integer> topologicalSort(List<List<Integer>> graph) {

        boolean[] visited = new boolean[graph.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                dfs(graph, stack, visited, i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public void dfs(List<List<Integer>> graph, Stack<Integer> stack, boolean[] visited, int node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        stack.push(node);
        for (int n : graph.get(node)) {
            dfs(graph, stack, visited, n);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>());
        graph.add(List.of(3));
        graph.add(List.of(1));
        graph.add(List.of(1, 0));
        graph.add(List.of(0, 2));

        System.out.println(new TopologicalSort().topologicalSort(graph));
    }
}
