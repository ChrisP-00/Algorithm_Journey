#include <iostream> 
#include <queue>
#include <vector>

using namespace std; 

vector<vector<char>> map;
vector<vector<bool>> isVisited;
vector<pair<int, int>> dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
int n, m;
int sheep = 0, wolf = 0;

pair<int, int> whoSurvive(int y, int x)
{
    int s = 0, w = 0;
    queue<pair<int, int>> q; 
    q.push({y, x});
    isVisited[y][x]  = true;

    if(map[y][x] == 'v')
    {
        w++;
    }
    else if(map[y][x] == 'k')
    {
        s++;
    }

    while(!q.empty())
    {
        auto[cy, cx] = q.front();
        q.pop();
        
        for(const auto& [dy, dx] : dir)
        {
            int ny = cy + dy;
            int nx = cx + dx;
            if(ny < 0 || ny >= n || nx < 0 || nx >= m 
               || map[ny][nx] == '#' || isVisited[ny][nx])
            {
                continue; 
            }
            
            isVisited[ny][nx] = true;
            q.push({ny, nx});            
            if(map[ny][nx] == 'v')
            {
                w++;
            }
            else if(map[ny][nx] == 'k')
            {
                s++;
            }
        }    
    }
    return {s, w};
}

int main()
{
    ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
    
    cin >> n >> m;
    map.resize(n, vector<char>(m));
    isVisited.resize(n, vector<bool>(m, false));
    
    for(int iy = 0; iy < n; iy++)
    {
        for(int ix = 0; ix < m; ++ix)
        {
            cin >> map[iy][ix];
        }
    }
    
    for(int iy = 0; iy < n; ++iy)
    {
        for(int ix = 0; ix < m; ++ix)
        {
            if(!isVisited[iy][ix] && map[iy][ix] != '#')
            {
                auto[s, w] = whoSurvive(iy, ix);
                
                if(s > w)
                {
                    sheep += s;
                }
                else
                {
                    wolf += w;
                }
            }
        }
    }
    
    cout << sheep << ' ' << wolf;
    
    return 0;
}