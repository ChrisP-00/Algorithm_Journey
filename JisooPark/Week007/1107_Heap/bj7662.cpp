#include <iostream> 
#include <queue> 
#include <map>

using namespace std; 

int main()
{
    int t; 
    cin >> t;

    while(t--)
    {
        int commands = 0;
        cin >> commands;
        cin.ignore();

        priority_queue<int> maxQ;
        priority_queue<int, vector<int>, greater<int>>  minQ;
        map<int, int> countMap;

        while(commands--)
        {
            char command; 
            int number;

            cin >> command >> number; 

            if(command == 'I')
            {   
                maxQ.push(number);
                minQ.push(number);
                countMap[number]++;
            }   
            else if(command == 'D')
            {
                if(number == 1)
                {
                    while(!maxQ.empty() && countMap[maxQ.top()] == 0)
                    {
                        maxQ.pop();
                    }

                    if(!maxQ.empty())
                    {
                        countMap[maxQ.top()]--;
                        maxQ.pop();
                    }
                }
                else if(number == -1)
                {
                    while(!minQ.empty() && countMap[minQ.top()] == 0)
                    {
                        minQ.pop();
                    }
                    if(!minQ.empty())
                    {
                        countMap[minQ.top()]--;
                        minQ.pop();
                    }
                }
            }
        }

        while (!maxQ.empty() && countMap[maxQ.top()] == 0) 
        {
            maxQ.pop();
        }
        while (!minQ.empty() && countMap[minQ.top()] == 0) 
        {
            minQ.pop();
        }

        if (maxQ.empty() || minQ.empty()) 
        {
            cout << "EMPTY" << '\n';
        }
        else 
        {
            cout << maxQ.top() << " " << minQ.top() << '\n';
        }
    }

    return 0;        
}

