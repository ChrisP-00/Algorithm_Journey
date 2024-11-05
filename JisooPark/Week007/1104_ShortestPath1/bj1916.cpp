#include <iostream> 
#include <queue> 
#include <climits>

using namespace std; 

int main()
{
    int n, m;
    cin >> n >> m;

    vector<vector<pair<int,int> > > buses(n + 1);
    while(m--)
    {
        int a, b, c; 
        cin >> a >> b >> c;

        buses[a].push_back(make_pair(c, b));
    }

    int start, end;
    cin >> start >> end; 

    vector<int> costs (n + 1, INT_MAX);

    priority_queue<pair<int, int>, vector<pair<int, int> >, greater<> > pq; 
    pq.push({0, start});
    costs[start] = 0;

    while(!pq.empty())
    {
        int curCost = pq.top().first;
        int curNode = pq.top().second;
        pq.pop();

        if(curCost > costs[curNode])
        {
            continue;
        }

        for(const auto& next : buses[curNode])
        {
            int nextCost = next.first;
            int nextNode = next.second;

            if(costs[nextNode] > curCost + nextCost)
            {
                costs[nextNode] = curCost + nextCost;
                pq.push({costs[nextNode], nextNode});
            }
        }
    }

    cout << costs[end];

    return 0;
}