package jayanth.arrays.prefixSum;

//question 

/*
You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.

Problem Constraints
1 <= N, M <= 105
1 <= A[i] <= 109
0 <= L <= R < N

Input Format
The first argument is the integer array A.
The second argument is the 2D integer array B.

Output Format
Return an integer array of length M where ith element is the answer for ith query in B.

Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = [[0, 3], [1, 2]]

Output 1:
[10, 5]
*/
public class RangeSum {
    public static void main(String[] args){
        int A[] = {1, 2, 3, 4, 5};
        int B[][] = {{0, 3}, {1, 2}};

        long res[] = rangeSum(A, B);

        for(int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }
    public static long[] rangeSum(int[] A, int[][] B) {
        long[] res = new long[B.length];
        long[] preSum = new long[A.length];
    
        preSum[0] = A[0];
        for(int i = 1; i < A.length; i++){
            preSum[i] = preSum[i - 1] + A[i];
        }
    
        for(int i = 0; i < B.length; i++){
            int start = B[i][0];
            int end = B[i][1];
    
            if(start == 0){
                res[i] = preSum[end];
            }else{
                res[i] = preSum[end] - preSum[start - 1];
            }
        }
        return res;
    }
}
