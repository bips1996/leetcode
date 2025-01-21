package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/permutations/submissions/1515582102/
public class Permutation {
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }

    public void permute(int[] nums, List<List<Integer>> permutations, int start) {
        if (start == nums.length) {
            permutations.add(Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.toList())
            );
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            permute(nums, permutations, start + 1);
            swap(nums, i, start);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        new Permutation().permute(nums, result, 0);

        System.out.println(result);
    }
}
