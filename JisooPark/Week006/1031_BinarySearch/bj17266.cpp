#include <iostream>
#include <algorithm> 
#include <vector> 

using namespace std; 

bool isCover(vector<int> street, int length, int height)
{
    int lastCovered = 0;

    for(int l : street)
    {
        if(l - height > lastCovered)
        {
            return false;
        }
        
        lastCovered = l + height;

        if(l + height >= length)
        {
            return true;
        }
    }

    return false;
}

int main()
{
    int n, m;
    cin >> n >> m;

    vector<int> street;
    for(int idx = 0; idx < m; ++idx)
    {
        int l;
        cin >> l;
        street.push_back(l);
    }

    int left = 0; 
    int right = n - 1;
    int mid;

    while(left <= right)
    {
        mid = (left + right) / 2;

        if(isCover(street, n, mid))
        {
            right = mid - 1;
        }
        else
        {
            left = mid + 1;
        }
    }

    cout << left;

    return 0;
}