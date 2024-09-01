package com.vicky.app.b120s.DSA;

public class Dsa_Dp {

    /*
    0-1 knapsack problem
     */


    public static void main(String[] args) {

//        int profit[] = new int[] {60,100,30};
//        int weight[] = new int[] {10,20,30};
//
//        int W = 20;
//        int n = profit.length;
//        System.out.println(knapSackusing_dp(W, weight, profit, n));

        /*
        SubSet of Sum
         */
        int set[] = { 3, 34, 0, 12, 5, 2 };
        int sum = 9;
        int n = set.length;

        System.out.println(isSubSetSum_dp(set,n,sum));
        System.out.println(isSubsetSum(set,n,sum));
    }
    static int knapSack(int W,int wt[],int val[],int n){

        if(n==0 || W==0){
            return 0;
        }
        if(wt[n-1] > W){
            return knapSack(W,wt,val,n-1);
        }
        return Math.max(val[n-1]+knapSack(W-wt[n-1],wt,val,n-1),knapSack(W,wt,val,n-1));
    }

    static int knapSackusing_dp(int W, int wt[],int val[],int n){

        int K[][] = new int[n+1][W+1];

        for(int i=0;i<=n;i++){
            for(int w=0;w<=W;w++){
                if(i==0 || w==0){
                    K[i][w] = 0;
                }else if(wt[i-1]<=w){
                    K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]],K[i-1][w]);
                }else{
                    K[i][w] = K[i-1][w];
                }
            }
        }
        return K[n][W];
    }


    /*
    Subset of Sum
     */
    static boolean isSubsetSum(int set[],int n,int sum){

        if(sum ==0){
            return true;
        }
        if(n==0){
            return false;
        }

        if(set[n-1]>sum){
            return isSubsetSum(set,n-1,sum);
        }

        return isSubsetSum(set,n-1,sum) || isSubsetSum(set,n-1,sum - set[n-1]);

    }

    static boolean isSubSetSum_dp(int set[],int n,int sum){

        boolean subset[][] = new boolean[sum+1][n+1];

        for(int i=0;i<=n;i++){
            subset[0][i] = true;
        }

        for(int j=1;j<=sum;j++){
            subset[j][0] = false;
        }
        for(int i=1;i<=sum;i++){
            for(int j=1;j<=n;j++){
                subset[i][j] = subset[i][j-1];
                if(i >= set[j-1]){
                    subset[i][j] = subset[i][j] || subset[i - set[j-1]][j-1];
                }
            }
        }
        return subset[sum][n];
    }

    /*
    Equal Sum of Partition
     */

    /*
    Count of Subset  Sum
     */

    /*
    Minimum Subset sum Difference.
     */
}
