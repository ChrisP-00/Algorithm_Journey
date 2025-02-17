#include<iostream>
#include<vector>
#include<cmath> 
#include<limits.h>

using namespace std; 

bool hasBrokenNumber(int num, vector<bool>& numbers)
{
    if(num == 0)
    {
        return numbers[0];
    }

    while(num)
    {
        if(numbers[num % 10]) 
        {
            return true; 
        }

        num /= 10;
    }

    return false;
}

int main()
{
    vector<bool> numbers(10, false);

    int n, broken;

    cin >> n >> broken; 

    while(broken--)
    {
        int b;
        cin >> b;
        numbers[b] = true;
    }

    int ans = abs(n - 100);

    for(int i = 0; i <= 1000000; ++i)
    {
        if(hasBrokenNumber(i, numbers))
        {
            continue;
        }
    
        ans = min(ans, abs(n - i) + (int)to_string(i).length());
    }

    cout << ans;

    return 0;
}