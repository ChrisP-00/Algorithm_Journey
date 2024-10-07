#include <iostream>
#include <vector> 
#include <queue>
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
    vector<int> weight;

    while(m--)
    {
        int a = 0, b = 0, c = 0; 
        cin >> a >> b >> c;

        map[a].push_back(make_pair(b, c));
        map[b].push_back(make_pair(a, c));

        weight.push_back(c);
    }

    int start, end, answer = 0;
    cin >> start >> end;

    // 2 3 2 -> 1 5 10 
    sort(weight.begin(), weight.end());

    int leftIdx = 0;
    int rightIdx = weight.size() - 1;     

    while(leftIdx <= rightIdx)
    {
        int midIdx = (leftIdx + rightIdx) / 2;
        int midWeight = weight[midIdx];

        vector<bool> isVisited(n + 1, false);

        if(canMove(start, end, midWeight, map, isVisited))
        {
            answer = weight[midIdx];
            leftIdx = midIdx + 1; 
        }
        else
        {
            rightIdx = midIdx - 1;
        }
    }

    cout << answer;

    return 0;
}