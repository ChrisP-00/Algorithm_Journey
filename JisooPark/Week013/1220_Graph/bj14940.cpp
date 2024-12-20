#include <iostream> 
#include <queue>
#include <vector>
#include <tuple>

#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)

using namespace std;
using tripleInt = tuple<int, int, int>;

int n, m;

int dirY[4] = {-1, 1, 0, 0};
int dirX[4] = {0, 0, -1, 1};

vector<vector<bool> > isVisited;
vector<vector<int> > map;
vector<vector<int> > dist;

void bfs(int y, int x)
{
    queue<tripleInt> q;

    q.push({0, y, x});

    isVisited[y][x] = true;
    dist[y][x] = 0;

    while(!q.empty())
    {
        tripleInt cur = q.front();
        q.pop();
        
        for(int idx = 0; idx < 4; ++idx)
        {
            int ny = get<1>(cur) + dirY[idx];
            int nx = get<2>(cur) + dirX[idx];
            
            if(ny < 0 || ny >= n || nx < 0 || nx >= m 
            || isVisited[ny][nx] || map[ny][nx] == 0)
            {
                continue;
            }

            dist[ny][nx] = get<0>(cur) + 1;
            isVisited[ny][nx] = true;
            q.push({dist[ny][nx], ny, nx});
        }
    }
}


int main()
{
    fast;
    cin >> n >> m;

    map.resize(n, vector<int>(m));
    dist.resize(n, vector<int>(m));
    isVisited.resize(n, vector<bool>(m));

    int by, bx;

    for(int iy = 0; iy < n; ++iy)
    {
        for(int ix = 0; ix < m; ++ix)
        {
            cin >> map[iy][ix];

            if(map[iy][ix] == 2)
            {
                by = iy;
                bx = ix;
            }
        }
    }
    
    bfs(by, bx);
    
    for(int iy = 0; iy < n; ++iy)
    {
        for(int ix = 0; ix < m; ++ix)
        {

            if(isVisited[iy][ix])
            {
               cout << dist[iy][ix] << ' ';
            }
            else
            {
                if(map[iy][ix] == 0)
                {
                    cout << "0 ";
                }
                else
                {
                    cout << "-1 ";
                }
            }
        }

        cout << '\n';
    }
    
    return 0;
}