//{ Driver Code Starts
import java.util.*;

class Partition_Arr_To_K_Subsets
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			Solution g = new Solution();
			if(g.isKPartitionPossible(a,n,k)==true)
				System.out.println(1);
			else 
				System.out.println(0);
			
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method */
--------------------------------------------------------------------My code---------------------------------------------
class Solution
{
     public boolean fun(int sum,int[] a,int n,int k,int curr,boolean[] check){
        if(k==0){
            return true;
        }
        if(curr==sum){
            return fun(sum,a,n,k-1,0,check);
        }
        if(curr>sum) return false;
        for(int i=0; i<n; i++){
            if(!check[i]){
                check[i]=true;
                if(fun(sum,a,n,k,curr+a[i],check)){
                    return true;
                }
                check[i]=false;
            }
        }
        
        return false;
    }
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
        }
        if(k>n || sum%k!=0){
            return false;
        }
        boolean []check=new boolean[n];
        sum=sum/k;
        boolean ans=fun(sum,a,n,k,0,check);
        return ans;
    }
}
