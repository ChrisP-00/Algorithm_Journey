#include <iostream> 
#include <vector> 
#include <algorithm> 

using namespace std; 

int main()
{
    int n, c; 
    cin >> n >> c;

    vector<int> houses;

    for(int idx = 0; idx < n; ++idx)
    {
        int h; 
        cin >> h;
        houses.push_back(h);
    }


    sort(houses.begin(), houses.end());

    int left = 1;
    int right = houses[n - 1] - houses[0];
    int answer = 0;

    while(left <= right)
    {
        int mid = left + (right - left) / 2;
        int count = 1;
        int lastHouse = houses[0];

        for(int i = 1; i < n; ++i)
        {
            if(houses[i] >= lastHouse + mid)
            {
                count += 1;
                lastHouse = houses[i];
            }
        }

        if(count >= c)
        {
            answer = mid;
            left = mid + 1;
        }
        else
        {
            right = mid - 1;
        }
    }

    cout << answer;

    return 0;
}