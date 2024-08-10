//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends

-------------------------------------------------------------my code--------------------------------------------
class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p){
        int []freq=new int[26];
        for(char ch:p.toCharArray()){
            freq[ch-'a']++;
        }
        int []windowFreq=new int[26];
        int i=0, j=0,counter=p.length();
        int minStart=0,minLen=Integer.MAX_VALUE;
        int n=s.length();
        while(j<n){
            char currentChar=s.charAt(j);
            if(freq[currentChar-'a']>0) {
                windowFreq[currentChar-'a']++;
                if (windowFreq[currentChar-'a']<=freq[currentChar-'a']){
                    counter--;
                }
            }
            while(counter==0){ 
                if(j-i+1<minLen){
                    minStart=i;
                    minLen=j-i+1;
                }
                char leftChar=s.charAt(i);
                if (freq[leftChar-'a']>0){
                    windowFreq[leftChar-'a']--;
                    if (windowFreq[leftChar-'a']<freq[leftChar-'a']){
                        counter++;
                    }
                }
                i++;
            }
            j++;
        }
        if(minLen!=Integer.MAX_VALUE) return s.substring(minStart,minStart+minLen);
        else return "-1";
    }
}
