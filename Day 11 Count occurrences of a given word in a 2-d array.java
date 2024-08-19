//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 
        
        Integer nextInt(){
            return Integer.parseInt(next());
        }
    } 
    
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t>0)
        {
            int R = sc.nextInt();
            int C = sc.nextInt();
            
            char mat[][] = new char[R][C];
            for(int i=0;i<R;i++)
            {
                for(int j=0;j<C;j++)
                {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
            String target  = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findOccurrence(mat,target));
            
            t--;
        }
    }
}

// } Driver Code Ends
-----------------------------------------------------------------------------------------------My code--------------------------------------------------------------------

//User function Template for Java

class Solution {
    public int findOccurrence(char mat[][], String target) {
        int result = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                result += helper(mat, i, j, target, 0);
            }
        }
        return result;
    }

    public static int helper(char[][] mat, int a, int b, String target, int index) {
        int found = 0;
        if (a < mat.length && a >= 0 && b < mat[0].length && b >= 0 && mat[a][b] == target.charAt(index)) {
            char temp = mat[a][b];
            mat[a][b] = '#';

            if (index == target.length() - 1) {
                found = 1;
            } else {
                found += helper(mat, a, b + 1, target, index + 1);
                found += helper(mat, a, b - 1, target, index + 1);
                found += helper(mat, a - 1, b, target, index + 1);
                found += helper(mat, a + 1, b, target, index + 1);
            }
            mat[a][b] = temp;
        }
        return found;
    }
}
