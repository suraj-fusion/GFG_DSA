//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
       double ans=0;
       Arrays.sort(arr, (item1, item2) -> {
       double valpweight1 = (double) item1.value / item1.weight;
       double valpweight2 = (double) item2.value / item2.weight;
       return Double.compare(valpweight2, valpweight1);
        });
        
        for(int i=0;i<n && W!=0;i++)
        {
            if(W>=arr[i].weight)
            {
                ans=ans+arr[i].value;
                W=W-arr[i].weight;
            }
            else
            {
                ans=ans+W*(double)arr[i].value/(double)arr[i].weight;
                W=0;
            }
        }
        return ans;

       
    }
}