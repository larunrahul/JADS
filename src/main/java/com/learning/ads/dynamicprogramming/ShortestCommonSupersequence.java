package com.learning.ads.dynamicprogramming;

public class ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        char[] s1 = str1.toCharArray(), s2 = str2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        //if length of first string is 0, entire second string is answer
        for(int i = 1; i <= n; i++){
            dp[0][i] = i;
        }
        //if length of second string is 0, entire first string is answer
        for(int i = 1; i <= m; i++){
            dp[i][0] = i;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                /*if both the chars are same, need to add them only once
                  Hence, take that and move to next in both the strings.*/
                if(s1[i - 1] == s2[j - 1]) dp[i][j] = 1 + dp[i - 1][j - 1];
                /*otherwise since both chars are different, our answer must contain both the chars, but which ever gives the minimum length string after adding that 
                  Hence, our answer is 
                  minimum of {the char from str1 at current index which is i appended to char from str1's index - 1(since we already took ith char)},
                  {the char from str2 at current index which is j appended to char from str2's index - 1(since we already took jth char)}*/
                else dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        //dp[m][n] gives the length of shortest common supersequence
        return reconstruct(s1, s2, dp, m, n).toString();
    }
    
    private StringBuilder reconstruct(char[] s1, char[] s2, int[][] dp, int m, int n){
        if(m == 0) return new StringBuilder(new String(s2, 0, n));
        if(n == 0) return new StringBuilder(new String(s1, 0, m));
        StringBuilder ans = new StringBuilder();
        if(s1[m - 1] == s2[n - 1]){
            ans.append(reconstruct(s1, s2, dp, m - 1, n - 1)).append(s1[m - 1]);
        }else {
            if(dp[m][n] == 1 + dp[m - 1][n]) ans.append(reconstruct(s1, s2, dp, m - 1, n)).append(s1[m - 1]);
            else ans.append(reconstruct(s1, s2, dp, m, n - 1)).append(s2[n - 1]);
        }
        return ans;
    }
}
