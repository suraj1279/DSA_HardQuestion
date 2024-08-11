//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java
------------------------------------------------------------------My code--------------------------------------------------------------------------

class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
        int []c=new int[n+m];
        int i=0,j=0,k=0;
        while(i<n && j<m){
            if(a[i]<b[j]){
                c[k]=a[i];
                i++;
                k++;
            }
            else{
                c[k]=b[j];
                k++;
                j++;
            }
        }
        while(i<n){
            c[k]=a[i];
            k++;
            i++;
        }
        while(j<m){
            c[k]=b[j];
            k++;
            j++;
        }
        int len=c.length;
        if(len%2==0){
            return ((c[len/2-1])+(c[len/2]))/2.0;
        }
        else{
            return c[len/2];
        }
    }
}
