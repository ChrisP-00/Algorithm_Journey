#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>

using namespace std; 

int n, k;
vector<string> nums;
vector<bool> isVisited;
unordered_set<string> numCards;

void findCard(string cur, int depth)
{
    if(depth == k)
    {
        numCards.insert(cur);
        return;
    }
    
    for(int idx = 0; idx < n; ++idx)
    {
        if(!isVisited[idx])
        {
            isVisited[idx] = true;
            findCard(cur + nums[idx], depth + 1);
            isVisited[idx] = false;
        }
    }
}

int main()
{
    cin >> n >> k;
    
    nums.resize(n);
    isVisited.resize(n, false);
    
    for(int idx = 0; idx < n; ++idx)
    {
        cin >> nums[idx];
    }
    
    for(int idx = 0; idx < n; ++idx)
    {
        findCard("", 0);
    }
        
    cout << numCards.size();
    
    return 0;
}