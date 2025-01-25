#include <iostream>
#include <vector>

using namespace std; 

int main()
{
    int n;
    cin >> n;

    vector<int> p (n, 0);
    vector<int> line (n, -1);


    for(int idx = 0; idx < n; ++idx)
    {
        cin >> p[idx];
    }

    for(int i = 0; i < n; ++i)
    {
        int count = p[i];

        for(int j = 0; j < n; ++j)
        {
            if(line[j] == -1)
            {
                if(count == 0)
                {
                    line[j] = i + 1;
                    break;
                }
                count--;
            }
        }
    }

    for(int i : line)
    {
        cout << i << ' ';
    }

    return 0;
}