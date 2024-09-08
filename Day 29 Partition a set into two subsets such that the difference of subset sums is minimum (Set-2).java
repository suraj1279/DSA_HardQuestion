//{ Driver Code Starts
                               import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        int S1=0, S2=0, k=0;
        for(var a : m)
        {
            k++;
            for(int e : a){
                if(k==1) S1+=e;
                else S2+=e;
            }
        }
        
        if(S1 < S2){
            System.out.println(S1);
            System.out.println(S2);
        }
        else{
            System.out.println(S2);
            System.out.println(S1);
        }
    }
    
    
    
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.minDifference(n, arr);
            
            IntMatrix.print(res);
            
        }
    }
}

                               
// } Driver Code Ends


class Solution {
    private static int find(int index,int taken,int currSum,int val,int total,int[] arr) {
        if(index>=arr.length){
            return Integer.MAX_VALUE;
        }
        if(taken==val){
            return currSum;
        }
        int a=find(index+1,taken,currSum,val,total,arr);
        int b=find(index+1,taken+1,currSum+arr[index],val,total,arr);
        if(Math.abs(total-a)<Math.abs(total-b)){
            return a;
        }
        return b;
    }

    public static ArrayList<ArrayList<Integer>> minDifference(int n, int[] arr) {
        // code here
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        int val=n/2;
        int result=find(0,0,0,val,sum/2,arr);
        ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
        ArrayList<Integer>a1=new ArrayList<>();
        ArrayList<Integer>a2=new ArrayList<>();
        a1.add(Math.min(result,sum-result));
        a2.add(Math.max(result,sum-result));
        ans.add(a1);
        ans.add(a2);
        return ans;
    }
}
        
