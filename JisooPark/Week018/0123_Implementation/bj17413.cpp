#include <iostream>
#include <stack> 
#include <string> 

using namespace std; 

void printStack(stack<char>& inStack)
{
    while(!inStack.empty())
    {
        cout << inStack.top();
        inStack.pop();
    }
}


int main()
{
    string s; 
    getline(cin, s);
    

    bool isTag = false;
    stack<char> myStack;
    for(char c : s)
    {
        if(c == '<') 
        {           
            if(!myStack.empty())
            {
                printStack(myStack);
            }
            isTag = true;
            cout << '<';

            continue;
        }
        else if(c == '>')
        {
            isTag = false;
            cout << '>'; 
            continue;
        }

        if(isTag) 
        {
            cout << c;
            continue; 
        }

        if(c == ' ')
        {
            if(!myStack.empty())
            {
                printStack(myStack);
            }
            cout << ' ';
            continue;
        }

        myStack.push(c);
    }
    
    if(!myStack.empty())
    {
        printStack(myStack);
    }

    return 0;
}