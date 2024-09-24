#include <iostream> 
#include <queue> 
#include <vector> 

using namespace std;

int main()
{
    int n, w, l, totalWeight = 0, time = 0; 
    
    cin >> n >> w >> l; 

    vector<int> trucks (n, 0);
    queue<int> q; 


    for(int i = 0; i < n; ++i)
    {
        cin >> trucks[i];
    }

    for(int i = 0; i < n; ++i)
    {
        while(true)
        {
            // 다리위에 있는 트럭의 개수 
            if(q.size() == w)
            {
                totalWeight -= q.front();
                q.pop();
            }

            if(trucks[i] + totalWeight <= l)
            {
                break;
            }

            // 트럭 사이에 공간 추가 <- 트럭이 다리를 이동
            q.push(0);
            time++;
        }

        q.push(trucks[i]);
        totalWeight += trucks[i];
        time++;
    }

    cout << time + w;

    return 0; 
}