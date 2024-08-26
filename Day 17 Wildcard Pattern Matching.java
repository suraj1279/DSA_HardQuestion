//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends

------------------------------------------------------------------Code------------------------------------------------
class Solution {
    boolean rec(String p, String s, int i, int j, Boolean[][] dp) {
        if(i==p.length()){
            return j==s.length();
        }
        if(j==s.length()){
            return p.charAt(i)=='*' && rec(p,s,i+1,j,dp);
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        boolean match;
        if(p.charAt(i)=='*'){
            match=rec(p,s,i+1,j,dp)||rec(p,s,i,j+1,dp);
        } else {
            match=(p.charAt(i)==s.charAt(j)||p.charAt(i)=='?')&&rec(p,s,i+1,j+1,dp);
        }
        dp[i][j]=match;
        return match;
    }

    public int wildCard(String pattern, String str){
        int pl=pattern.length();
        int sl=str.length();
        Boolean dp[][]=new Boolean[pl+1][sl+1];
        return rec(pattern,str,0,0,dp)?1:0;
    }

}
