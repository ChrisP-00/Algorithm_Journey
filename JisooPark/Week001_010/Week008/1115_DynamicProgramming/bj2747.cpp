#include <iostream>
#include <vector>

using namespace std; 

vector<int> dp;

int fibo(int n)
{
    if(n == 0)
    {
        return 0;
    }

    if(n == 1)
    {
        return 1;
    }

    if(dp[n] != -1)
    {
        return dp[n];
    }

    dp[n] = fibo(n-1) + fibo(n-2);

    return dp[n];
}

int main()
{
    int n; 
    cin >> n;

    dp.assign(n + 1, -1);

    cout << fibo(n);

    return 0;
}