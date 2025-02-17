#include <iostream> 
#include <stack>
#include <vector>

using namespace std;

int main()
{
    ios::sync_with_stdio(false), cin.tie(NULL);
    int n, p;
    cin >> n >> p;

    vector<stack<int>> music(7); 

    int ans = 0;
    while(n--)
    {
        int string, fret; 
        cin >> string >> fret;

        if(music[string].empty())
        {
            music[string].push(fret);
            ans++;
        }
        else
        {
            while(!music[string].empty() && music[string].top() > fret)
            {
                music[string].pop();
                ans++;
            }

            if(!music[string].empty() && music[string].top() == fret)
            {
                continue;
            }

            music[string].push(fret);
            ans++;
        }
    }

    cout << ans;

    return 0;
}