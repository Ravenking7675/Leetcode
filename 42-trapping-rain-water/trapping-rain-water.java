class Solution {
    public int trap(int[] arr) {
        
        if(arr.length == 0)
            return 0;
        
        int leftMax = arr[0];
        int rightMax = arr[arr.length-1];

        int l = 0, r = arr.length-1;
        int res = 0;

        while(l < r){

            if(leftMax < rightMax){
                
                l++;
                leftMax = Math.max(leftMax, arr[l]);
                res += Math.max(0, leftMax-arr[l]);

            }
            else{

                r--;
                rightMax = Math.max(rightMax, arr[r]);
                res += Math.max(0, rightMax-arr[r]);

            }

        }        

        return res;
        
    }
}