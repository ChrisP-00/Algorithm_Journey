#include <iostream>
#include <queue>

#define fast   ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)
 
using namespace std; 

int main()
{
    fast;

    priority_queue<int, vector<int>, greater<int> > q; 
    
    int n;
    cin >> n;

    while(n--)
    {
        int k; 
        cin >> k;
        
        long long subSum = 0;
        while(k--)
        {
            long long j;
            cin >> j;
            subSum += j;
        }
        
        q.push(subSum);
    }
    
    long long sum = 0;
    long long ttl = 0;

    while(!q.empty())
    {
        sum = sum + q.top();
        ttl += sum;

        q.pop();
    }
    
    cout << ttl;
    
    return 0;
}