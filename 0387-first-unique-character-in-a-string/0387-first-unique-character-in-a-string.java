// class Solution {
//     public int firstUniqChar(String s) {
//         char[] arr = s.toCharArray();
        
      
//         for (int i = 0; i < arr.length; i++) {
//             int count = 0;
            
//             for (int j = 0; j < arr.length; j++) {
//                 if (arr[i] == arr[j]) {
//                     count++;
//                 }
//             }
            
           
//             if (count == 1) {
//                 return i;
//             }
//         }
        
       
//         return -1; 
//     }
// } 
class Solution {
    public int firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        // Keep track of characters we have already checked
        boolean[] alreadyChecked = new boolean[26];
        
        for (int i = 0; i < arr.length; i++) {
            // Get the index for the current letter (0 for 'a', 1 for 'b', etc.)
            int charIndex = arr[i] - 'a';
            
            // OPTIMIZATION: If we already scanned this character before, skip it!
            if (alreadyChecked[charIndex]) {
                continue; 
            }
            
            // Mark this character as checked so we never loop for it again
            alreadyChecked[charIndex] = true;
            
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            
            if (count == 1) {
                return i;
            }
        }
        
        return -1; 
    }
}
