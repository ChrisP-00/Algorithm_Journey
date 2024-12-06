#include <iostream>
#include <queue>

#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)

using namespace std;

int n, m;
int dirY[4] = {-1, 1, 0, 0};
int dirX[4] = {0, 0, 1, -1};

int map[505][505];

int bfs(int y, int x)
{
    int count = 1;
    queue<pair<int, int> > q;
    q.push(make_pair(y, x));

    while(!q.empty())
    {
        int y = q.front().first;
        int x = q.front().second;
        q.pop();

        for(int idx = 0; idx < 4; ++idx)
        {
            int ny = y + dirY[idx];
            int nx = x + dirX[idx];

            if(ny >= 0 && ny < n && nx >= 0 && nx < m)
            {
                if(map[ny][nx] == 1)
                {
                    map[ny][nx] = 0;
                    q.push(make_pair(ny, nx));
                    count++;
                }
            }
        }
    }

    return count;
}

int main()
{
    fast;

    cin >> n >> m;

    for(int iy = 0; iy < n; ++iy)
    {
        for(int ix = 0; ix < m; ++ix)
        {
            cin >> map[iy][ix];
        }
    }

    int count = 0, maxNum = 0;

    for(int iy = 0; iy < n; ++iy)
    {
        for(int ix = 0; ix < m; ++ix)
        {
            if(map[iy][ix] == 1)
            {
                count++;
                map[iy][ix] = 0;
                maxNum = max(maxNum, bfs(iy, ix));
            }
        }
    }

    cout << count << '\n' << maxNum;

    return 0;
}