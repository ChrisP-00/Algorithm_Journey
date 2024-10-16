#include <iostream> 
#include <vector> 

using namespace std;

vector<vector<int>> map; 
vector<vector<bool>> isVisited; 
vector<pair<int,int>> dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

// 세로 가로
int n, m; 

// 현재 좌표, 뎁스, 
void dfs(int y, int x, int depth, int value, int& maxValue)
{
    isVisited[y][x] = true;

    if(depth == 3)
    {
        maxValue = max(maxValue, value);
        isVisited[y][x] = false;
        return;
    }

    for(int idx = 0; idx < 4; ++idx)
    {
        int ny = y + dir[idx].first;
        int nx = x + dir[idx].second;

        if(ny < 0 || ny >= n || nx < 0 || nx >= m)
        {
            continue;
        }

        if(!isVisited[ny][nx])
        {
            dfs(ny, nx, depth + 1, value + map[ny][nx], maxValue);
        }
    }
    isVisited[y][x] = false;    
}

int checkT(int y, int x)
{
    int maxValue = 0;

    // 위 좌우 ㅗ
    if(y > 0 && x > 0 && x < m - 1)
    {
        maxValue = max(maxValue, map[y][x] + map[y-1][x] + map[y][x-1] + map[y][x+1]);
    }

    // 아래 좌우 ㅜ
    if(y < n - 1 &&  x > 0 && x < m - 1)
    {
        maxValue = max(maxValue, map[y][x] + map[y+1][x] + map[y][x-1] + map[y][x+1]);
    }

    // 위아래 좌 ㅓ
    if(y < n - 1 && y > 0 && x > 0)
    {
        maxValue = max(maxValue, map[y][x] + map[y-1][x] + map[y+1][x] + map[y][x-1]);
    }

    // 위아래 우 ㅏ
    if(y < n - 1 && y > 0 && x < m - 1)
    {
        maxValue = max(maxValue, map[y][x] + map[y-1][x] + map[y+1][x] + map[y][x+1]);
    }

    return maxValue;
}

int main()
{
    cin.tie(0); 
    cout.tie(0);
    ios::sync_with_stdio(false);

    // 세로 가로
    cin >> n >> m;

    map.assign(n, vector<int>(m, 0));
    isVisited.assign(n, vector<bool>(m, 0));

    for(int y = 0; y < n; ++y)
    {
        for(int x = 0; x < m; ++x)
        {
            cin >> map[y][x];
        }
    }

    int maxValue = 0;

    for(int y = 0; y < n; ++y)
    {
        for(int x = 0; x < m; ++x)
        {
            dfs(y, x, 0, map[y][x], maxValue);

            maxValue = max(maxValue, checkT(y, x));
        }
    }

    cout << maxValue;


    return 0;
}