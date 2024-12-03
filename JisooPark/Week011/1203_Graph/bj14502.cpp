#include <iostream> 
#include <vector> 
#include <queue>

#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)

using namespace std; 

vector<pair<int, int> > dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

vector<vector<int> > map;
vector<pair<int, int> > virus;
vector<pair<int, int> > emptySpace;

int n , m;

int countSafeArea(vector<vector<int> >& tempMap)
{
    queue<pair<int,int> > q;

    for(pair<int,int> v : virus)
    {
        q.push(v);
    }

    vector<vector<bool> > isVisited (n, vector<bool>(m, false));
    while(!q.empty())
    {
        pair<int, int> pos = q.front();
        q.pop();

        isVisited[pos.first][pos.second] = true;

        for(int idx = 0; idx < 4; ++idx)
        {
            int ny = pos.first + dir[idx].first;
            int nx = pos.second + dir[idx].second;

            if(ny < 0 || ny >= n || nx < 0 || nx >= m)
            {
                continue; 
            }

            if(isVisited[ny][nx] || tempMap[ny][nx] != 0)
            {
                continue;
            }

            isVisited[ny][nx] = true;
            tempMap[ny][nx] = 2; 

            q.push({ny, nx});
        }
    }

    int count = 0;

    for(int iy = 0; iy < n; ++iy)
    {
        for(int ix = 0; ix < m; ++ix)
        {
            if(tempMap[iy][ix] == 0)
            {
                count++;
            }
        }
    }

    return count; 
}

int main()
{
    fast;

    cin >> n >> m;

    map.resize(n, vector<int>(m, 0));

    for(int y = 0; y < n; ++y)
    {
        for(int x = 0; x < m; ++x)
        {
            cin >> map[y][x];
            
            if(map[y][x] == 2)
            {
                virus.push_back({y, x});
            }
            else if(map[y][x] == 0)
            {
                emptySpace.push_back({y, x});
            }
        }
    }

    int answer = 0;
    int c = emptySpace.size();

    for(int i = 0; i < c; ++i)
    {
        for(int j = i + 1; j < emptySpace.size(); ++j)
        {
            for(int k = j + 1; k < emptySpace.size(); ++k)
            {
                auto [x1, y1] = emptySpace[i];
                auto [x2, y2] = emptySpace[j];
                auto [x3, y3] = emptySpace[k];

                map[x1][y1] = 1;
                map[x2][y2] = 1;
                map[x3][y3] = 1;

                vector<vector<int> > tempMap = map;

                // 안전 영역 세기
                answer = max(answer, countSafeArea(tempMap));

                map[x1][y1] = 0;
                map[x2][y2] = 0;
                map[x3][y3] = 0;
             }
        }
    }

    cout << answer;

    return 0;
}