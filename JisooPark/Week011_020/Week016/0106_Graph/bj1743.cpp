#include <iostream>
#include <queue>

using namespace std;

int dirY[4] = {-1, 1, 0, 0};
int dirX[4] = {0, 0, -1, 1};
bool map[102][102];

int n, m, k;

int max(int a, int b)
{
    return (a > b ? a : b);
}

int bfs(int y, int x)
{
    queue<pair<int, int> > q;
    q.push({y, x});
    
    int count = 0;
    
    while(!q.empty())
    {
        auto[cy, cx] = q.front();
        q.pop();
        
        for(int idx = 0; idx < 4; ++idx)
        {
            int ny = cy + dirY[idx];
            int nx = cx + dirX[idx];
            
            if(ny < 0 || ny > n || nx < 0 || nx > m || !map[ny][nx])
            {
                continue;
            }
            
            q.push({ny, nx});
            map[ny][nx] = 0;
            count++;
        }
    }
    
    return count;
}

int dfs(int y, int x)
{
    int count = 1;

    map[y][x] = 0;

    for(int idx = 0; idx < 4; ++idx)
    {
        int ny = y + dirY[idx];
        int nx = x + dirX[idx];
        
        if(ny < 0 || ny > n || nx < 0 || nx > m || !map[ny][nx])
        {
            continue;
        }
        
        map[ny][nx] = 0;
        count += dfs(ny, nx);
    }

    return count;
}

int countFood()
{
    int count = 0;
    
    for(int iy = 1; iy <= n; ++iy)
    {
        for(int ix = 1; ix <= m; ++ix)
        {
            if(map[iy][ix])
            {
                count = max(count, dfs(iy, ix));
            }
        }
    }
    return count;
}

int main()
{
    cin >> n >> m >> k;
    
    for(int iy = 0; iy < n; ++iy)
    {
        for(int ix = 0; ix < m; ++ix)
        {
            int y, x;
            cin >> y >> x;
            map[y][x] = 1;
        }
    }
    
    cout << countFood();
    
    return 0;
}