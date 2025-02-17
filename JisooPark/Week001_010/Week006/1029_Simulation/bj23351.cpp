#include <iostream>

using namespace std; 

int main()
{
    int n, k, a, b;
    cin >> n >> k >> a >> b;

    int* catnipPtr = new int[n];
    fill(catnipPtr, catnipPtr + n, k);

    int idx = 0;
    int days = 1;
    bool isAlive = true;

    while(isAlive)
    {
        int count = idx + a;

        for(int i = idx; i < count; ++i)
        {
            catnipPtr[i] += b; 
            idx = (i + 1) % n;
        }

        for(int i = 0; i < n; ++i)
        {
            catnipPtr[i]--;

            if(catnipPtr[i] <= 0)
            {
                isAlive = false;
                break;
            }
        }

        if(isAlive)
        {
            days++;
        }
    }

    cout << days;

    delete[] catnipPtr;

    return 0;
}