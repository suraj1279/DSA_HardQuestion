//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

-------------------------------------------------------My Code-----------------------------------------
class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
	class Triplet{
	    int row;
	    int col;
	    int weight;
	    Triplet(int row,int col,int weight){
	        this.row=row;
	        this.col=col;
	        this.weight=weight;
	    }
	}
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int [][]ans=new int[n][m];
        for(int []i:ans){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        ans[0][0]=grid[0][0];
        int [][]dir={{0,1},{1,0},{0,-1},{-1,0}};
        
        PriorityQueue<Triplet>pq=new PriorityQueue<>((Triplet a,Triplet b)->(a.weight-b.weight));
        pq.add(new Triplet(0,0,grid[0][0]));
        while(!pq.isEmpty()){
            Triplet triplet=pq.poll();
            int row=triplet.row;
            int col=triplet.col;
            int weight=triplet.weight;
            for(int []a:dir){
                int new_row=row+a[0];
                int new_col=col+a[1];
                if(new_row>=0 && new_row<n && new_col>=0 && new_col<m && (ans[new_row][new_col]>weight+grid[new_row][new_col])){
                    ans[new_row][new_col]=weight+grid[new_row][new_col];
                    pq.add(new Triplet(new_row,new_col,ans[new_row][new_col]));
                }
            }
        }
        return ans[n-1][m-1];
    }
}
