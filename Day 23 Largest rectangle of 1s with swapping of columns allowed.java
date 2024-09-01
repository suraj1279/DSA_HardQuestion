//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int r = Integer.parseInt(inputLine[0]);
            int c = Integer.parseInt(inputLine[1]);
            boolean[][] mat = new boolean[r][c];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    mat[i][j] = (Integer.parseInt(inputLine[i * c + j]) == 1);
                }
            }

            int ans = new Solution().maxArea(mat, r, c);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
----------------------------------------------------------My Code------------------------------------------------------------------------

class Solution {
    int getmax(int []arr,int c){
        int ans=0;
        Arrays.sort(arr);
        for(int i=0;i<c;i++){
            ans=Math.max(ans,(arr[i]*(c-i)));
        }
        return ans;
    }
    int maxArea(boolean[][] mat, int r, int c) {
        //create 2d array to store all the data from original 2d array
        int [][]val=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]==true){ //put check if true then put 1 otherwise put 0
                    val[i][j]=1;
                }
                else{
                    val[i][j]=0;
                }
                if(i>0){
                    if(val[i][j]!=0) // in first line copy all the data from original array 
                    val[i][j]+=val[i-1][j];// add privous data with curr data if privious number is 2 then in current number are 3
                }
            }
        }
        int ans=0;
        for(int []arr:val){
            ans=Math.max(ans,getmax(arr,c)); //getmax function sort the array and calculate the maxmum area in one row for each array 
        }
        return ans;
    }
}
