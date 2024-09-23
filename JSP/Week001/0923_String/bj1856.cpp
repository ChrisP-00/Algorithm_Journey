#include <iostream>
using namespace std;

int w, l, cache[300];
string s, word[600];

int main() {
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    // 입력 처리
    cin >> w >> l;
    cin >> s;

    for (int i = 0; i < w; ++i) 
    {
        cin >> word[i];
    }

    // DP 계산
    for (int i = 0; i < l; ++i) 
    {
        cache[i] = i + 1;  // 최악의 경우는 i+1개의 문자 모두 제거하는 것

        // 각 단어에 대해 비교
        for (int j = 0; j < w; ++j) {
            int idx = (int)word[j].length() - 1;  // 현재 단어의 끝에서부터 비교
           
            for (int k = i; k >= 0; --k) 
            {
                if (s[k] == word[j][idx]) 
                {
                    --idx;
                    if (idx == -1) {  // 단어 전체가 일치했을 때
                        cache[i] = min(cache[i], (k == 0 ? 0 : cache[k - 1]) + (int)(i + 1 - k - word[j].length()));
                    }
                }
            }
        }
    }

    // 결과 출력
    cout << cache[l - 1];
    return 0;
}