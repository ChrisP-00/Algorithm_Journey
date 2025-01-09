#include <iostream> 
#include <unordered_map>
#include <queue>

#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)

using namespace std;

int main()
{
    fast;

    int qc;
    cin >> qc;
    
    unordered_map<string, priority_queue<int> > gorilla;
    int q, count;
    long long ans = 0;
    string name; 
    for(int j = 0; j < qc; ++j)
    {
        cin >> q >> name >> count;
        
        if(q == 1)
        {
            int num;
            for(int i = 0; i < count; ++i)
            {
                cin >> num;
            
                gorilla[name].push(num);
            }    
        }
        else
        {
            if(gorilla.count(name) == 0 || gorilla[name].empty())
            {
                continue;
            }
            
            for(int k = 0; k < count; ++k)
            {
                if(gorilla[name].empty())
                {
                    break;
                }

                ans += gorilla[name].top();
                gorilla[name].pop();
            }
        }
    }
    
    cout << ans;
    
    return 0;
}