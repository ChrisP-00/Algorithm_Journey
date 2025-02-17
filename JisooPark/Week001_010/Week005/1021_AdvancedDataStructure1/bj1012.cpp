#include <iostream> 
#include <vector>
#include <queue>
#define fastcpp cin.tie(0), cout.tie(0), ios::sync_with_stdio(false)

using namespace std;

vector<vector<int>> map;
vector<vector<bool>> isVisited;
vector<pair<int, int>> dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
int x = 0, y = 0, b = 0; 

bool checkWorm(int yPos, int xPos)
{
    if(isVisited[yPos][xPos] || map[yPos][xPos] == 0)
    {
        return false;
    }

    queue<pair<int, int>> q; 
    q.push({yPos, xPos});
    isVisited[yPos][xPos] = true; 

    while(!q.empty())
    {
        pair<int,int> pos = q.front();
        q.pop();

        for(int i = 0; i < 4; ++i)
        {
            int ny = pos.first + dir[i].first; 
            int nx = pos.second + dir[i].second; 

            if(ny < 0 || ny >= y || nx < 0 || nx >= x)
            {
                continue; 
            }

            if(!isVisited[ny][nx] && map[ny][nx] == 1)
            {
                q.push({ny, nx});
                isVisited[ny][nx] = true;
            }
        }
    }

    return true;
}

int Search(int y, int x)
{
    int countWorm = 0;

    for(int iy = 0; iy < y; ++iy)
    {
        for(int ix = 0; ix < x; ++ix)
        {
           if(map[iy][ix] == 1 && !isVisited[iy][ix])
           {
                if(checkWorm(iy, ix))
                {
                    countWorm++;
                }
           }
        }
    }

    return countWorm;
}

int main()
{
    fastcpp;

    int t; 
    cin >> t; 

    for(int tc = 0; tc < t; ++tc)
    {
        cin >> x >> y >> b;

        map.assign(y, vector<int>(x, 0));
        isVisited.assign(y, vector<bool>(x, false));

        for(int bPos = 0; bPos < b; ++bPos)
        {
            int bx, by;
            cin >> bx >> by; 
            
            map[by][bx] = 1;
        }

        int ans = Search(y, x);

        cout << ans << '\n'; 
    }

    return 0;
}
