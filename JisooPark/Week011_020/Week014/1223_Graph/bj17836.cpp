#include <iostream> 
#include <queue>
#include <array>

#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)

using namespace std; 
using pos = array<int, 3>;

int n, m, t;
int dir[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
int map [101][101];
bool isVisited [101][101];

int bfs()
{
    queue<pos> q; 
    q.push({0, 0, 0});
    isVisited[0][0] = true;

    int sword = 0;

    while(!q.empty())
    {
        auto [y, x, d] = q.front();
        q.pop();

        for(auto& [dy, dx] : dir)
        {
            int ny = y + dy;
            int nx = x + dx;

            if(ny < 0 || ny >= n || nx < 0 || nx >= m 
            || map[ny][nx] == 1 || isVisited[ny][nx])
            {
                continue;
            }
            
            if(ny == n - 1 && nx == m - 1)
            {
                return sword ? min(d + 1, sword) : d + 1;
            }

            if(map[ny][nx] == 2)
            {
                sword = d + 1 + (n - ny - 1) + (m - nx - 1);
            }

            q.push({ny, nx, d + 1});
            isVisited[ny][nx] = true;
        }
    }

    return (sword != 0 ? sword : 0);
}

int main()
{
    fast;

    cin >> n >> m >> t;

    for(int iy = 0; iy < n; ++iy)
    {
        for(int ix = 0; ix < m; ++ix)
        {
            cin >> map[iy][ix];
        }
    }

    int answer = bfs();
    cout << ((answer == 0 || answer > t) ? "Fail" : to_string(answer));

    return 0;
}