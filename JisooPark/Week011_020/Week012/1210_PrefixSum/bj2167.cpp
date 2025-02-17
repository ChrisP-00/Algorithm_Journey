#include <iostream> 
#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)

using namespace std; 

int prefix [302][302];

int main()
{
    fast; 
    
    int n, m;
    cin >> n >> m;
     
    for(int iy = 1; iy <= n; ++iy)
    {
        for(int ix = 1; ix <= m; ++ix)
        {
            int input; 
            cin >> input; 
 
            prefix[iy][ix] = prefix[iy - 1][ix] + prefix[iy][ix - 1] - prefix[iy - 1][ix - 1] + input;
        }
    }
    
    int t; 
    cin >> t; 
    
    while(t--)
    {
        int by, bx, ey, ex; 
        cin >> by >> bx >> ey >> ex; 
        
        cout << prefix[ey][ex] - prefix[by - 1][ex] - prefix[ey][bx - 1] + prefix[by - 1][bx - 1] << '\n';
    }
    
    return 0;
}