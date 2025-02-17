#include <iostream>

#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)

using namespace std; 

int dirY[8] = {-1, 1, 0, 0, -1, -1, 1, 1};
int dirX[8]  = {0, 0, -1, 1, -1, 1, -1, 1};
bool map[51][51];
int w, h;

void dfs(int y, int x)
{
    map[y][x] = 0;

    for(int idx = 0; idx < 8; ++idx)
    {
        int ny = y + dirY[idx];
        int nx = x + dirX[idx];

        if(ny < 0 || ny >= h || nx < 0 || nx >= w || !map[ny][nx])
        {
            continue; 
        }

        map[ny][nx] = 0;
        dfs(ny, nx);
    }
}

int countIsland()
{
    int count = 0;

    for(int iy = 0; iy < h; ++iy)
    {
        for(int ix = 0; ix < w; ++ix)
        {
            if(map[iy][ix])
            {
                dfs(iy, ix);
                count++;
            }
        }
    }
    return count;
}

int main()
{
    while(true)
    {
        cin >> w >> h;
        
        if(w == 0 && h == 0)
        {
            break;
        }

        for(int iy = 0; iy < h; ++iy)
        {
            for(int ix = 0; ix < w; ++ix)
            {
                cin >> map[iy][ix];
            }
        }

        cout << countIsland() << '\n';
    }

    return 0;
}