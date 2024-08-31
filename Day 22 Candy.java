//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minCandy(n, a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
------------------------------------------------------------------Code---------------------------------
class Solution {
    static int minCandy(int N, int ratings[]) {
        // code here
        int sum=0;
        int a[] = new int[N];
        Arrays.fill(a,1);
        for(int i=1;i<N;i++){
            if(ratings[i]>ratings[i-1]){
                a[i] = a[i-1]+1;
            }
        }
        for(int i=N-2;i>=0;i--){
            if(ratings[i]>ratings[i+1] && a[i]<=a[i+1]){
                a[i] = a[i+1]+1;
                
            }
        }
        
        for(int i=0;i<a.length;i++){
            sum +=a[i];
        }
        return sum;
    }
}
