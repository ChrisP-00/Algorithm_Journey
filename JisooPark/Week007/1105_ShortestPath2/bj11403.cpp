#include <iostream> 
#include <vector> 

using namespace std; 

int main()
{
    int n; 
    cin >> n;

    vector<vector<int>> graph (n, vector<int>(n, 0));

    for(int i = 0; i < n; ++i)
    {
        for(int j = 0; j < n; ++j)
        {
            cin >> graph[i][j];
        }
    }

    for(int k = 0; k < n; ++k)
    {
        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                if(graph[i][k] && graph[k][j])
                {
                    graph[i][j] = 1;
                }
            }
        }
    }

    for(int i = 0; i < n; ++i)
    {
        for(int j = 0; j < n; ++j)
        {
            cout << graph[i][j] << ' ';
        }
        cout << '\n';
    }

    return 0;
}