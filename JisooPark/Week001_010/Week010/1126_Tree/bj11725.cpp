#include <iostream> 
#include <vector> 
#include <queue>

#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)

using namespace std; 

void bfs(int node, vector<vector<int> >& tree, vector<int>& parents)
{
    vector<bool> isVisited(tree.size(), false);
    queue<int> q; 

    q.push(node);

    while(!q.empty())
    {
        int parent = q.front();
        q.pop();

        isVisited[parent] = true;

        for(int idx = 0; idx < tree[parent].size(); ++idx)
        {
            if(isVisited[tree[parent][idx]])
            {
                continue;
            }

            isVisited[tree[parent][idx]] = true;
            parents[tree[parent][idx]] = parent; 
            
            q.push(tree[parent][idx]);
        }
    }
}


int main()
{
    fast; 
    
    int n;
    cin >> n;

    vector<vector<int> > tree(n + 1, (vector<int>())); 

    for(int idx = 0; idx < n; ++idx)
    {
        int a, b; 
        cin >> a >> b;

        tree[a].push_back(b);
        tree[b].push_back(a);
    }

    vector<int> parents(n + 1, 0);

    bfs(1, tree, parents);

    for(int idx = 2; idx <= n; ++idx)
    {
        cout << parents[idx] << '\n';
    }

    return 0;
}
