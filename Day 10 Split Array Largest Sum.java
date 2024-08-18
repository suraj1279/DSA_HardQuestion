//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends

----------------------------------------------------------------------Code--------------------------------------------------------------------
class Solution {
    static int fun(int []a,int maxSum){
        int n=1;
        int s=0;
        for(int i=0;i<a.length;i++){
            if(a[i]+s<=maxSum){
                s+=a[i];
            }
            else{
                n++;
                s=a[i];
            }
        }
        return n;
    }
    static int splitArray(int[] arr , int N, int K) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        
        int low = max;
        int high = sum;
        while(low<=high){
            int mid = (low+high)/2;
            if(fun(arr,mid)<=K){
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return low;
    }
};
