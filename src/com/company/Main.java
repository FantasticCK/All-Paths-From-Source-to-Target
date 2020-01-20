package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if (graph.length == 0)
            return res;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph, 0, graph.length - 1, list, res);
        return res;
    }

    private void dfs(int[][] graph, int curr, int dst, List<Integer> list, List<List<Integer>> res) {
        if (curr == dst) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int neighbor : graph[curr]) {
            list.add(neighbor);
            dfs(graph, neighbor, dst, list, res);
            list.remove(list.size() - 1);
        }
    }
}