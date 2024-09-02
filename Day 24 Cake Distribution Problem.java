//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [] sweetness = new int[n];
			str = br.readLine().trim().split(" ");
			int i = 0;
			for(String s: str) {
				sweetness[i++] = Integer.parseInt(s);
			}
			Solution obj = new Solution();
			System.out.println(obj.maxSweetness(sweetness, n, k));
		}
	}
}

// } Driver Code Ends


//User function Template for Java
-----------------------------------------------------------My Code-----------------------------------------

class Solution{
    boolean possible(int []a,int mid,int K){
        int cnt=0,sum=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            if(sum>=mid){
                cnt++;
                sum=0;
            }
        }
        if(cnt>=K+1) return true;
        else return false;
    }
	int maxSweetness(int [] a, int N, int K) {
	    // Write your code here.
	    int sum=0,min=Integer.MAX_VALUE;
	    for(int i=0;i<N;i++){
	        sum+=a[i];
	        min=Math.min(min,a[i]);
	    }
	    int ans=0;
	    int low=min;
	    int high=sum;
	    while(low<=high){
	        int mid=(low+high)/2;
	        if(possible(a,mid,K)){
	            ans=mid;
	            low=mid+1;
	        }
	        else{
	            high=mid-1;
	        }
	    }
	    return ans;
	}
}
