#include <iostream> 
#include <vector> 
#include <queue>

#define fastcpp cin.tie(0), cout.tie(0), ios::sync_with_stdio(false)

using namespace std; 

int checkComs(vector<vector<int>>& networks, int size)
{
    vector<bool> isVisited(size + 1, false);
    isVisited[1] = true;

    queue<int> q; 
    q.push(1);

    int count = 0;

    while(!q.empty())
    {
        int cur = q.front();
        q.pop();

        for(int idx = 0; idx < networks[cur].size(); ++idx)
        {
            int virusCom = networks[cur][idx];

            if(!isVisited[virusCom])
            {
                q.push(virusCom);
                isVisited[virusCom] = true;
                count++;
            }
        }
    }
    return count;
}

int main()
{
    fastcpp;

    int totalComs, virusComs; 
    cin >> totalComs >> virusComs;

    vector<vector<int>> networks(totalComs + 1, vector<int>());

    while(virusComs--)
    {
        int c1, c2; 
        cin >> c1 >> c2; 

        networks[c1].push_back(c2);
        networks[c2].push_back(c1);
    }

    cout << checkComs(networks, totalComs);

    return 0;
}