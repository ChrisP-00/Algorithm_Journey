#include <iostream> 
#include <vector> 

using namespace std;

vector<vector<int>> friends;
vector<int> isVisited; 

bool dfs(int idx, int depth)
{
    if(depth >= 5)
    {
        return true;
    }

    isVisited[idx] = true; 

    for(int i = 0; i < friends[idx].size(); ++i)
    {
        int nextFriend = friends[idx][i];

        if(!isVisited[nextFriend])
        {
            if(dfs(nextFriend, depth + 1))
            {
                return true;
            }
        }
    }

    isVisited[idx] = false;

    return false;
}


int main()
{
    int n, m; 
    cin >> n >> m;

    friends.assign(n, vector<int>());

    while(m--)
    {
        int a, b;
        cin >> a >> b; 

        friends[a].push_back(b);
        friends[b].push_back(a);
    }

    for(int i = 0; i < n; ++i)
    {
        isVisited.assign(n, false);

        if(dfs(i, 1))
        {
            cout << 1;
            return 0;
        }
    }

    cout << 0;

    return 0;
}