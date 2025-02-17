#include <iostream>
#include <string>

using namespace std;

int main() {
    string s;
    cin >> s;

    int q = 0, u = 0, a = 0, c = 0, k = 0, duckCount = 0;
    for(char character : s)
    {
        switch(character)
        {
            case 'q' : q++; break;
            case 'u' : u++; break;
            case 'a' : a++; break;
            case 'c' : c++; break;
            case 'k' : k++; 
                if(duckCount < q - k)
                {
                    duckCount = q - k;
                }
                break;
            default : 
                cout << "-1";
                return 0;
        }

        if(u > q || a > u || c > a || k > c) 
        {
            cout << "-1";
            return 0;
        }
    }
    
    cout << ((q == u && u == a && a == c && c == k) ? duckCount + 1 : -1);

    return 0;
}
