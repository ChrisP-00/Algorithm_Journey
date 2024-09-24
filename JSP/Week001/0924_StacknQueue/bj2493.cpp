#include <iostream> 
#include <stack>
#include <vector> 

using namespace std; 

int main()
{
    int n; 

    cin >> n; 

    vector<int> tops (n + 1, 0);

    for(int i = 1; i <= n; ++i)
    {
        cin >> tops[i];
    }

    
    // pair<int, int> 스택을 사용한 코드 
    stack <pair<int, int>> myStack; 
    for(int i = 1; i <= n; ++i)
    {
        while(!myStack.empty() && myStack.top().second < tops[i])
        {
            myStack.pop();
        }

        if(myStack.empty())
        {
            cout << 0 << ' ';
        }
        else
        {
            cout << myStack.top().first << ' ';
        }

        myStack.push(make_pair(i, tops[i]));
    }
    

    // int 스택을 사용한 코드
    // stack <int> myStack; 
    // for(int i = 1; i <= n; ++i)
    // {
    //     while(!myStack.empty() && tops[myStack.top()] < tops[i])
    //     {
    //         myStack.pop();
    //     }
    //     if(!myStack.empty())
    //     {
    //         cout << myStack.top() << ' ';
    //     }
    //     else
    //     {
    //         cout << 0 << ' ';
    //     }

    //     myStack.push(i);
    // }

    return 0;
}