#include <iostream> 
#include <unordered_map>
#include <string>

using namespace std; 

int max(const int &a, const int &b)
{
    return (a > b) ? a : b;
}

int main()
{
    int n; 
    cin >> n;
    
    unordered_map<string, int> in;
    for(int idx = 0; idx < n; ++idx)
    {
        string input; 
        cin >> input;
        in[input] = idx;
    }
    
    string out[1001];
    for(int idx = 0; idx < n; ++idx)
    {
        cin >> out[idx];
    }

    int count = 0;
    for(int i = 0; i < n; ++i)
    {
        for(int j = i + 1; j < n; ++j)
        {
            if(in[out[i]] > in[out[j]])
            {
                count++;
                break;
            }
        }
    }
    
    cout << count;
    
    return 0;
}