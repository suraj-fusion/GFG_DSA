//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        int ans[]=new int[2];
        Comparator<Job> comp = new Comparator<Job>()
        {
            public int compare(Job j1,Job j2)
            {
                if(j1.profit<j2.profit)
                {
                    return 1;
                }
                else if(j1.profit>j2.profit)
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }
        };
        
        Arrays.sort(arr,comp);
        int maxdeadline=-1;
        for(int i=0;i<n;i++)
        {
            if(arr[i].deadline>maxdeadline)
            {
                maxdeadline=arr[i].deadline;
            }
        }
        
        int jobsche[]=new int [maxdeadline];
    
        
        for(int i=0;i<n;i++)
        {
            int dead=arr[i].deadline-1;
            while(dead>=0)
            {
                if(jobsche[dead]==0)
                {
                    jobsche[dead]=arr[i].profit;
                    break;
                }
                else
                {
                    dead--;
                }
                
            }
            
            
        }
        
        int maxprofit=0;
        int maxjobs=0;
        for(int i=0;i<jobsche.length;i++)
        {
            if(jobsche[i]!=0)
           {
               maxprofit+=jobsche[i];
               maxjobs++;
           }
        }
        
        ans[0]=maxjobs;
        ans[1]=maxprofit;
        return ans;
        
        
        
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/