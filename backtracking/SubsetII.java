package backtracking;

import java.util.*;

//https://leetcode.com/problems/subsets-ii/

public class SubsetII {
    public void findSubsets(int[] nums, List<List<Integer>> subsets, List<Integer> subset, int index) {

        subsets.add(new ArrayList<Integer>(subset));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            findSubsets(nums, subsets, subset, i + 1);
            subset.remove(subset.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 1};
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        new SubsetII().findSubsets(nums, result, new ArrayList<>(), 0);

        System.out.println(result);
    }
}
