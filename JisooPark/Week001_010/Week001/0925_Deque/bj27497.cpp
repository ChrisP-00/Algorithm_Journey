#include <iostream> 
#include <deque>
#include <stack>
#include <vector>

using namespace std;

int main() 
{    
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    deque<char> myDeque;
    stack<char> myStack;

    int n; 
    
    cin >> n; 

    vector<pair<int, char>> commands(n, {0, ' '});

    for(int i = 0; i < n; ++i)
    {
        int command;
        char word; 

        cin >> command;

        if(command != 3)
        {
            cin >> word;
            commands[i]= {command, word};
        }
        else
        {
            commands[i]= {command, ' '};
        }
    }

    for(int i = 0; i < n; ++i)
    {
        if(commands[i].first == 1)
        {
            myDeque.push_back(commands[i].second);
            myStack.push(commands[i].first);
        }
        else if(commands[i].first == 2)
        {
            myDeque.push_front(commands[i].second);
            myStack.push(commands[i].first);   
        }
        else if(commands[i].first == 3)
        {
            if(!myStack.empty())
            {
                if(myStack.top() == 1)
                {
                    myDeque.pop_back();    
                    myStack.pop();
                }
                else        
                {
                    myDeque.pop_front();
                    myStack.pop();
                }
            }
        }
    }    

    if(myDeque.empty())
    {
        cout << "0";
    }
    else
    {
        for(char c : myDeque)
        {
            cout << c;
        }
    }

    return 0; 
}