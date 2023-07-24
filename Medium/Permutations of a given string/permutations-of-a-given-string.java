//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        List<String> ans = new ArrayList<String>();
        int n=S.length();
        
        permute(S,"",n,ans);
        Collections.sort(ans);
        return ans;
    }
    
    static void permute(String S,String per,int n,List<String> ans)
    {
        if(per.length()==n)
        {
            if(!ans.contains(per))
              ans.add(per);
            return ;
        }
        
        for(int i=0;i<S.length();i++)
        {
            char c=S.charAt(i);
            String left=S.substring(0,i)+S.substring(i+1);
            permute(left,per+c,n,ans);
        }
    }
}