#include <iostream> 

#define fastCPP ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);

using namespace std; 

int main()
{
    fastCPP;

    int n, m, k; 

    cin >> n >> m >> k;

    int answer = 0;

    for(int iy = 0; iy < n; ++iy)
    {
        int window = 0;

        string input;
        cin >> input; 

        for(int ix = 0; ix < m; ++ix)
        {
            if(input[ix] != '0')
            {
                window = 0;
                continue; 
            }

            window++; 

            if(window >= k)
            {
                answer++;
            }
        }
    }

    cout << answer;    

    return 0;
}