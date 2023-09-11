class Solution {
    public int minimumBuckets(String hamsters) {
        
        if(hamsters.length() == 1){
            if(hamsters.charAt(0) == 'H')
                return -1;
            else
                return 0;
        }
        
        
        int[] feed = new int[hamsters.length()];
        
        int foodBasket = 0;
        
        for(int i=0; i<hamsters.length(); i++){
            
            if(hamsters.charAt(i) == '.'){
                
                if(i>0 && i<hamsters.length()-1){

                    if(hamsters.charAt(i-1) == 'H' && hamsters.charAt(i+1) == 'H' &&
                      feed[i-1] != 1 && feed[i+1] != 1){
                        
                        foodBasket++;
                        
                        feed[i-1] = 1;
                        feed[i+1] = 1;
                    }

                }
                
            }
            
        }
        
        int leftOver = 0;
        
        for(int i=0; i<hamsters.length(); i++){
            
            if(hamsters.charAt(i) == 'H' && feed[i] != 1){
                
                if(i == 0 && hamsters.charAt(i+1) == 'H')
                    return -1;
                else if(i == hamsters.length()-1 && 
                        hamsters.charAt(hamsters.length()-2) == 'H')
                    return -1;
                else if(i > 0 && i<hamsters.length()-1 
                        && hamsters.charAt(i-1) == 'H' && hamsters.charAt(i+1) == 'H')
               return -1;
                
                else{
                    leftOver++;
                }
                
            }
            
        }
        
        return foodBasket + leftOver;
        
        
        
    }
}