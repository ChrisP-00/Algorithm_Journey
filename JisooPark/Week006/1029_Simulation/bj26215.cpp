#include <iostream>
#include <queue> 
#include <algorithm>

using namespace std; 


int main()
{
    int h; 
    cin >> h;

    priority_queue<int> houses;

    for(int idx = 0; idx < h; ++idx)
    {
        int n;
        cin >> n;
        houses.push(n);
    }

    int minutes = 0;

    while(!houses.empty())
    {
        int a = houses.top();
        houses.pop();
        
        if(!houses.empty()) 
        {
            int b = houses.top();
            houses.pop();
            b--;

            if(b > 0)
            {
                houses.push(b);
            }
        }

        a--;

        if(a > 0)
        {
            houses.push(a);
        }

        minutes++;

        if(minutes > 1440)
        {
            minutes = -1;
            break;
        }
    }

    cout << minutes;

    return 0;
}