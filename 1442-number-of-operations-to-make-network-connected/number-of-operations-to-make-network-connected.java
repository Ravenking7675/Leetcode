class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        DisjointSet ds = new DisjointSet(n);
        
        int extra_edge = 0;
        
        for(int[] connect: connections){
            
            int u = connect[0];
            int v = connect[1];
            
            if(ds.findParent(u) == ds.findParent(v))
                extra_edge++;
            else
                ds.union(u, v);
            
        }
        
        
        int component = 0;
        for(int i=0; i<n; i++){
            
            if(ds.parent.get(i) == i)
                component++;
            
        }
        
        if(extra_edge >= component-1)
            return component - 1;
        else
            return -1;
        
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