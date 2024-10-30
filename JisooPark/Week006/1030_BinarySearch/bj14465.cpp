#include <iostream>
#include <vector> 

using namespace std; 

int main()
{
    int n, k, b;
    cin >> n >> k >> b;

    vector<int> trafficLights (n + 1, 0);

    for(int idx = 1; idx <= b; ++idx)
    {
        int broken;
        cin >> broken; 
        trafficLights[broken] = 1;
    }

    int minFix = 0;
    for(int idx = 1; idx <= k; ++idx)
    {
        if(trafficLights[idx] == 1)
        {
            minFix++;
        }
    }

    int count = minFix; 
    for(int idx = k + 1; idx <= n; ++idx)
    {
        if(trafficLights[idx] == 1)
        {
            count++;      
        }

        if(trafficLights[idx - k] == 1)
        {
            count--;
        }

        minFix = min(minFix, count);
    }

    cout << minFix;

    return 0;
}