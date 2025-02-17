#include <iostream> 
#include <vector> 
#include <queue> 

using namespace std; 

int sizeY, sizeX; 
vector<pair<int,int>> dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

int bfs(int iy, int ix, vector<vector<char>>& map)
{
    int count = 0;

    queue<pair<int, int>> q; 
    q.push({iy, ix});

    while(!q.empty())
    {
        pair<int,int> tPos = q.front();
        q.pop();

        for(int idx = 0; idx < 4; ++idx)
        {
            int ny = tPos.first + dir[idx].first;
            int nx = tPos.second + dir[idx].second;

            if(ny < 0 || ny >= sizeY || nx < 0 || nx >= sizeX || map[ny][nx] == 'X')
            {
                continue;
            }

            if(map[ny][nx] == 'O' || map[ny][nx] == 'P')
            {
                q.push({ny, nx});

                if(map[ny][nx] == 'P')
                {
                    count++;
                }

                map[ny][nx] ='X';
            }
        }
    }

    return count;
}

int main()
{
    cin >> sizeY >> sizeX; 

    vector<vector<char>> map (sizeY, vector<char>(sizeX, 'O'));
    pair<int, int> posI;

    for(int iy = 0; iy < sizeY; ++iy)
    {
        for(int ix = 0; ix < sizeX; ++ix)
        {
           cin >> map[iy][ix];

           if(map[iy][ix] == 'I')
           {
                posI = make_pair(iy, ix);
           }
        }
    }

    int ans = bfs(posI.first, posI.second, map); 
    ans == 0 ? cout << "TT" : cout << ans;

    return 0;
}