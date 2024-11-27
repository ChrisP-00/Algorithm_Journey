#include <iostream> 
#include <vector> 

#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)

using namespace std; 

struct Node
{
    char type; 
    long long aniCount; 
    vector<int> children; 
};

vector<Node> tree;

long long dfs(int node)
{
    long long total = 0;

    for(int child : tree[node].children)
    {
        total += dfs(child);
    }

    if(tree[node].type == 'W')
    {
        return max(total - tree[node].aniCount, 0LL);
    }
    else
    {
        return total + tree[node].aniCount;
    }

    return max(total, 0LL);
}

int main()
{
    fast;

    int n;
    cin >> n;

    tree.resize(n + 1);

    for(int idx = 2; idx <= n; ++idx)
    {
        char t;
        long long a;
        int p; 

        cin >> t >> a >> p;
        
        tree[idx].type = t;
        tree[idx].aniCount = a;
        tree[p].children.push_back(idx);
    }

    cout << dfs(1) << '\n';

    return 0;
}