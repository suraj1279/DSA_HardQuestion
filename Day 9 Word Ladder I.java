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
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends
-------------------------------------------------------------------My code------------------------------------------------------------------------

class Pair{
    String first;
    int second;
    Pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution
{
    
    public int wordLadderLength(String startWord, String target, String[] wordList)
    {
        // Code here
        Queue<Pair>q=new LinkedList<>();
        Set<String>hs=new HashSet<>();
        for(int i=0;i<wordList.length;i++){
            hs.add(wordList[i]);
        }
        q.add(new Pair(startWord,1));
        hs.remove(startWord);
        while(!q.isEmpty()){
            String word=q.peek().first;
            int dist=q.peek().second;
            q.remove();
            if(word.equals(target)) {
                return dist;
            }
            char []wordarray=word.toCharArray();
            for(int i=0;i<wordarray.length;i++){
                
                char originalChar=wordarray[i];
                for(char j='a';j<='z';j++){
                    wordarray[i]=j;
                    String str=new String(wordarray);
                    if(hs.contains(str)){
                        hs.remove(str);
                        q.add(new Pair(str,dist+1));
                    }
                }
                wordarray[i] = originalChar;
            }
        }
        return 0;
    }
}
