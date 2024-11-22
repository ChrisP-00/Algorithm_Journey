#include <iostream>
#include <vector> 
#include <string> 
#include <algorithm>

using namespace std; 

bool hasNumber(const vector<string>& numbers)
{
    vector<string> sortedNumbers = numbers; 
    sort(sortedNumbers.begin(), sortedNumbers.end());

    for(int idx = 0; idx < sortedNumbers.size() - 1; ++idx)
    {
        if(sortedNumbers[idx + 1].find(sortedNumbers[idx]) == 0)
        {
            return false;
        }
    }
    return true;
}

int main()
{
    int t, n;
    cin >> t;

    while(t--)
    {
        cin >> n;

        vector<string> numbers(n);
        for(int idx = 0; idx < n; ++idx)
        {
            cin >> numbers[idx];
        }
        
        if(hasNumber(numbers))
        {
            cout << "YES" << '\n';
        }
        else
        {
            cout << "NO" << '\n';
        }
    }

    return 0;
}