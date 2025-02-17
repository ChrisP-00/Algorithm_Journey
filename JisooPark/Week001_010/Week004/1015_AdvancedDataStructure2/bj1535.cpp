#include <iostream> 
#include <vector> 

using namespace std; 

int main()
{
    int n; 
    cin >> n;

    vector<int> dp (101, 0); 
    vector<pair<int, int>> value(n, pair<int, int>({0,0}));

    for(int i = 0; i < n; ++i)
    {
        // first - life, second - happy
        cin >> value[i].first;
    }

    for(int i = 0; i < n; ++i)
    {
        cin >> value[i].second;
    }

    
    for(int idx = 0; idx < n; ++idx)
    {
        // first = 소모 체력, second = 행벅
        for(int l = 100; l >= value[idx].first; --l)
        {
            // l의 체력에서 얻을 수 있는 최대 행복
            dp[l] = max(dp[l], dp[l - value[idx].first] + value[idx].second);
            cout << "dp[" << l << "] = " << dp[l] << endl;
        }
        cout << '\n';
    }

    cout << dp[99];

    return 0;
}