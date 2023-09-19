class Solution {
    public int findDuplicate(int[] nums) {
        
        int n = nums.length-1;
        
        int low = 0;
        int high = n;
        
        int minMid = Integer.MAX_VALUE;
        
        while(low <= high){
            
            int mid = (low+high)/2;
            
            if(isAcceptable(nums, mid)){
                minMid = Math.min(minMid, mid);
                high = mid-1;
            }
            else
                low = mid+1;
            
        }
        
        return low;
        
    }
    
    public boolean isAcceptable(int[] nums, int n){
        
        int count = 0;
        
        for(int e : nums){
            
            if(e <= n)
                count++;
            
        }
        
        if(count > n)
            return true;
        else
            return false;
        
    }
}