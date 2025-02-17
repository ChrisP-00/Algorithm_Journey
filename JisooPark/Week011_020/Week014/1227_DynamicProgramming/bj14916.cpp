#include <iostream>
#include <vector>
#include <algorithm>

using namespace std; 

const int maxValue = 1e9;

int main()
{
    int n; 
    cin >> n;

    vector<int> dp(n + 1, maxValue);
    dp[0] = 0;

    for(int idx = 1; idx <= n; ++idx)
    {
        if(idx >= 2)
        {
            dp[idx] = min(dp[idx], dp[idx - 2] + 1);
        }

        if(idx >= 5)
        {
            dp[idx] = min(dp[idx], dp[idx - 5] + 1);
        }
    }

    cout << (dp[n] == maxValue ? -1 : dp[n]);

    return 0;
}