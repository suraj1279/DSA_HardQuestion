//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String str = read.readLine().trim(); 
            Solution obj = new Solution();
            int ans = obj.palindromeSubStrs(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    int palindromeSubStrs(String str) { 
        // code here
        Set<String>hs=new HashSet<>();
        for(int i=0;i<str.length();i++){
            int l=i,h=i;
            while(l>=0 && h<str.length()){
                if(str.charAt(l)==str.charAt(h)){
                    hs.add(str.substring(l,h+1));
                    l--;
                    h++;
                }
                else{
                    break;
                }
            }
            l=i;
            h=i+1;
            while(l>=0 && h<str.length()){
                if(str.charAt(l)==str.charAt(h)){
                    hs.add(str.substring(l,h+1));
                    l--;
                    h++;
                }
                else{
                    break;
                }
            }
        }
        return hs.size();
    }
} 
