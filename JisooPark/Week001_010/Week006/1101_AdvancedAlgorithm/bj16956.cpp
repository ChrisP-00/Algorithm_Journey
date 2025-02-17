#include <iostream> 
#include <vector> 

using namespace std; 

vector<pair<int,int>> dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};

bool IsNearWolf(int y, int x,  vector<vector<char>>& farm)
{
    for(int idx = 0; idx < 4; ++idx)
    {
        int ny = dir[idx].first + y;
        int nx = dir[idx].second + x;

        if(ny < 0 || ny >= farm.size() || nx < 0 || nx >= farm[0].size())
        {
            continue;
        }

        if(farm[ny][nx] == 'W')
        {
            return true; 
        }
    }
    return false;
}

int main()
{
    int r, c;
    cin >> r >> c;

    vector<vector<char>> farm (r, vector<char> (c, 0)); 

    bool isWolf = false;
    bool isFailed = false;

    for(int y = 0; y < r; ++y)
    {
        for(int x = 0; x < c; ++x)
        {
            cin >> farm[y][x]; 

            if(farm[y][x] == '.')
            {
                farm[y][x] = 'D';
            }
        }
    }

    for(int y = 0; y < r; ++y)
    {
        for(int x = 0; x < c; ++x)
        {
            if(farm[y][x] == 'S' && IsNearWolf(y, x, farm))
            {
                cout << '0';
                return 0;
            }
        }
    }

    cout << "1\n";

    for(int y = 0; y < r; ++y)
    {
        for(int x = 0; x < c; ++x)
        {
            cout << farm[y][x];
        }

        cout << '\n';
    }

    return 0;
}