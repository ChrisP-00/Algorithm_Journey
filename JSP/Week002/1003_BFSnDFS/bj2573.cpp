#include <iostream>
#include <vector> 
#include <queue>

using namespace std; 

vector<pair<int, int>> dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
queue<pair<int, int>> visit;

vector<vector<int>> map;
vector<vector<bool>> isVisited;

int x, y; 


void isIsland(int iY, int iX)
{
    isVisited[iY][iX] = true;

    for(int i = 0; i < 4; ++i)
    {
        int posY = iY + dir[i].first;
        int posX = iX + dir[i].second;

        // 유효한 좌표인지 확인하고, 방문하지 않은 빙산 부분이 있으면 탐색
        if (posY >= 0 && posY < y && posX >= 0 && posX < x && !isVisited[posY][posX] && map[posY][posX] > 0) 
        {
            isIsland(posY, posX);
        }
    }
}


void meltIce()
{
    vector<vector<int>> newMap = map; 
    int size = visit.size();

    for(int i = 0; i < size; ++i)
    {
        pair<int, int> cur = visit.front();

        int island = map[cur.first][cur.second];
        int countWater = 0;

        for(int idx = 0; idx < 4; ++idx)
        {
            int ty = cur.first + dir[idx].first; 
            int tx = cur.second + dir[idx].second; 

            if(ty < 0 || ty >= y || tx < 0 || tx >= x)
            {
                continue;
            }

            if(map[ty][tx] == 0)
            {
                countWater++;
            }
        }

        island -= countWater;

        if(island > 0)
        {
            newMap[cur.first][cur.second] = island; 
            visit.push(cur);
        }
        else
        {
            newMap[cur.first][cur.second] = 0;
        }
    }

    map = newMap;
}


int CountIsland()
{
    isVisited.assign(y, vector<bool>(x, false));
    int count = 0;

    for(int iy = 0; iy < y; ++iy)
    {
        for(int ix = 0; ix < x; ++ix)
        {
            if(map[iy][ix] > 0 && !isVisited[iy][ix])
            {
                isIsland(iy, ix);
                count ++;
            }
        }
    }
    
    return count;
}

int main()
{
    cin >> y >> x; 

    map.assign(y, vector<int>(x, 0));
    isVisited.assign(y, vector<bool>(x, false));

    for(int iy = 0; iy < y; ++iy)
    {
        for(int ix = 0; ix < x; ++ix)
        {
            int n;
            cin >> n; 

            map[iy][ix] = n;

            if(map[iy][ix] != 0)
            {
                visit.push(make_pair(iy, ix));
            }
        }
    }
    
    int year = 0;

    while(!visit.empty())
    {
        int islandCount = CountIsland();

        if(islandCount >= 2)
        {
            cout << year; 
            break;
        }

        else if(islandCount == 0)
        {
            cout << islandCount; 
            break;
        }

        meltIce();
        year++;

        cout << year << '\n';
    }

    return 0;
}