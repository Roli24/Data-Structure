

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        
        int[] text = new int[256];
        int[] pattern = new int[256];
        
        int M = txt.length();
        int N = pat.length();
        
        for(int i =0; i<N; i++)
        {
            text[txt.charAt(i)]++;
            pattern[pat.charAt(i)]++;
            
        }
        int count =0;
        for(int i=N; i<M ;i++)
        {
            if(Arrays.equals(text, pattern))
                count++;
            text[txt.charAt(i)]++;
            text[txt.charAt(i-N)]--;
        }
        if (Arrays.equals(text, pattern))
            count++;
        return count;
    }
}
