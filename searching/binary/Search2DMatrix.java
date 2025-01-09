package searching.binary;
//https://leetcode.com/problems/search-a-2d-matrix/description/
public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] array = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        Search2DMatrix sm = new Search2DMatrix();

        System.out.println(sm.searchMatrix(array, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        boolean op = false;
        int[] row0  = new int[matrix.length];
        for(int i=0;i<matrix.length;i++) 
            row0[i] = matrix[i][0];
        
        int relevantRow = getRow(row0, 0, row0.length-1, target);
        if(relevantRow == -1) return false;
        else if(matrix[relevantRow][0] == target) return true;
        else {
            int res = searchBinary(matrix[relevantRow],0,matrix[relevantRow].length-1, target);
            if(res != -1) return true;
        }
        
        return op;
    }

    public int getRow(int[] arr, int left, int right,int target){
        if(right < left) return -1;
        int mid = left + (right-left)/2;

        if(target == arr[mid]) return mid;
        else if (target > arr[mid] && (mid + 1 >= arr.length || target < arr[mid + 1])) return mid;
        else if(target > arr[mid]) 
            return getRow(arr, mid+1, right, target);
        else 
            return getRow(arr, left, mid-1, target);
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
