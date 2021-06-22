
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function template for C++

class Solution{
public:
    string shortenString(string s){
        /* for each element curr, keep scanning forward until you find one
        that is not the same as curr. keep a count of the number of dups.
        Stop scanning when you encounter a non-dup.
        if count > 1, do not add curr to answer.
        otherwise, add.
        step forward by count elements.
        */
        if (s.size() == 0){
            return "";
        }
        if (s.size() == 1){
            return s;
        }
        int n = s.size();
        int itr = 0, count = 1;
        char curr = s[itr];
        string ans = "";
        while (itr < n){
            curr = s[itr];
            count = 1;
            while (++itr < n && s[itr] == curr){
                count++;
            }
            if (count == 1){
                ans.push_back(curr);
            }
        }
        return ans;
    }
    string remove(string first) {
        string compare = first;
        string shortened = shortenString(compare);
        while (shortened.size() != compare.size()){
            compare = shortened;
            shortened = shortenString(compare);
        }
        return shortened;
    }
};

// { Driver Code Starts.

int main() {
    int t;
    string tc;
    getline(cin, tc);
    t = stoi(tc);
    while (t--) {
        string s;
        getline(cin, s);
        Solution ob;
        cout << ob.remove(s) << "\n";
    }
    return 0;
}  // } Driver Code Ends
