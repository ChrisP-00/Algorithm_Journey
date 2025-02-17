#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std; 

void findString(string* ptr, int& k)
{
    pair<int, int> result = {INT_MAX, -1};

    for(char c = 'a'; c <= 'z'; ++c)
    {
        vector<int> indexList; 

        // 문자가 몇개 있는지 확인
        for(int idx = 0; idx < ptr->size(); ++idx)
        {
            if((*ptr)[idx] == c)
            {
                indexList.push_back(idx);
            }
        }

        // k개 이상만 
        if(indexList.size() < k)
        {
            continue;
        }

        for(int idx = 0; idx < indexList.size() - k + 1; ++idx)
        {
            int windowSize = indexList[idx + k - 1] - indexList[idx] + 1;
            result.first = min(result.first, windowSize);
            result.second = max(result.second, windowSize);
        }
    }

    if(result.first == INT_MAX || result.second == -1)
    {
        cout << "-1\n";
    }
    else
    {
        cout << result.first << ' ' << result.second << '\n';
    }
}

int main()
{
    string w;
    int k, t;

    cin >> t; 
    
    while(t--)
    {
        cin >> w >> k;

        findString(&w, k);
    }

    return 0;
}