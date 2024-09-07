//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String wild = in.readLine();
            String pattern = in.readLine();
            
            Solution ob = new Solution();
            boolean flag = ob.match(wild, pattern);
            if(flag)
            System.out.println("Yes");
            else
            System.out.println("No");
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
   static boolean find(String wild,String pattern,int i,int j){
        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;
        if(i>=0 && j<0){
            for(int k=0;k<=i;k++){
                if(wild.charAt(k)!='*'){
                    return false;
                }
            }
            return true;
        }
      
        if(wild.charAt(i)==pattern.charAt(j) || wild.charAt(i)=='?'){
            return find(wild,pattern,i-1,j-1);
        }
        else if(wild.charAt(i)=='*'){
          return (find(wild,pattern,i-1,j)|| find(wild,pattern,i,j-1));
        }
        
        return false;
    }
    static boolean match(String wild, String pattern)
    {
        return find(wild,pattern,wild.length()-1,pattern.length()-1);
    }
}
