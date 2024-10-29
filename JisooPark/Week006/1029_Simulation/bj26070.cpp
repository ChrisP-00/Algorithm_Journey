#include <iostream> 
#include <vector> 

using namespace std;


int main()
{
    vector<long long> gom (3,0);    

    for(int idx = 0; idx < 3; ++idx)
    {
        cin >> gom[idx];
    }

    vector<long long> tto (3,0);    

    for(int idx = 0; idx < 3; ++idx)
    {
        cin >> tto[idx];
    }

    long long total = 0;

    for(int idx = 0; idx < 3; ++idx)
    {
        long long canEat = min(gom[idx], tto[idx]);

        total += canEat; 
        gom[idx] -= canEat;
        tto[idx] -= canEat;
    }
    
    int count = 3;
    while(count--)
    {
        for(int idx = 0; idx < 3; ++idx)
        {
            int prevCoupon = (idx + 2) % 3;

            if(tto[prevCoupon] >= 3)
            {
                long long temp = tto[prevCoupon] / 3; 
                long long canEat = min(gom[idx], temp);

                if(gom[idx] > 0)
                {
                    total += canEat; 
                    gom[idx] -= canEat;
                }

                tto[prevCoupon] -= temp * 3;
                tto[idx] += temp - canEat;
            }

            printf("현재 idx: %d 이전 쿠폰: %d 현재 쿠폰: %d \n", idx, tto[prevCoupon], tto[idx]);
        }
    }

    cout << total;

    return 0;
}