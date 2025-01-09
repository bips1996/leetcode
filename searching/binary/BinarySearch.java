package searching.binary;
//https://leetcode.com/problems/binary-search/description/

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = new int[] {-1,0,3,5,9,12};
        int key = 9;

        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch(arr, key));
    }

    public int binarySearch(int[] arr, int key) {
        return searchBinary(arr, 0, arr.length-1, key); 
    }

    public int searchBinary(int[] arr, int left, int  right, int key){
        if(right<left) {
            return -1;
        }
        int mid = left+ (right-left)/2;
        if(arr[mid] == key) {
            return mid;
            }
        else if(arr[mid]< key) 
            return searchBinary(arr, mid+1, right, key);
        else 
            return searchBinary(arr, left, mid-1, key);
    }
}
