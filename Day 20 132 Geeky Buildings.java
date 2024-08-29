//{ Driver Code Starts
//Initial template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int arr[]= new int[n];
            for(int i=0; i<n; i++)
                arr[i] = sc.nextInt();
            Solution ob = new Solution();
            if(ob.recreationalSpot(arr,n))
                System.out.println("True");
            else
                System.out.println("False");
        }
	}
}
// } Driver Code Ends


//User function template for C++
---------------------------------------------------------Code-------------------------------------------

class Solution{
    static boolean recreationalSpot(int[] arr , int n){
        // Your code goes here 
        if(n<3)return false;
        int mx=arr[1];
        int mn=arr[0];
        for(int i=2;i<n;i++){
            if(arr[i]<mx && arr[i]>mn)return true;
             mx=Math.max(arr[i],mx);
            if(mn>arr[i-1] && arr[i-1]!=mx)mn=arr[i-1];
        }
        return false;
    }
};
