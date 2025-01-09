package jayanth.arrays.prefixSum;

public class SpecialIndex {

    public static void main(String[] args){
        int A[] = {2, 1, 6, 4};
        
        int res = solve(A);

        System.out.println(res);
    }

    public static int solve(int[] A) {
        int n = A.length;
        int even_pSum[] = new int[n];
        int odd_pSum[] = new int[n];

        even_pSum[0] = A[0];
        odd_pSum[0] = 0;
        int count = 0;
        int oddSum = 0;
        int evenSum = 0;

        for(int i = 1; i < n; i++){
            if(i % 2 == 0){
                even_pSum[i] = even_pSum[i - 1] + A[i];
                odd_pSum[i] = odd_pSum[i - 1];
            }else{
                odd_pSum[i] = odd_pSum[i - 1] + A[i];
                even_pSum[i] = even_pSum[i - 1];
            }
        }

        for(int i = 0; i < n; i++){
            if(i == 0){
                oddSum = even_pSum[n - 1];
                evenSum = odd_pSum[n - 1];
            }else{
                oddSum = odd_pSum[i - 1] + (even_pSum[ n - 1] - even_pSum[i]);
                evenSum = even_pSum[i - 1] + (odd_pSum[n - 1] - odd_pSum[i]);
            }

            if(evenSum == oddSum){
                count++;
            }
        }

        return count;

    }
}
