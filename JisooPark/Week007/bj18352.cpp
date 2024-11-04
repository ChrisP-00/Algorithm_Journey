#include <iostream> 
#include <vector> 
#include <queue> 

using namespace std;

priority_queue<int, vector<int>, greater<int> > bfs(int node, int targetDepth, vector<vector<int> >& cities, int totalNode)
{
    priority_queue<int, vector<int>, greater<int> > targetNodes; 

    queue<pair<int, int> > q; 
    q.push(make_pair(node, 0));

    vector<int> isVisited(totalNode + 1, false);
    isVisited[node] = true;


    while(!q.empty())
    {
        pair<int,int> curNode = q.front();
        q.pop();

        if(curNode.second == targetDepth)
        {
            targetNodes.push(curNode.first);
            continue;
        }

        for(int idx = 0; idx < cities[curNode.first].size(); ++idx)
        {
            int node = cities[curNode.first][idx];

            if(isVisited[node])
            {
                continue;
            }

            isVisited[node] = true; 
            q.push(make_pair(node, curNode.second + 1));
        }
    }

    return targetNodes;
}



int main()
{
    int n, m, k, x;
    cin >> n >> m >> k >> x;

    vector<vector<int> > g (n + 1);

    for(int i  = 0; i < m; ++i)
    {
        int a, b;
        cin >> a >> b;
        g[a].push_back(b);
    }

    priority_queue<int, vector<int>, greater<int> > result = bfs(x, k, g, n);

    if(result.empty())
    {
        cout << -1;
    }
    else
    {
        while(!result.empty())
        {
            cout << result.top() << '\n';
            result.pop();
        }
    }

    return 0;
}