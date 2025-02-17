#include <iostream> 
#include <vector> 

using namespace std; 

int main()
{
    int k, n;
    cin >> k >> n;

    vector<int> cables;
    for(int idx = 0; idx < k; ++idx)
    {
        int c;
        cin >> c;
        cables.push_back(c);
    }

    long long low = 1;
    long long high = *max_element(cables.begin(), cables.end());

    while(low <= high)
    {
        long long mid = low + (high - low) / 2;

        long long count = 0;
        for(int c : cables)
        {
            count += c / mid;
        }

        if(count >= n)
        {
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }

    cout << high;

    return 0;
}