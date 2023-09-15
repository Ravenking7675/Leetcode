//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        
        int total = 0;
        
        for(int e: arr)
            total += e;
            
        if(total % 2 != 0)
            return 0;
            
        int target = total/2;
        int[][] dp = new int[N][target+1];
        for(int[] dp_inner: dp)
            Arrays.fill(dp_inner, -1);
        
        int ans = solve(arr, 0, target, dp);
        
        if(ans == Integer.MAX_VALUE)
            return 0;
        else
            return 1;
    
        
    }
    
    static int solve(int arr[], int index, int target, int[][] dp){
        

        if(target == 0)
            return 0;
        
        if(target < 0)
            return Integer.MAX_VALUE;
        
        if(index == arr.length)
            return Integer.MAX_VALUE;
            
        if(dp[index][target] != -1)
            return dp[index][target];
            
        int include = Integer.MAX_VALUE, exclude = Integer.MAX_VALUE;
        
        include = solve(arr, index+1, target-arr[index], dp);
        exclude = solve(arr, index+1, target, dp);
        
        dp[index][target] = Math.min(include, exclude);
        return dp[index][target];
        
        
    }
}
