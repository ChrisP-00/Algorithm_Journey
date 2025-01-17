#include <iostream> 
#include <vector> 
#include <climits>

using namespace std;

int n;
vector<int> nums;
vector<int> operators(4);
vector<bool> isVisited; 

long long minNum = LLONG_MAX;
long long maxNum = LLONG_MIN;

// + - * /
void backtrack(int idx, long long curValue)
{
    if(idx == n)
    {
        minNum = min(minNum, curValue);
        maxNum = max(maxNum, curValue);
        return;
    }
    
    for(int i = 0; i < 4; ++i)
    {
        if(operators[i] > 0)
        {
            operators[i]--;
            long long next = curValue;
            
            if(i == 0)
            {
                next += nums[idx];
            }
            else if(i == 1)
            {
                next -= nums[idx];
            }
            else if(i == 2)
            {
                next *= nums[idx];
            }
            else if(i == 3)
            {
                next /= nums[idx];
            }
            
            backtrack(idx + 1, next);
            
            operators[i]++;
        }
    }
}

int main()
{
    cin >> n; 
    
    nums.resize(n);
    
    for(int idx = 0; idx < n; ++idx)
    {
        cin >> nums[idx];
    }
    
    for(int idx = 0; idx < 4; ++idx)
    {
        cin >> operators[idx];
    }
    
    backtrack(1, nums[0]);
    
    cout << maxNum << '\n' << minNum;
    
    return 0;
}