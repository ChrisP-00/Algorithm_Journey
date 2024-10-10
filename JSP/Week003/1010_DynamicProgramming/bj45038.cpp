#include <iostream> 

using namespace std; 

int main()
{
    int n = 0;
    cin >> n;

    int* wines = new int[n + 1]{};
    int* dp = new int[n + 1]{};


    for(int i = 1; i < n + 1; ++i)
    {
        int w; 
        cin >> w; 

        wines[i] = w; 
    }

    dp[1] = wines[1];   
 
    if(n == 1)
    {
        cout << dp[n];
        return 0;
    }

    dp[2] += dp[1] + wines[2];

    if(n == 2)
    {
        cout << dp[n];
        return 0;
    }

    for(int i = 3; i < n + 1; ++i)
    {
        dp[i] = dp[i-3] + wines[i-1] + wines[i];
        dp[i] = max(dp[i], dp[i-2] + wines[i]);
        dp[i] = max(dp[i], dp[i-1]);
    }
  
    cout << dp[n];
    
    delete[] dp;
    delete[] wines;

    return 0;
}