#include <iostream> 

#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)

using namespace std; 

int ice [1000001]; 

int main()
{
    fast; 
    
    int n, k;
    cin >> n >> k;
    
    for(int idx = 0; idx < n; ++idx)
    {
        int pos, value; 
        cin >> value >> pos; 
        
        ice[pos] = value;
    }

    int maxValue = 0;
    int sum = 0;
    k = 2 * k + 1;

    for (int i = 0; i < 1000001; i++)
    {
        sum += ice[i];
        maxValue = max(sum, maxValue);

        if(i >= k)
        {
            sum -= ice[i - k];
        }
    }
    
    cout << maxValue;
    
    return 0;
}