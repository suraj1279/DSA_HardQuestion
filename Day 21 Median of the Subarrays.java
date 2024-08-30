//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            input_line = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.countSubarray(N, A, M); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends

---------------------------------------------------------------My Code---------------------------------------------------------------------------------
//User function Template for Java
class Solution 
{ 
    long helper(int n,int []a,int m){
        int []arr=new int[2*n+1];
        long ans=0,curr=0;
        arr[n]++;
        int sum=n;
        for(int i=0;i<n;i++){
            if(a[i]<m){
                sum--;
                curr-=arr[sum];
            }
            else{
                curr+=arr[sum];
                sum++;
            }
            ans+=curr;
            arr[sum]++;
        }
        return ans;
    }
    long countSubarray(int N, int A[], int M) 
    { 
        // code here
        long a=helper(N,A,M);
        long b=helper(N,A,M+1);
        return a-b;
    }
} 
