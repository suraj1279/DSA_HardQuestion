//{ Driver Code Starts
import java.io.*;
import java.util.*;

class pair
{
    int first;
    boolean second;
    pair(int first, boolean second)
        {
            this.first = first;
            this.second = second;
        }
}
class Node
{
    int data, height;
    Node left, right;
    
    Node(int x)
    {
        data=x;
        left=right=null;
        height=1;
    }
}
class GfG
{
    public static boolean isBST(Node n, int lower, int upper)
    {
    	if(n==null) return true;
    	if( n.data <= lower || n.data >= upper ) return false;
    	return isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper) ;
    }
    
    public static pair isBalanced(Node n)
    {
    	if(n==null)
    	    {
    	        return new pair(0,true);
    	    }
        
    	pair l = isBalanced(n.left);
    	pair r = isBalanced(n.right);
    
    	if( Math.abs(l.first - r.first) > 1 ) return new pair (0,false);
    
    	return new pair( 1 + Math.max(l.first , r.first) , l.second && r.second );
    }
    
    public static boolean isBalancedBST(Node root)
    {
    	if( isBST(root, Integer.MIN_VALUE , Integer.MAX_VALUE) == false )
    		System.out.print("BST voilated, inorder traversal : ");
    
    	else if ( isBalanced(root).second == false)
    		System.out.print("Unbalanced BST, inorder traversal : ");
    
    	else return true;
    	return false;
    }
    
    public static void printInorder(Node n)
    {
    	if(n==null) return;
    	printInorder(n.left);
    	System.out.print(n.data + " ");
    	printInorder(n.right);
    }


    public static void main(String args[])
        {
            int ip[] = new int[2000];
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    for(int i = 0; i < n; i++)
                        {
                            ip[i] = sc.nextInt();
                        }
                        
                    Node root = null;
                    Solution obj = new Solution();
                    for(int i=0; i<n; i++)
                    {
                        root = obj.insertToAVL( root, ip[i] );
                        
                        if ( isBalancedBST(root) == false )
                            break;
                    }
                    
                    printInorder(root);
                    System.out.println();
                    
                }
            
                
        }
}
// } Driver Code Ends







class Node
{
    int data;
    Node left;
    Node right;
    int height;
};

-------------------------------------------------my code------------------------------------------------------------------------------------------

class Solution
{
    private int getheight(Node root){
        if(root==null){
            return 0;
        }
        return root.height;
    }
    private int getbalance(Node root){
        if(root==null) return 0;
        return getheight(root.left)-getheight(root.right);
    }
    private Node rightrotation(Node root){
        Node child=root.left;
        Node childright=child.right;
        child.right=root;
        root.left=childright;
        root.height=1+Math.max(getheight(root.left),getheight(root.right));
        child.height=1+Math.max(getheight(child.left),getheight(child.right));
        return child;
    }
    private Node leftrotation(Node root){
        Node child=root.right;
        Node childleft=child.left;
        child.left=root;
        root.right=childleft;
        root.height=1+Math.max(getheight(root.left),getheight(root.right));
        child.height=1+Math.max(getheight(root.left),getheight(child.right));
        return child;
    }
    public  Node insertToAVL(Node root,int data)
    {
        //code here
        if(root==null){
            return new Node(data);
        }
        if(data<root.data){
            root.left=insertToAVL(root.left,data);
        }
        else if(data>root.data){
            root.right=insertToAVL(root.right,data);
        }
        else{
            return root;
        }
        root.height=Math.max(getheight(root.left),getheight(root.right))+1;
        int balance=getbalance(root);
        if(balance>1 && data<root.left.data){  
            return rightrotation(root);
        }
        else if(balance<-1 && data>root.right.data){ 6 
            return leftrotation(root);
        }
        else if(balance>1 && data>root.left.data){
            root.left=leftrotation(root.left);
            return rightrotation(root);
        }
        else if(balance<-1 && data<root.right.data){
            root.right=rightrotation(root.right);
            return leftrotation(root);
        }
        else{
            return root;
        }
    }
}    
