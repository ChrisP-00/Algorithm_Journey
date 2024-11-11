#include <iostream>
#include <vector>

using namespace std; 

vector<pair<int, int>> dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
vector<vector<int>> cheeseMap; 
int n, m;

void outside(int y, int x, vector<vector<int>>& map)
{
    map[y][x] = -1;

    for(int idx = 0; idx < 4; ++idx)
    {
        int ny = y + dir[idx].first;
        int nx = x + dir[idx].second;

        if(ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] == 0)
        {
            outside(ny, nx, map);    
        }
    }

    return;
}

bool isMelting(int y, int x)
{
    int count = 0;

    for(int idx = 0; idx < 4; ++idx)
    {
        int ny = y + dir[idx].first;
        int nx = x + dir[idx].second;
        
        if(ny >= 0 && ny < n && nx >= 0 && nx < m && cheeseMap[ny][nx] == -1)
        {
            count++;
        }
    }

    return count >= 2; 
}

void meltCheese()
{
    vector<vector<int>> temp = cheeseMap;

   for(int y = 0; y < n; ++y)
   {
        for(int x = 0; x < m; ++x)
        {
            if(cheeseMap[y][x] == 1 && isMelting(y,x))
            {
                temp[y][x] = 0;

                outside(y, x, temp);
            }
        }
   }

   cheeseMap = temp;
}


int main()
{
    cin >> n >> m;

    cheeseMap.assign(n, vector<int>(m, 0));

    for(int y = 0; y < n; ++y)
    {
        for(int x = 0; x < m; ++x)
        {
            cin >> cheeseMap[y][x];
        }
    }

    int ans = 0;

    outside(0, 0, cheeseMap);

    while(true)
    {
        bool melted = false; 

        for(int y = 0; y < n; ++y)
        {
            for(int x = 0; x < m; ++x)
            {
                if(cheeseMap[y][x] == 1 && isMelting(y, x))
                {
                    melted = true;
                }
            }
        }

        if(!melted)
        {
            break;
        }

        meltCheese();

        ans++;
    }

    cout << ans;

    return 0;
}