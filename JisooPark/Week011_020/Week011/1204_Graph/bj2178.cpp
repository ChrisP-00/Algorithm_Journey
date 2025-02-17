#include <iostream> 
#include <vector> 
#include <string>
#include <queue>

using namespace std; 

vector<pair<int,int> > dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

int bfs(int n, int m, vector<vector<int>>& map)
{
    queue<vector<int> > q; 
    q.push({0, 0, 1});
    map[0][0] = 0;

    int depth = 0;

    while(!q.empty())
    {
        int y = q.front()[0];
        int x = q.front()[1];
        depth = q.front()[2];
        q.pop();

        if(y == n - 1 && x == m - 1)
        {
            return depth;
        }

        for(int idx = 0; idx < 4; ++idx)
        {
            int ny = y + dir[idx].first;
            int nx = x + dir[idx].second;

            if(ny < 0 || ny >= n || nx < 0 || nx >= m)
            {
                continue;
            }

            if(map[ny][nx] == 1)
            {
                q.push({ny, nx, depth + 1});
                map[ny][nx] = 0;
            }
        }
    }

    return depth;
}   


int main()
{
    int n, m;
    cin >> n >> m;

    vector<vector<int> > map (n, vector<int>(m, 0));

    for(int iy = 0; iy < n; ++iy)
    {
        string input; 
        cin >> input; 

        for(int ix = 0; ix < m; ++ix)
        {
            map[iy][ix] = input[ix] - '0';
        }
    }

    cout << bfs(n, m, map);

    return 0;
}