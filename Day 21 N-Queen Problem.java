//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java
----------------------------------------------------------------My code--------------------------------------------------------------------
class Solution {
    boolean valid(int i,int j,int [][]dp){
        int i1=i,j1=j;
        while(j1>=0){
            if(dp[i1][j1--]==1){
                return false;
            }
        }
        i1=i;
        j1=j;
        while(i1>=0 && j1>=0){
            if(dp[i1--][j1--]==1) return false;
        } 
        i1=i;j1=j;
        while(i1<dp.length && j1>=0) {
            if(dp[i1++][j1--]==1) return false;
        }
        return true;
    }
    void dfs(int j,int [][]dp,ArrayList<ArrayList<Integer>>ans,int n,ArrayList<Integer>aa){
        if(j==n){
            ans.add(new ArrayList<>(aa));
            return;
        }
        for(int i=0;i<n;i++){
            if(valid(i,j,dp)){
                dp[i][j]=1;
                aa.add(i+1);
                dfs(j+1,dp,ans,n,aa);
                dp[i][j]=0;
                aa.remove(aa.size()-1);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>>a=new ArrayList<>();
        int [][]dp=new int[n][n];
        dfs(0,dp,a,n,new ArrayList<>());
        return a;
    }
}
