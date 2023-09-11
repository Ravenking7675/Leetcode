class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        
        for(int i=0; i<groupSizes.length; i++){
            
            if(!map.containsKey(groupSizes[i])){
                map.put(groupSizes[i], new ArrayList<>());
            }
            
        }
        
        for(int i=0; i<groupSizes.length; i++){
            
            List<List<Integer>> list = map.get(groupSizes[i]);
            
            if(list.isEmpty())
            {
                list.add(new ArrayList<>());
                list.get(list.size()-1).add(i);
            }
            else
            {
                
                List<Integer> l = list.get(list.size()-1);
                if(l.size() < groupSizes[i])
                    l.add(i);
                else
                {
                    list.add(new ArrayList<>());
                    list.get(list.size()-1).add(i);
                }
                
            }
            
        }
        
        List<List<Integer>> output = new ArrayList<>();
        
        for (List<List<Integer>> lists : map.values()) {
            output.addAll(lists);
        }
        
        return output;
        
        
        
    }
}