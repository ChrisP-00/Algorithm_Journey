#include <iostream> 
#include <queue> 

using namespace std; 

int main()
{
    ios::sync_with_stdio(false), cin.tie(NULL);
    
    queue<int> myQ;
    int n; 
    cin >> n;
    
    for(int i = 1; i <= n; ++i)
    {
        myQ.push(i);
    }
    
    while(!myQ.empty())
    {
        cout << myQ.front() << ' ';
        myQ.pop();
        myQ.push(myQ.front());
        myQ.pop();
    }
    
    return 0;
}