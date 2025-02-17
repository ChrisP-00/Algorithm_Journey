#include <iostream> 

using namespace std; 

int main()
{
    int sum = 0;
    int maxNum = 0;
    
    for(int idx = 0; idx < 10; ++idx)
    {
        int n;
        cin >> n;
        
        sum += n;
  
        if(abs(100 - sum) <= abs(100 - maxNum))
        {
            maxNum = sum;
        }
    }
    
    cout << maxNum;
    
    return 0;
}