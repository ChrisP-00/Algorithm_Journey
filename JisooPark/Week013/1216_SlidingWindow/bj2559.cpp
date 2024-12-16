#include <iostream> 

#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)

using namespace std;

int main()
{
    fast;

    int n, k;
    cin >> n >> k;
    
    int temp [n];
    
    int maxTemp = -50000000;
    int sum = 0;
    for(int idx = 0; idx < n; ++idx)
    {
        cin >> temp[idx]; 
        
        sum += temp[idx]; 
        
        if(idx >= k - 1)
        {
            maxTemp = max(sum, maxTemp);
            sum -= temp[idx - k + 1];
        }
    }
    
    cout << maxTemp;
    
    return 0;
}