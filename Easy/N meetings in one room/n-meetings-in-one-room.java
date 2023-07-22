//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<ArrayList<Integer>> meet=new ArrayList<ArrayList<Integer>>();
        
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> l = new ArrayList<Integer>();
            l.add(start[i]);
            l.add(end[i]);
            meet.add(l);
        }
        Comparator<ArrayList<Integer>> comp = new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> l1,ArrayList<Integer> l2)
            {
                if(l1.get(1)>l2.get(1))
                {
                    return 1;
                }
                else if(l1.get(1)<l2.get(1))
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }
            
        };
        Collections.sort(meet,comp);
       
        
        int sta=meet.get(0).get(0);
        int en=meet.get(0).get(1);
        int res=1;
        for(int i=1;i<n;i++)
        {
            if(meet.get(i).get(0)>en)
            {
                res++;
                sta=meet.get(i).get(0);
                en=meet.get(i).get(1);
            }
        }
        
        return res;
        
        
    }
}
