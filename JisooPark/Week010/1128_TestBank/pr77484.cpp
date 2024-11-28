#include <string>
#include <vector>
#include <map>

using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> answer;
    
    map<int, int> nums; 
    for(int n : win_nums)
    {
        nums[n] = 0;
    }
    
    int zeroCount = 0;
    
    for(int n : lottos)
    {
        if(n == 0)
        {
            zeroCount++;
            continue;
        }
        
        if(nums.find(n) != nums.end())
        {
            nums[n]++;
        }
    }
    
    int winCount = 0;
    for(auto n : nums)
    {
        winCount += n.second;       
    }

    answer.push_back(min(6 - (winCount + zeroCount) + 1, 6));
    answer.push_back(min(6 - winCount + 1, 6));
    
    return answer;
}