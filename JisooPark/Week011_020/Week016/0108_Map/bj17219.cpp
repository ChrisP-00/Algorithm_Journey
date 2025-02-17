#include <iostream>
#include <unordered_map>
#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)

using namespace std; 

int main()
{
    fast; 
    
    int ws, pw;
    cin >> ws >> pw; 
    
    unordered_map<string, string> passwords;
    string temp1, temp2;
    for(int idx = 0; idx < ws; ++idx)
    {
        cin >> temp1 >> temp2;
        passwords[temp1] = temp2;
    }
    
    for(int idx = 0; idx < pw; ++idx)
    {
        cin >> temp1; 
        cout << passwords[temp1] << '\n';
    }
        
    return 0;
}
