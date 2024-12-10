#include <iostream> 

#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)

using namespace std; 

int main ()
{
    fast;

    int people [250001];
    
    int n, x;
    cin >> n >> x; 
    
    int sum = 0;
    int maxValue = 0;
    int count = 1;

    for(int idx = 0; idx < n; ++idx)
    {
        cin >> people[idx];

        sum += people[idx];
   
        if(idx >= x - 1)
        {
            if(sum > maxValue)
            {
                maxValue = sum;
                count = 1;
            }
            else if(maxValue == sum)
            {
                count++;
            }

            sum -= people[idx - x + 1];
        }       
    }
    
    if(maxValue == 0)
    {
        cout << "SAD";
    }
    else
    {
        cout << maxValue << '\n' << count;
    }
    
    return 0;
}