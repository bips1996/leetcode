package searching.binary;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {5,1,2,3,4};
        FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
        System.out.println(obj.findMinimumInRotatedSortedArray(arr,0,4));
        
    }

    public int findMinimumInRotatedSortedArray(int[] arr, int left, int right) {
        if(left == right) return arr[left];
        if(arr[left] <= arr[right]) return arr[left];
        int mid = left + (right-left)/2;
        if(arr[mid] > arr[right]) 
            return findMinimumInRotatedSortedArray(arr,  mid+1, right);
        else 
            return findMinimumInRotatedSortedArray(arr, left, mid);
    }

}
