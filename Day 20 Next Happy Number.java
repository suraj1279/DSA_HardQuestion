//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
-------------------------------------------------------------Code----------------------------------------------------------------
class Solution{
    static boolean fun(int n){
        if(n==1 || n==7) return true;
        if(n<=9) return false;
        int sum=0;
        while(n!=0){
            int rem=n%10;
            sum+=Math.pow(rem,2);
            n=n/10;
        }
        n=sum;
        return fun(n);
    }
    static int nextHappy(int N){
        // code here
        N=N+1;
        while(true){
            if(fun(N)==true){
                return N;
            }
            else{
                N=N+1;
            }
        }
       
    }
}
