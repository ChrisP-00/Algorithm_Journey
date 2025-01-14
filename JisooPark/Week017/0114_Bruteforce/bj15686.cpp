#include <iostream>
#include <vector> 
#include <climits>
#include <algorithm>

using namespace std;


vector<pair<int, int> > chickens;
vector<pair<int, int> > houses;

int houseToChicken(const vector<int>& chicken)
{
    int totalDistance = 0;
    
    for(pair<int, int> pos : houses)
    {
        int minDis = INT_MAX;
        
        for(int idx : chicken)
        {
            int dist = abs(pos.first - chickens[idx].first) + abs(pos.second - chickens[idx].second);
            
            minDis = min(minDis, dist);
        }   
        totalDistance += minDis;
    }
    return totalDistance;
}


int main()
{
    int n, m;
    cin >> n >> m;
    
    for(int iy = 0; iy < n; ++iy)
    {
        for(int ix = 0; ix < n; ++ix)
        {
            int type;
            cin >> type;
            
            if(type == 1)
            {
                houses.push_back(make_pair(iy, ix));
            }
            else if(type == 2)
            {
                chickens.push_back(make_pair(iy, ix));
            }
        }
    }
    
    int chickenCount = chickens.size();
    int minDistance = INT_MAX;
    vector<int> stores;
    
    vector<bool> comb(chickenCount, false);
    fill(comb.begin(), comb.begin() + m, true);
    do
    {
        stores.clear();
        
        for(int i = 0; i < chickenCount; ++i)
        {
            if(comb[i])
            {
                stores.push_back(i);
            }
        }

        int distanceToChicken = houseToChicken(stores);
        minDistance = min(minDistance, distanceToChicken);
    } while(prev_permutation(comb.begin(), comb.end()));
    
    cout << minDistance;
    
    return 0;
}