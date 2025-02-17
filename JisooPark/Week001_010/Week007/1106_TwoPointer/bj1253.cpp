#include <iostream> 
#include <vector>
#include <algorithm>

using namespace std; 

int main()
{
    int n;
    cin >> n;

    vector<int> numbers (n, 0);

    for(int idx = 0; idx < n; ++idx)
    {
        cin >> numbers[idx];
    }

    sort(numbers.begin(), numbers.end());

    int count = 0;

    for(int idx = 0; idx < n; ++idx)
    {
        int left = 0; 
        int right = n - 1;
        int target = numbers[idx];

        while(left < right)
        {
            if(left == idx)
            {
                left++;
                continue;
            }
            if(right == idx)
            {
                right--;
                continue;
            }

            int sum = numbers[left] + numbers[right];
            if(sum == target)
            {
                count++;
                break;
            }
            else if(sum < target)
            {
                left++;
            }
            else
            {
                right--;
            }
        }
    }

    cout << count;

    return 0;
}