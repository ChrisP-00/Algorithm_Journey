#include <iostream> 
#include <vector> 
#include <queue> 

using namespace std; 

vector<pair<int,int>> dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
vector<vector<bool>> isVisited;
vector<vector<char>> map;
int n;


int bfs(int y, int x, char color)
{
    if(isVisited[y][x])
    {
        return 0;
    }

    queue<pair<int, int>> q; 
    q.push({y, x});
    isVisited[y][x] = true;

    while(!q.empty())
    {
        pair<int, int> pos = q.front();
        q.pop();

        for(int idx = 0; idx < 4; ++idx)
        {
            int ny = pos.first + dir[idx].first;
            int nx = pos.second + dir[idx].second;

            if(ny < 0 || ny >= n || nx < 0 || nx >= n || isVisited[ny][nx])
            {
                continue;
            }

            if(map[ny][nx] == color)
            {
                q.push({ny, nx});
                isVisited[ny][nx] = true;
            }
        }
    }
    return 1;
}

int main()
{
    cin >> n;

    map.assign(n, vector<char>(n, ' '));
    isVisited.assign(n, vector<bool>(n, false));

    for(int iy = 0; iy < n; iy++)
    {
        for(int ix = 0; ix < n; ++ix)
        {
            cin >> map[iy][ix];
        }
    }

    int normal = 0, abnormal = 0;

    for(int iy = 0; iy < n; ++iy)
    {
        for(int ix = 0; ix < n; ++ix)
        {
            normal += bfs(iy, ix, map[iy][ix]);

            if(map[iy][ix] == 'G')
            {
                map[iy][ix] = 'R';
            }
        }
    }

    isVisited.assign(n, vector<bool>(n, false));
    for(int iy = 0; iy < n; ++iy)
    {
        for(int ix = 0; ix < n; ++ix)
        {
            abnormal += bfs(iy, ix, map[iy][ix]);
        }
    }

    cout << normal << ' ' << abnormal;

    return 0;
}