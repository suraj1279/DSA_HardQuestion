//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int K = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.numOfSubsets(arr,N,K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
----------------------------------------------------------My code------------------------------------
class Solution {
    static int find(int i,int mul,int []arr,int n,int k){
        if(i==n){
            if(mul<=k) return 1;
            else return 0;
        }
        int a=find(i+1,mul,arr,n,k);
        int b=0;
        if(mul*arr[i]<=k)
        b=find(i+1,mul*arr[i],arr,n,k);
        return (a+b);
    }
    static int numOfSubsets(int[] arr, int N, int K) {
        // code here
        return find(0,1,arr,N,K)-1;
    }
};
