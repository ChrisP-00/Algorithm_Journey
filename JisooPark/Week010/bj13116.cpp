#include <iostream> 

#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)

using namespace std; 

int main()
{
    fast;
    
    int t; 
    cin >> t; 

    while(t--)
    {
        int a, b;
        cin >> a >> b;

        while(a != b)
        {
            if(a > b)
            {
                a /= 2;
            }
            else
            {
                b /= 2;
            }
        }

        cout << a * 10 << '\n';
    }

    return 0;
}