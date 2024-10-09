#include <iostream> 
#include <vector>
#include <algorithm> 

using namespace std; 

int main()
{
    vector<int> cranes; 
    vector<int> boxes;
    int n, m;
    cin >> n; 

    while(n--)
    {
        int c; 
        cin >> c;
        cranes.push_back(c);
    }

    cin >> m;
    while(m--)
    {
        int b; 
        cin >> b;
        boxes.push_back(b);
    }

    sort(cranes.begin(), cranes.end(), greater<int>());
    sort(boxes.begin(), boxes.end(), greater<int>());

    if(cranes[0] < boxes[0])
    {
        cout << -1; 
        return 0;
    }

    int ans = 0;

    while(!boxes.empty())
    {
        for(int i = 0; i < cranes.size(); ++i)
        {
            for(int j = 0; j < boxes.size(); ++j)
            {
                if(cranes[i] >= boxes[j])
                {
                    boxes.erase(boxes.begin() + j);
                    break;
                }
            }
        }
        ans++;
    }

    cout << ans;

    return 0;
}