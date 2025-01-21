package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/description/

public class CombinationSumII {
    public void combinationSum(int[] candidates, List<List<Integer>> res, List<Integer> temp, int index, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if (target - candidates[i] >= 0) {
                temp.add(candidates[i]);
                combinationSum(candidates, res, temp, i + 1, target - candidates[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumII combinationSum = new CombinationSumII();
        int[] nums = new int[]{2, 5, 2, 1, 2};
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinationSum.combinationSum(nums, result, temp, 0, 5);
        System.out.println(result);
    }
}
