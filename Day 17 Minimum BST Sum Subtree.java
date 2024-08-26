//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.charAt(0) == 'N') return null;

        // Creating array of Strings from input
        // String after spliting by space
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

    public static Node inputTree(BufferedReader br) throws IOException {
        return buildTree(br.readLine().trim());
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int target;
            target = Integer.parseInt(br.readLine());

            Node root = Node.inputTree(br);

            Solution obj = new Solution();
            int res = obj.minSubtreeSumBST(target, root);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
--------------------------------------------------------------------MY code--------------------------------------

class Solution {
    static int ans=Integer.MAX_VALUE;
    static int []helper(Node root,int target){
        if(root==null){
            int []a={1,0,0,Integer.MAX_VALUE,Integer.MIN_VALUE};
            return a;
        }
        int []left=helper(root.left,target);
        int []right=helper(root.right,target);
        if(root.data<=left[4] || root.data>=right[3]){
            int []a={0,0,0,0,0};
            return a;
        }
        int sum=root.data+left[2]+right[2];
        int n=1+left[1]+right[1];
        if(left[0]==1 && right[0]==1 && target==sum){
            ans=Math.min(ans,n);
        }
        int flag=0;
        if(left[0]==1 && right[0]==1) flag=1;
        int []a={flag,n,sum,Math.min(left[3],root.data),Math.max(right[4],root.data)};
        return a;
    }
    public static int minSubtreeSumBST(int target, Node root) {
        // code here
        ans=Integer.MAX_VALUE;
        int []temp=helper(root,target);
        if(temp[0]==1 && temp[2]==target){
            ans=Math.min(ans,temp[1]);
        }
        if(ans==Integer.MAX_VALUE) return -1;
        else return ans;
    }
}
