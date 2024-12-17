#include <iostream> 
#include <vector>

using namespace std;

int main()
{
    int n, m;
    cin >> n >> m;
    
    vector<vector<char>> room (n + 1, vector<char>(m + 1, ' '));
    
    int sum = 0;
    
    for(int iy = 1; iy <= n; ++iy)
    {
        for(int ix = 1; ix <= m; ++ix)
        {
            cin >> room[iy][ix];
            
            if(room[iy][ix] == '-' && room[iy][ix - 1] == '-' || room[iy][ix] == '|' && room[iy - 1][ix] == '|')
            {
                continue;
            }

            sum++;
        }
    }
    
    cout << sum;
    
    return 0;
}