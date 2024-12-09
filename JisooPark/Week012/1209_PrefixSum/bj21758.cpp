#include <iostream>
#define fast ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL)

using namespace std;

int main() {
    fast;

    int n;
    cin >> n;

    int honey[100002] = {0,};
    int prefixSum[100002] = {0, };

    // 입력 및 누적 합 계산
    for (int i = 1; i <= n; ++i) {
        cin >> honey[i];
        prefixSum[i] = honey[i] + prefixSum[i - 1];
    }

    int answer = 0;

    for (int idx = 2; idx < n; ++idx) {
        // 벌[1] - 벌통[idx] - 벌[n]
        answer = max(answer, 2 * prefixSum[n] - honey[1] - honey[idx] - prefixSum[idx]);

        // 벌통[1] - 벌1[idx] - 벌2[n]
        answer = max(answer, prefixSum[n - 1] - honey[idx] + prefixSum[idx - 1]);

        // 벌[1] - 벌2[idx] - 벌통[n]
        answer = max(answer, prefixSum[idx] - honey[1] + prefixSum[n - 1] - prefixSum[idx - 1]);
    }

    cout << answer;

    return 0;
}
