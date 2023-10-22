class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        
        helper(candidates, target, 0, 0, new ArrayList<>(), list);
        
        return list;
        
    }
    
    
    public void helper(int[] nums, int target, int sum, int index, List<Integer> temp, List<List<Integer>> list){
        
        if(sum > target)
            return;
        else if(sum == target){
            
            list.add(new ArrayList<>(temp));
            
        }
        else{
            
            for(int i=index; i<nums.length; i++){
                
                temp.add(nums[i]);
                helper(nums, target, sum+nums[i], i, temp, list);
                temp.remove(temp.size()-1);
                
            }
            
        }
        
    }
}