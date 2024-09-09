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
            long L = Long.parseLong(input_line[1]); 
            long R = Long.parseLong(input_line[2]); 
            input_line = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            long ans = ob.countSubarray(N, A, L, R); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java-------------------------------My code--------------------------------------------
class Solution 
{ 
    long calculate(int n,int []a,long r){
        long ans=0;
        long sum=0;
        int i=0;
        int j=0;
        while(j<n){
            sum+=a[j];
            while(sum>r){
                sum-=a[i];
                i++;
            }
            ans+=(j-i+1);
            j++;
        }
        return ans;
    }
    long countSubarray(int N,int A[],long L,long r) {
        // code here
        return calculate(N,A,r)-calculate(N,A,L-1);
    }
} 
