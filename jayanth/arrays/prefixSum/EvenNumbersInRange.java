package jayanth.arrays.prefixSum;

//question

/*
 You are given an array A of length N and Q queries given by the 2D array B of size Q×2. Each query consists of two integers B[i][0] and B[i][1]. 
 For every query, your task is to find the count of even numbers in the range from A[B[i][0]] to A[B[i][1]].

 Problem Constraints

 1 <= N <= 105
 1 <= Q <= 105
 1 <= A[i] <= 109
 0 <= B[i][0] <= B[i][1] < N

 Input Format
 First argument A is an array of integers.
 Second argument B is a 2D array of integers.

 Output Format
 Return an array of integers.

 Input 1:
 A = [1, 2, 3, 4, 5]
 B = [   [0, 2] 
        [2, 4]
        [1, 4]   ]

 Output 1:
 [1, 1, 2]

 Explanation
 For Input 1:
 The subarray for the first query is [1, 2, 3] (index 0 to 2) which contains 1 even number.
 The subarray for the second query is [3, 4, 5] (index 2 to 4) which contains 1 even number.
 The subarray for the third query is [2, 3, 4, 5] (index 1 to 4) which contains 2 even numbers.
 
*/

public class EvenNumbersInRange {

    public static void main(String[] args){
       int A[] = {1, 2, 3, 4, 5};
        int B[][] = {{0, 2}, {2, 4}, {1, 4}};

        int res[] = solve(A, B);

        for(int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }

    public static int[] solve(int[] A, int[][] B) {
        int res[] = new int[B.length];
        int preSum[] = new int[A.length];

        if(A[0] % 2 == 0){
            preSum[0] = 1;
        }else{
            preSum[0] = 0;
        }

        for(int i = 1; i < A.length; i++){
            if(A[i] % 2 == 0){
                preSum[i] = preSum[i - 1] + 1;
            }else{
                preSum[i] = preSum[i - 1];
            }
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
