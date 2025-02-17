#include <iostream>

#define fastcpp cin.tie(0), cout.tie(0), ios::sync_with_stdio(false);

using namespace std; 

bool IsTooMuch(int* CountPtr)
{
    int count = 0; 
    for(int i = 1; i < 10; ++i)
    {
        if(CountPtr[i] > 0)
        {
            count++;
        }
    }
    return count > 2;
}

int main()
{
    fastcpp;

    int n; 
    cin >> n; 

    int* tangPtr = new int[n];
    int* countPtr = new int[10]();

    for(int i = 0; i < n; ++i)
    {
        cin >> tangPtr[i];
    }

    int left = 0; 
    int right = 0;
    int maxValue = 0;

    while(left < n)
    {
        while(right < n)
        {
            // right를 한칸씩 이동하면서 해당 과일 종류의 갯수 ++ 
            countPtr[tangPtr[right]]++;

            // 과일 종류가 2 종 초과라면
            if(IsTooMuch(countPtr))
            {
                countPtr[tangPtr[right]]--;
                break;
            }
            right++;
        }
        maxValue = max(maxValue, right - left);
        countPtr[tangPtr[left]]--;
        left++;
    }

    cout << maxValue;

    delete[] tangPtr;
    delete[] countPtr;

    return 0;
}