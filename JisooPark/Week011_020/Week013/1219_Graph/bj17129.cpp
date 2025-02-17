#include <iostream> 
#include <vector> 
#include <queue>

#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)

using namespace std;

int n, m;
char map [3001][3001];
bool isVisited [3001][3001];
int dir [4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0 , 1}};

int bfs(int y, int x)
{
    int count = 1; 
    queue<pair<int, int>> q; 
  
    q.push({y,x});
    isVisited[y][x] = true;

    bool isMoved = false;
    while(!q.empty())
    {        
        int qCount = q.size();

        for(int i = 0; i < qCount; ++i)
        {
            int cy = q.front().first;
            int cx = q.front().second;
            q.pop();

            for(int idx = 0; idx < 4; ++idx)
            {
                int ny = cy + dir[idx][0];
                int nx = cx + dir[idx][1];
                
                if(ny < 0 || ny >= n || nx < 0 || nx >= m || isVisited[ny][nx] || map[ny][nx] == '1')
                {
                    continue; 
                }

                if(map[ny][nx] != '0')
                {
                    return count;
                }

                q.push({ny, nx});
                isVisited[ny][nx] = true;
            }
        }
        count++;
    }
    return 0;
}

int main()
{
    fast;

    cin >> n >> m;
    
    pair<int, int> start;

    for(int iy = 0; iy < n; ++iy)
    {
        string s;
        cin >> s;

        for(int ix = 0; ix < m; ++ix)
        {
            map[iy][ix] = s[ix];

            if(map[iy][ix] == '2')
            {
                start = {iy, ix};
            }
        }
    }

    int answer = bfs(start.first, start.second);
    
    if(answer == 0)
    {
        cout << "NIE";
    }
    else
    {
        cout << "TAK\n" << answer;
    }

    return 0;
}