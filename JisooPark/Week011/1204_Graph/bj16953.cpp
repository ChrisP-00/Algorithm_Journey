#include <iostream>
#include <queue> 

using namespace std; 

long long bfs(long long a, long long b)
{
    queue<pair<long long, long long> > q; 
    q.push({a, 1});

    while(!q.empty())
    {
        long long a = q.front().first;
        long long depth = q.front().second;
        q.pop();

        if(a == b)
        {
            return depth; 
        }

        if(a > b)
        {
            continue;
        }

        q.push({a * 2, depth + 1});
        q.push({a * 10 + 1, depth + 1});        
    }

    return -1;
}

int main()
{
    long long a, b;
    cin >> a >> b;

    cout << bfs(a, b);

    return 0;
}