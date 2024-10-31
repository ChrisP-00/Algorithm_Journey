#include <iostream> 
#include <vector>
#include <algorithm>

using namespace std;

int isContain(vector<int>& cards, int num)
{
    int left = 0;
    int right = cards.size() - 1;
    int mid = 0;

    while(left <= right)
    {
        mid = (left + right) / 2;
    
        if(num < cards[mid])
        {
            right = mid - 1; 
        }

        else if(num > cards[mid])
        {
            left = mid + 1; 
        }

        else
        {
            return 1; 
        }
    }

    return 0;
}


int main()
{
    int n;
    cin >> n;

    vector<int> cards (n,0);
    for(int idx = 0; idx < n; ++idx)
    {
        cin >> cards[idx];
    }

    sort(cards.begin(), cards.end());

    int m;
    cin >> m;
    
    vector<int> nums (m,0);
    for(int idx = 0; idx < m; ++idx)
    {
        cin >> nums[idx];
    }

    for(int num : nums)
    {
        cout << isContain(cards, num) << ' ';
    }

    return 0;
}