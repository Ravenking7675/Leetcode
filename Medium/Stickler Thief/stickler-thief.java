//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return solve(arr, 0, dp);
    }
    
    public int solve(int[] arr, int index, int[] dp){
        
        if(index >= arr.length)
            return 0;
            
        if(dp[index] != -1)
            return dp[index];
            
        int include=0, exclude=0;
        
        include = arr[index] + solve(arr, index+2, dp);
        exclude = 0 + solve(arr, index+1, dp);
        
        dp[index] = Math.max(include, exclude);
        return dp[index];
        
    }
}