class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty string matches empty pattern
        dp[0][0] = true;
        
        // Handle patterns like a*, a*b*, a*b*c* matching an empty string
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pChar = p.charAt(j - 1);
                
                if (pChar == '*') {
                    // Case 1: Match 0 times
                    dp[i][j] = dp[i][j - 2];
                    
                    // Case 2: Match 1 or more times (if preceding chars match)
                    char prevPChar = p.charAt(j - 2);
                    if (prevPChar == s.charAt(i - 1) || prevPChar == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    // Normal character or '.' matching
                    if (pChar == s.charAt(i - 1) || pChar == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}
