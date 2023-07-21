//{ Driver Code Starts
import java.io.*; 
import java.util.*; 
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException  
    {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//testcases
		int t = Integer.parseInt(br.readLine().trim());
		
		while(t-- > 0)
		{
		    String inputLine[] = br.readLine().trim().split(" ");
		    //size of array
		    int n = Integer.parseInt(inputLine[0]);
		    int start[] = new int[n];
		    int end[] = new int[n];
		    
		    //adding elements to arrays start and end
		    inputLine = br.readLine().trim().split(" ");
		    for(int i = 0; i < n; i++)
		     start[i] = Integer.parseInt(inputLine[i]);
		    
		    inputLine = br.readLine().trim().split(" ");
		    for(int i= 0; i < n; i++)
		      end[i] = Integer.parseInt(inputLine[i]);
		    
		    //function call
		    System.out.println(new Solution().activitySelection(start, end, n));
		}
    }
}


// } Driver Code Ends


class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
       ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
       
       for(int i=0;i<n;i++)
       {
           ArrayList<Integer> l = new ArrayList<Integer>();
           l.add(start[i]);
           l.add(end[i]);
           al.add(l);
       }
       
       al.sort(Comparator.comparingInt(a->a.get(1)));
       
       int ans=1;
       int sta=al.get(0).get(0);
       int en=al.get(0).get(1);
       for(int i=1;i<n;i++)
       {
           if(al.get(i).get(0)<=en)
           {
               continue;
           }
           else
           {
               ans++;
               sta=al.get(i).get(0);
               en=al.get(i).get(1);           
               
           }
       }
       
       return ans;
    }
}