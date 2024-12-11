#include <iostream>

#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)
using namespace std; 

int main()
{
    fast; 
    int work[100001];
    
    int n, m;
    cin >> n >> m;

    long long maxValue = 0;
    long long sum = 0;
    for(int idx = 0; idx < n; ++idx)
    {
        cin >> work[idx];
        sum += work[idx];

        if(idx >= m - 1)
        {
            maxValue = max(maxValue, sum);
            sum -= work[idx - m + 1];
        }
    }

    cout << maxValue;

    return 0;
}