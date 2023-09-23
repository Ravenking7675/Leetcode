class Solution {
    public boolean search(int[] nums, int target) {
        
        if(nums.length==0)
            return false;
        
        int n = nums.length;
        int low = 0;
        int high = nums.length-1;
        
        int pivot = -1;
        
        while(low <= high){
            
            int mid = (low + high)/2;
            
            if(nums[mid] == target)
                return true;
                        
            if(nums[low] == nums[mid] && nums[high] == nums[mid])
            {
                low++; high--;
                continue;
            }
            
            if(nums[low] <= nums[mid])
            {
                
                if(target >= nums[low] && target <= nums[mid])
                {
                    high = mid-1;
                }
                else
                    low = mid+1;
                
            }
            else{
                
                if(target >= nums[mid] && target <= nums[high])
                    low = mid+1;
                else
                    high = mid-1;
                
            }
            
        }
        
        return false;
        
    }

}