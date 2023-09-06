//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

int convertFive(int n);

// Driver program to test above function
int main() {
    int T;
    cin >> T;
    while (T--) {
        int n;
        cin >> n;
        cout << convertFive(n) << endl;
    }
}
// } Driver Code Ends


/*you are required to complete this method*/
int convertFive(int n) {
    
    int res=0;
    while(n!=0)
    {
        int last=n%10;
        if(last==0)
        {
            last=5;
        }
        
        res=last+res*10;
        n=n/10;
    }
    
   int res2=0;
   while(res!=0)
   {
       res2=res2*10+res%10;
       res=res/10;
   }
   
   return res2;
}