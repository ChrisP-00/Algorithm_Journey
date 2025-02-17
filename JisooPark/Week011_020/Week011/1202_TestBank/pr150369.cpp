#include <string>
#include <vector>

using namespace std;

long long solution(int cap, int n, vector<int> deliveries, vector<int> pickups) {
    long long answer = 0;
    int deliverySum = 0;
    int pickupSum = 0;
    
    for(int i = n - 1; i >= 0; --i)
    {
        int count = 0;
        deliverySum += deliveries[i];
        pickupSum += pickups[i];
        
        while(deliverySum > 0 || pickupSum > 0)
        {
            deliverySum -= cap;
            pickupSum -= cap; 
            count++;
        }
        
        answer += (i + 1) * 2 * count;
    }
    
    return answer;
}