class Solution {
    
    public int minimumEffortPath(int[][] heights) {
        
        int[] row = {1, -1, 0, 0};
        int[] col = {0, 0, 1, -1};
        
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> (a.diff-b.diff));
        
        pq.add(new Tuple(0, 0, 0));
        
        int[][] diff = new int[heights.length][heights[0].length];
        
        for(int[] inner_dist: diff)
            Arrays.fill(inner_dist, Integer.MAX_VALUE);
        
        diff[0][0] = 0;
        
        while(!pq.isEmpty()){
            
            Tuple tuple = pq.poll();
            
            int dif = tuple.diff;
            int x = tuple.x;
            int y = tuple.y;
            
            if(x == heights.length-1 && y == heights[0].length-1)
                return dif;
            
            for(int i=0; i<4; i++){
                
                int X = x + row[i];
                int Y = y + col[i];
                
                if(isValid(X, Y, heights)){
                    
                    int newEffort = Math.max(Math.abs(
                        heights[X][Y] - heights[x][y]), dif);
                    
                    if(newEffort < diff[X][Y]){
                        diff[X][Y] = newEffort;
                        pq.add(new Tuple(diff[X][Y], X, Y));
                    }
                    
                }
                
            }
            
        }

        return 0;
        
    }
    
    public boolean isValid(int x, int y, int[][] arr){
        
        if(x < 0 || x == arr.length || y < 0 || y == arr[0].length)
            return false;
        return true;
        
    }
    
    
}

class Tuple {
    
    public int diff;
    public int x;
    public int y;
    
    public Tuple(int diff, int x, int y){
        this.diff = diff;
        this.x = x;
        this.y = y;
    }
    
}