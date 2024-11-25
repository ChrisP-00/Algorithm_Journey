#include <iostream> 

using namespace std; 

int main()
{
    int n, m;
    cin >> n >> m;

    int line = n - m;

    for(int i = 0; i < line ; ++i)
    {
        cout << i << ' ' << i + 1 << '\n';
    }

    for(int i = line + 1; i < n; ++i)
    {
        cout << line << " " << i << '\n'; 
    }

    return 0;
}