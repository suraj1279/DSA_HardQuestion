//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} class GfG {
    public static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
   

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            
            String s = br.readLine();
            Node root = buildTree(s);
         
            Solution ob=new Solution();
            System.out.println( ob.distributeCandy(root));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}*/
--------------------------------------------------------My code---------------------------------------

class Solution
{
    static int solve(Node root,int []cnt){
        if(root==null) return 0;
        int leftans=solve(root.left,cnt);
        int rightans=solve(root.right,cnt);
        cnt[0]+=Math.abs(leftans)+Math.abs(rightans);
        return root.data-1+leftans+rightans;
    }
    public static int distributeCandy(Node root)
    {
        //code here
        int []cnt={0};
        solve(root,cnt);
        return cnt[0];
        
    }
}
