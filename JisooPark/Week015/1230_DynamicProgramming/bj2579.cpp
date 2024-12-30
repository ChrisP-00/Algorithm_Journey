#include <iostream> 
#include <vector> 

using namespace std;

int main()
{
    int n;
    cin >> n;
    
    vector<int> stair (n + 1, 0);
    vector<int> dp (n + 1, 0);
    
    for(int idx = 1; idx <= n; ++idx)
    {
        cin >> stair[idx];
    }
    
    dp[1] = stair[1];
    dp[2] = stair[1] + stair[2];
    dp[3] = max(stair[1], stair[2]) + stair[3];
      
    for(int idx = 4; idx <= n; ++idx)
    {
        dp[idx] = max(dp[idx - 2], dp[idx - 3] + stair[idx - 1]) + stair[idx];
    } 
    
    cout << dp[n];
    
    return 0;
}