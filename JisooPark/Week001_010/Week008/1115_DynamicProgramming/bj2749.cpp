#include <iostream>

using namespace std; 

#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);

int const mod = 1000000;
int const pisano = 1500000;

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

    int prev2 = 0;
    int prev1 = 1;
    int cur = 0;

    for(int i = 2; i <= n; ++i)
    {
        cur = (prev1 + prev2) % mod;
        prev2 = prev1;
        prev1 = cur;
    }
    
    return cur;
}

int main()
{
    fast;
    long long n; 
    cin >> n;

    n %= pisano;

    cout << fibo(n);

    return 0;
}