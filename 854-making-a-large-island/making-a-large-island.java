class Solution {
    public int largestIsland(int[][] grid) {
        
        int[] row = {1, -1, 0, 0};
        int[] col = {0, 0, 1, -1};
        
        DisjointSet dSet = new DisjointSet(grid.length*grid[0].length);
        
        for(int i=0; i<grid.length; i++){
            
            for(int j=0; j<grid[0].length; j++){
                
                int u = (i*grid[0].length) + j;
                
                if(grid[i][j] == 0)
                    continue;
                
                for(int k=0; k<=3; k++){
                    
                    int x = i+row[k];
                    int y = j+col[k];
                    
                    if(isValid(x, y, grid) && grid[x][y] == 1){
                        
                        int v = (x*grid[0].length) + y;
                    
                        dSet.union(u, v);
                        
                    }
                    
                }
                
            }
            
        }
        
        int maxIsland = 0;
        
        for(int i=0; i<grid.length; i++){
            
            for(int j=0; j<grid[0].length; j++){
                
                if(grid[i][j] == 0){
                    
                    Set<Integer> set = new HashSet<>();
                    
                    for(int k=0; k<=3; k++){
                        
                        int x = i+row[k];
                        int y = j+col[k];
                        
                        if(isValid(x, y, grid) && grid[x][y] == 1){
                            
                            int v = (x*grid[0].length) + y;
                            set.add(dSet.findParent(v));
                            
                        }
                        
                    }
                    
                    int sum = 0;
                    
                    for(int u: set){
                        
                        sum += dSet.size.get(u);
                        
                    }
                    
                    maxIsland = Math.max(maxIsland, sum+1);
                    
                }
                
            }
            
        }
        
        
        for(int i=0; i<=grid.length*grid[0].length; i++){
            
            maxIsland = Math.max(maxIsland, dSet.size.get(dSet.findParent(i)));
            
        }
        
        return maxIsland;
        
        
    }
    
    public boolean isValid(int i, int j, int[][] arr){
        
        if(i<0 || j<0 || i==arr.length || j == arr[0].length)
            return false;
        return true;
        
    }
}

class DisjointSet {
    
    public List<Integer> parent = new ArrayList<>();
    public List<Integer> size = new ArrayList<>();
    int n;
    
    public DisjointSet(int n){
        
        this.n = n;
        
        for(int i=0; i<=n; i++){
            parent.add(i);
            size.add(1);
        }
        
        
    }
    
    public int findParent(int node){
        
        if(node == parent.get(node))
            return node;
        
        int u_parent = findParent(parent.get(node));
        
        parent.set(node, u_parent);
        return parent.get(node);
        
    }
    
    public void union(int u, int v){
        
        int u_parent = findParent(u);
        int v_parent = findParent(v);
        
        if(u_parent == v_parent)
            return;
        
        if(size.get(u_parent) < size.get(v_parent)){
            
            parent.set(u_parent, v_parent);
            size.set(v_parent, size.get(v_parent) + size.get(u_parent));
            
        }
        else{
            parent.set(v_parent, u_parent);
            size.set(u_parent, size.get(v_parent) + size.get(u_parent));
        }
    }
    
}