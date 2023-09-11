class Solution {
    public int numOfSubarrays(int[] arr) {
        
        if(arr.length == 1 && arr[0] % 2 != 0)
            return 1;
        
        double MOD = 1000000007;
        
        int oddCount = 0;
        int evenCount = 0;
        
        if(arr[0] % 2 == 0)
            evenCount = 1;
        
        int sum = 0;
        int count = 0;
        
        for(int i=0; i<arr.length; i++){
            
            sum = (int)(((sum) % MOD + (arr[i]) % MOD) % MOD);
            
            if(sum == 1){
                
                oddCount++;
                evenCount++;
                count++;
                
            }
            else if(sum % 2 == 0){
                
                evenCount++;
                count = (int)(((count)% MOD + (oddCount)% MOD)% MOD) ;
                
            }
            else{
                
                oddCount++;
                
                if(evenCount == 0){
                    count = (int)(((count)% MOD + 1)% MOD);
                    evenCount = 1;
                }
                else 
                    count = (int)(((count)% MOD + (evenCount)% MOD)% MOD);
                
            }
            
        }
        
        return (int)(count % MOD);
        
    }
}