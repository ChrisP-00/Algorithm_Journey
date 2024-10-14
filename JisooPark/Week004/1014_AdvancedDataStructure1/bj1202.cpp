#include <iostream> 
#include <vector> 
#include <queue> 
#include <algorithm>

using namespace std; 

int main()
{
    int n, k; 
    cin >> n >> k;

    vector<pair<int, int>> gems(n);
    vector<int> bags(k); 
 
    for(int idx = 0; idx < n; ++idx)
    {  
        // 무게, 가치
        cin >> gems[idx].first >> gems[idx].second;
    }

    for(int idx = 0; idx < k; ++idx)
    {
        cin >> bags[idx];
    }

    // 오름 차순 정렬, 가벼운거 먼저
    sort(gems.begin(), gems.end());

    // 오름 차순 정렬, 작은 용량 먼저
    sort(bags.begin(), bags.end());

    long long ans = 0;
    int gemIdx = 0;

    priority_queue<int, vector<int>> pq;
    
    for(int idx = 0; idx < k; ++idx)
    {
        // n개 만큼 확인, 현재 가방에 넣을 수 있는 보석을 담음
        while(gemIdx < n && gems[gemIdx].first <= bags[idx])            
        {
            pq.push(gems[gemIdx].second);
            ++gemIdx;
        }

        // 현재 가장 가치있는 것만 챙김
        if(!pq.empty())
        {
            ans += pq.top();
            pq.pop();
        }
    }

    cout << ans;

    return 0;
}