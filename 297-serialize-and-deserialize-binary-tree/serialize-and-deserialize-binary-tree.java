/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        String serializeString = "";
        
        if(root == null)
            return "";
        
        serializeString += root.val + " ";
        
        while(!queue.isEmpty()){
            
            int n = queue.size();
            
            while(n > 0){
                
                TreeNode node = queue.poll();
                
                if(node.left != null){
                    serializeString += node.left.val + " ";
                    queue.add(node.left);
                }
                else{
                    
                    serializeString += "# ";

                }
                
                if(node.right != null){
                    serializeString += node.right.val + " ";
                    queue.add(node.right);
                }
                else{
                    
                    serializeString += "# ";

                }
                
                n--;
            }
            
        }
        
        System.out.println(serializeString);
        
        return serializeString;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(data.length() == 0)
            return null;
        
        int index = 0;
        String num = "";
        while(data.charAt(index) != ' '){
            num += data.charAt(index++);
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(num));
        queue.add(root);
        
        index++;
        
        while(!queue.isEmpty() && index < data.length()){
            
            int n = queue.size();
            
            while(n > 0){
                
                TreeNode node = queue.poll();
                
                for(int i=0; i<2 && index < data.length(); i++) {
                    
                    if(data.charAt(index) != '#'){

                        num = "";
                        while(data.charAt(index) != ' '){
                            num += data.charAt(index++);
                        }
                                                
                        TreeNode child = new TreeNode(Integer.parseInt(num));
                        
                        if(i == 0)
                            node.left = child;
                        else
                            node.right = child;
                        
                        queue.add(child);

                        index++;

                    }
                    else{
                        index += 2;
                    }
                }
                
                n--;
                
            }
            
        }
    
        return root;
                
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));