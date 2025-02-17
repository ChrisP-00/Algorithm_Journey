#include <iostream>
#include <unordered_map>
#include <vector> 
#include <algorithm>

#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);

using namespace std; 

int main()
{
    fast;

    int n, m;
    cin >> n >> m;

    unordered_map<string, pair<int, string>> wordMap;

    while(n--)
    {
        string input; 
        cin >> input; 

        if(input.length() >= m)
        {
            if(wordMap.find(input) != wordMap.end())
            {
                wordMap[input].first++;
            }
            else
            {
                wordMap[input] = make_pair(1, input);
            }
        }
    }
    
    vector<pair<int, string>> answer;

    for(auto& pair : wordMap)
    {
        answer.push_back(pair.second);
    }

    sort(answer.begin(), answer.end(),
    [](const pair<int, string>& a, const pair<int, string>& b) {
        if(a.first != b.first) return a.first > b.first;
        if(a.second.length() != b.second.length()) return a.second.length() > b.second.length();
        return a.second < b.second;
    });

    for(auto value : answer)
    {
        cout << value.second << '\n';
    }

    return 0;
}