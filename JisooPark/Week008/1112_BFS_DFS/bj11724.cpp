#include<iostream>
#include<vector>

#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);

using namespace std; 

vector<bool> isVisited;
vector<vector<int>> graph;

void dfs(int node)
{
    if(isVisited[node])
    {
        return; 
    }

    isVisited[node] = true; 

    for(int idx = 0; idx < graph[node].size(); ++idx)
    {
        dfs(graph[node][idx]);
    }
}

int main()
{
    fast;

    int n, m;
    cin >> n >> m;

    graph.assign(n + 1, vector<int>());

    for(int i = 0; i < m; ++i)
    {
        int a, b;
        cin >> a >> b;

        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    isVisited.assign(n + 1, false);

    int count = 0;
    for(int idx = 1; idx <= n; ++idx)
    {
        if(isVisited[idx])
        {
            continue; 
        }

        dfs(idx);
        count++;
    }

    cout << count;

    return 0;
}