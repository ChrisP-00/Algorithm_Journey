#include <iostream> 

using namespace std; 

int main()
{
    int testCase;
    cin >> testCase;

    while(testCase--)
    {
        int country, flight;
        cin >> country >> flight; 

        while(flight--)
        {
            int a, b; 
            cin >> a >> b;
        }

        cout << country - 1 << '\n';
    }

    return 0;
}