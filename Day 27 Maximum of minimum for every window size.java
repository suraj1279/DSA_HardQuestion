//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Solution ob =new Solution();
            int[] res = ob.maxOfMin(arr, n);
            
            for (int i = 0; i < n; i++) 
                System.out.print (res[i] + " ");
            System.out.println ();
        }
    }
}
// } Driver Code Ends


-------------------------------------------------------------------------My code-------------------------
class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) 
    {
        int []a=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                int index=st.peek();
                st.pop();
                if(st.isEmpty()){
                    int range=i;
                    a[range-1]=Math.max(a[range-1],arr[index]);
                }
                else{
                    int range=i-st.peek()-1;
                    a[range-1]=Math.max(a[range-1],arr[index]);
                }
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int index=st.peek();
            st.pop();
            if(st.isEmpty()){
                int range=n;
                a[range-1]=Math.max(a[range-1],arr[index]);
            }
            else{
                int range=n-st.peek()-1;
                a[range-1]=Math.max(a[range-1],arr[index]);
            }
        }
        for(int i=n-2;i>=0;i--){
            a[i]=Math.max(a[i+1],a[i]);
        }
        return a;
    }
}
