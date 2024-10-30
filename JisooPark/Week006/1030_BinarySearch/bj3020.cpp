#include <iostream> 
#include <vector> 

using namespace std;

int main()
{
    int n, h; 
    cin >> n >> h;

    vector<int> soon (h + 1, 0);
    vector<int> suck (h + 1, 0);

    for(int idx = 0; idx < n; ++idx)
    {
        int object; 
        cin >> object;
        // even -> soon 
        if(idx % 2 == 0)
        {
            soon[object]++;
        }
        // odd -> suck
        else
        {
            suck[object]++;
        }
    }

    for(int idx = h - 1; idx > 0; --idx)
    {
        soon[idx] += soon[idx + 1];
        suck[idx] += suck[idx + 1];
    }

    int minCollision = 500001;
    int pathCount = 0;

    for(int idx = 1; idx <= h; ++idx)
    {
        int collision = soon[idx] + suck[h - idx + 1];
        if(minCollision > collision)
        {
            minCollision = collision;
            pathCount = 1;
        }
        
        else if(minCollision == collision)
        {
            pathCount++;
        }
    }

    cout << minCollision << ' ' << pathCount;

    return 0;
}