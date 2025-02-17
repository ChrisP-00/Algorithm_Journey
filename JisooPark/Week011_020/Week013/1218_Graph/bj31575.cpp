#include <iostream> 
#include <vector>

#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)

using namespace std; 

int n, m;
vector<vector<int>> map;
vector<vector<int>> dp;

bool DFS(int y, int x)
{
    if(y < 0 || y >= m || x < 0 || x >= n 
    || map[y][x] == 0)
    {
        return false;
    }

    if(dp[y][x] != -1)
    {
        return dp[y][x];
    }

    if(y == m - 1 && x == n - 1)
    {
        return dp[y][x] = true;
    }

    if(DFS(y + 1, x) || DFS(y, x + 1))
    {
        return dp[y][x] = true;
    }

    return dp[y][x] = false;
}

int main()
{
    fast;

    cin >> n >> m;
    
    map.resize(m, vector<int>(n, 0));
    dp.resize(m, vector<int>(n, -1));

    for(int iy = 0; iy < m; ++iy)
    {
        for(int ix = 0; ix < n; ++ix)
        {
            cin >> map[iy][ix];
        }
    }
    
    if(DFS(0, 0))
    {
        cout << "Yes";
    }
    else
    {
        cout << "No";
    }

    return 0;
}