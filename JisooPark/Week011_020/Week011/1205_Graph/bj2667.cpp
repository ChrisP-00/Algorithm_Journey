#include <iostream> 
#include <string>
#include <vector> 
#include <algorithm>

using namespace std; 

vector<pair<int, int> > dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

int dfs(int y, int x, vector<vector<int> >& map)
{
    int count = 1;

    for(int idx = 0; idx < 4; ++idx)
    {
        int ny = y + dir[idx].first;
        int nx = x + dir[idx].second;

        if(ny < 0 || ny >= map.size() || nx < 0 || nx >= map.size())
        {
            continue;
        }

        if(map[ny][nx] != 0)
        {
            map[ny][nx] = 0;
            count += dfs(ny, nx, map);
        }
    }

    return count;
}


int main()
{
    int n; 
    cin >> n; 

    vector<vector<int> > map (n, vector<int>(n, 0));

    for(int iy = 0; iy < n; ++iy)
    {
        string input; 
        cin >> input;

        for(int ix = 0; ix < n; ++ix)
        {
            map[iy][ix] = input[ix] - '0';
        }
    }

    vector<int> answer;

    for(int iy = 0; iy < n; ++iy)
    {
        for(int ix = 0; ix < n; ++ix)
        {
            if(map[iy][ix] == 1)
            {
                map[iy][ix] = 0;
                answer.push_back(dfs(iy, ix, map));
            }
        }
    }

    sort(answer.begin(), answer.end());

    cout << answer.size() << '\n';

    for(int n : answer)
    {
        cout << n << '\n';
    }

    return 0;
}