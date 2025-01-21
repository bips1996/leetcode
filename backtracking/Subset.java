package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/subsets/

public class Subset {
    public void findSubsets(List<Integer> list, List<List<Integer>> subsets, List<Integer> subset, int index) {
        subsets.add(new ArrayList<>(subset));
        for (int i = index; i < list.size(); i++) {
            subset.add(list.get(i));
            findSubsets(list, subsets, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<List<Integer>> result = new ArrayList<>();
        new Subset().findSubsets(list, result, new ArrayList<>(), 0);
        System.out.println(result);
    }
}
