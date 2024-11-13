#include<iostream> 
#include<vector> 

using namespace std; 

vector<pair<int,int>> dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

void dfs(int y, int x, int height, vector<vector<bool>>& isVisited, vector<vector<int>>& town)
{
    isVisited[y][x] = true;

    for(int idx = 0; idx < 4; ++idx)
    {
        int ny = y + dir[idx].first;
        int nx = x + dir[idx].second;

        if(ny >= 0 && ny < town.size() && nx >= 0 && nx < town.size() && !isVisited[ny][nx])
        {   
            if(town[ny][nx] > height)
            {
                dfs(ny, nx, height, isVisited, town);
            }
        }
    }
}

int main()
{
    int n;
    cin >> n;

    vector<vector<int>> town (n, vector<int>(n, 0));
    int maxH = 0;

    for(int y = 0; y < n; ++y)
    {
        for(int x = 0; x < n; ++x)
        {
            cin >> town[y][x];
            maxH = max(maxH, town[y][x]);
        }
    }

    int ans = 0;

    vector<vector<bool>> isVisited;
    for(int h = 0; h < maxH; ++h)
    {
        isVisited.assign(n, vector<bool>(n, false));
        int safeAreaCount = 0;

        for(int y = 0; y < n; ++y)
        {
            for(int x = 0; x < n; ++x)
            {
                if(!isVisited[y][x] && town[y][x] > h)
                {
                    dfs(y, x, h, isVisited, town);
                    safeAreaCount++;
                }
            }
        }
        ans = max(ans, safeAreaCount);
    }

    cout << ans;

    return 0;
}