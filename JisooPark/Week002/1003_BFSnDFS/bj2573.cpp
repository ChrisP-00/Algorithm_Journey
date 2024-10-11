#include <iostream>
#include <vector> 

using namespace std; 

vector<pair<int, int>> dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
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
        if (posY >= 0 && posY < y && posX >= 0 && posX < x) 
        {
            if(!isVisited[posY][posX] && map[posY][posX] > 0)
            {
                isIsland(posY, posX);
            }
        }
    }
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

void meltIce()
{
    vector<vector<int>> newMap = map; 

    for(int iy = 0; iy < y; ++iy)
    {
        for(int ix = 0; ix < x; ++ix)
        {
            if(newMap[iy][ix] == 0)
            {
                continue;
            }

            int countWater = 0;

            for(int idx = 0; idx < 4; ++idx)
            {
                int ty = iy + dir[idx].first; 
                int tx = ix + dir[idx].second; 

                if(ty < 0 || ty >= y || tx < 0 || tx >= x)
                {
                    continue;
                }
            
                if(map[ty][tx] == 0)
                {
                    countWater++;
                }
            }

            newMap[iy][ix] = max(map[iy][ix] - countWater, 0);
        }
    }

    map = newMap;
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
        }
    }
    
    int year = 0;
    int islandCount = 0;
     
    do
    {
        islandCount = CountIsland();

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

    }while(islandCount != 0);

    return 0;
}