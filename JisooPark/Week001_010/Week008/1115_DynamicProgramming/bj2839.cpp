#include <iostream>
#include <climits>

using namespace std;

int main()
{
    int sugar, x; 
    cin >> sugar; 

    x = 0; 
    int minCount = INT_MAX; 

    while(sugar >= 5 * x)
    {
        int count = x; 
        int remaining = sugar - 5 * x;
        
        x++;

        if(remaining % 3 == 0)
        {
            count += remaining / 3;
        }
        else
        {
           continue;
        }

        minCount = min(minCount, count);
    }

    if(minCount == INT_MAX)
    {
        minCount = -1;
    }

    cout << minCount;

    return 0;
}