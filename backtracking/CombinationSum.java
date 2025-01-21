package backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/

public class CombinationSum {
    public void combinationSum(int[] nums, List<List<Integer>> result, List<Integer> temp, int index, int target) {
        System.out.println(temp);
        if (target == 0) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                temp.add(nums[i]);
                combinationSum(nums, result, temp, i, target - nums[i]);
                temp.remove(temp.size() - 1);
            }

        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] nums = new int[]{2, 5, 6, 7};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinationSum.combinationSum(nums, result, temp, 0, 7);
        System.out.println(result);
    }
}
