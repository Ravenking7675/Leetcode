//{ Driver Code Starts
// Program to find minimum number of platforms
// required on a railway station
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution{

    public:
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    int findPlatform(int arr[], int dep[], int n)
    {
       // plat_needed indicates number of platforms
       // needed at a time
       int ans = 1;
    
       // Run a nested for-loop to find the overlap
       for (int i = 0; i < n; i++) {
    
           // Initially one platform is needed
           int temp = 1;
           for (int j = 0; j < n; j++) {
               if (i != j)
                   // Increment plat_needed when there is an
                   // overlap
                   if (arr[i] >= arr[j] && dep[j] >= arr[i])
                       temp++;
           }
    
           // Update the result
           ans = max(temp, ans);
       }
       return ans;
    }
};


//{ Driver Code Starts.
// Driver code
int main()
{
    int t;
    cin>>t;
    while(t--) 
    {
        int n;
        cin>>n;
        int arr[n];
        int dep[n];
        for(int i=0;i<n;i++)
            cin>>arr[i];
        for(int j=0;j<n;j++){
            cin>>dep[j];
        }
        Solution ob;
        cout <<ob.findPlatform(arr, dep, n)<<endl;
    } 
   return 0;
}
// } Driver Code Ends