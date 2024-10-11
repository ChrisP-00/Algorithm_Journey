#include <iostream>
#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);

using namespace std; 

int n, k;

void merge(int left, int mid, int right, int* arrPtr)
{
    if((right - left) > (n / k))
    {
        return;
    }

    int* tempArrPtr = new int[right - left + 1];

    int leftIdx = left; 
    int midIdx = mid + 1;
    int tempIdx = 0;

    while(leftIdx <= mid && midIdx <= right)
    {
        arrPtr[leftIdx] <= arrPtr[midIdx] ? 
        tempArrPtr[tempIdx++] = arrPtr[leftIdx++] : 
        tempArrPtr[tempIdx++] = arrPtr[midIdx++];
    }

    // 왼쪽 서브어레이가 남았을 경우 
    while(leftIdx <= mid)
    {
        tempArrPtr[tempIdx++] = arrPtr[leftIdx++];
    }

    // 오른쪽 서브어레이가 남았을 경우
    while(midIdx <= right)
    {
        tempArrPtr[tempIdx++] = arrPtr[midIdx++];
    }

    // 임시 배열의 값을 정렬 배열에 저장
    for(int i = left; i <= right; ++i)
    {
        arrPtr[i] = tempArrPtr[i - left]; 
    }

    delete(tempArrPtr);
}

void mergeSort(int left, int right, int* arrPtr)
{
    if(left < right)
    {
        int mid = (left + right) / 2;
        mergeSort(left, mid, arrPtr);
        mergeSort(mid + 1, right, arrPtr);
        merge(left, mid, right, arrPtr);
    }
}

int main()
{
    fast;

    cin >> n; 
    int* arrPtr = new int[n];

    for (int i = 0; i < n; ++i) 
    {
        int n;
        cin >> arrPtr[i];
    }

    cin >> k;

    mergeSort(0, n - 1, arrPtr);

    for(int i = 0; i < n; ++i)
    {
        cout << arrPtr[i] << ' ';
    }

    delete(arrPtr);
    return 0;
}