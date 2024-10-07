#include <iostream>
#include <vector> 
#include <queue>
#include <climits>
#include <algorithm>
#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);

using namespace std; 

bool canMove(int start, int target, int weight, vector<vector<pair<int,int>>>& map, vector<bool>& isVisited)
{
    queue<int> q; 
    q.push(start);
    isVisited[start] = true;

    while(!q.empty())
    {
        int cur = q.front();
        q.pop();

        if(cur == target)
        {
            return true;
        }

        for(auto& next : map[cur])
        {
            int nextNode = next.first;
            int bridgeWeight = next.second;

            if(!isVisited[nextNode] && bridgeWeight >= weight)
            {
                isVisited[nextNode] = true;
                q.push(nextNode);
            }
        }
    }

    return false;
}

int main()
{
    fast;
    int n, m;
    cin >> n >> m;

    vector<vector<pair<int,int>>> map (n + 1, vector<pair<int,int>>()); 
    int minWeight = INT_MAX;
    int maxWeight = 0;

    while(m--)
    {
        int a = 0, b = 0, c = 0; 
        cin >> a >> b >> c;

        map[a].push_back(make_pair(b, c));
        map[b].push_back(make_pair(a, c));

        minWeight = min(minWeight, c);
        maxWeight = max(maxWeight, c);
    }

    int start, end, answer = 0;
    cin >> start >> end;

    int left = 0;
    int right = maxWeight;

    while(left <= right)
    {
        int mid = (left + right) / 2;

        vector<bool> isVisited(n + 1, false);

        if(canMove(start, end, mid, map, isVisited))
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