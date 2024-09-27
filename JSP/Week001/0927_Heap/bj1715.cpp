#include <iostream>
#include <queue>

using namespace std; 

int main()
{
    priority_queue<int, vector<int>, greater<int>> pq;

    int n; 
    int answer = 0;

    cin >> n; 

    while(n--)
    {
        int input; 

        cin >> input; 

        pq.push(input);
    }

    int temp = 0;

    while(pq.size() > 1)
    {
        temp = pq.top();
        pq.pop();
        temp += pq.top();
        pq.pop();
        pq.push(temp);

        answer += temp; 
    }

    cout << answer; 

    return 0;
}