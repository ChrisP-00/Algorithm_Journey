#include <iostream>
#include <vector>
#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);

using namespace std; 

vector<int> arr;
vector<int> tempArr;
int n, k;

void merge(int left, int mid, int right)
{
    if((right - left) > (n / k))
    {
        return;
    }

    int leftIdx = left; 
    int midIdx = mid + 1;
    int tempIdx = left;

    while(leftIdx <= mid && midIdx <= right)
    {
        arr[leftIdx] <= arr[midIdx] ? 
        tempArr[tempIdx++] = arr[leftIdx++] : 
        tempArr[tempIdx++] = arr[midIdx++];
    }

    // 왼쪽 서브어레이가 남았을 경우 
    while(leftIdx <= mid)
    {
        tempArr[tempIdx++] = arr[leftIdx++];
    }

    // 오른쪽 서브어레이가 남았을 경우
    while(midIdx <= right)
    {
        tempArr[tempIdx++] = arr[midIdx++];
    }

    // 임시 배열의 값을 정렬 배열에 저장
    for(int i = left; i <= right; ++i)
    {
        arr[i] = tempArr[i]; 
    }

}

void mergeSort(int left, int right)
{
    if(left < right)
    {
        int mid = (left + right) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }
}


int main()
{
    fast;

    cin >> n; 

    arr.resize(n);
    tempArr.resize(n);

    for (int i = 0; i < n; ++i) 
    {
        cin >> arr[i];
    }

    cin >> k;

    mergeSort(0, n - 1);

    for(int i = 0; i < n; ++i)
    {
        cout << arr[i] << ' ';
    }

    return 0;
}