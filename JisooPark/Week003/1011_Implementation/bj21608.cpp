#include <iostream> 
#include <vector>
#include <cmath>

using namespace std;

// 왼 -> 위 -> 우 -> 아래
vector<vector<int>> dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
vector<vector<pair<int, int>>> classroom; 
vector<vector<int>> students; 
int n;

pair<int, int> checkSeat(int y, int x, int idx)
{
    int favorite = 0; 
    int emptySeat = 0;

    for(int d = 0; d < 4; ++d)
    {
        int ny = y + dir[d][0];
        int nx = x + dir[d][1];

        // 범위를 벗어나나? 
        if(ny < 0 || ny >= n || nx < 0 || nx >= n)
        {
            continue;
        }

        if(classroom[ny][nx].first == 0)
        {
            emptySeat++;
        }
        else
        {
            for(int f = 1; f < 5; ++f)
            {
                 if(classroom[ny][nx].first == students[idx][f])
                {
                    favorite++;
                    break;
                }
            }
        }
    }

    return make_pair(favorite, emptySeat);
}

int checkValue()
{
    int ans = 0;
    int idx = 0;
    // 모든 자리를 확인해 감
    for(int y = 0; y < n; ++y)
    {
        for(int x = 0; x < n; ++x)
        {
            int idx = classroom[y][x].second;
            int favorite = 0;

            pair<int, int> temp = checkSeat(y, x, idx);

            ans += pow(10, temp.first - 1);
        }
    }

    return ans;
}

int main()
{
    cin >> n;

    classroom.assign(n, vector<pair<int, int>>(n, {0,0}));
    students.assign(n * n + 1, vector<int>(5));

    int count = n * n;

    for(int i = 0; i < count; ++i)
    {
        for(int j = 0; j < 5; ++j)
        {
            int n;
            cin >> n;
            // 0 = 학생, 1~4 좋아하는 학생의 번호
            students[i][j] = n; 
        }
    }

    classroom[1][1].first = students[0][0];
    classroom[1][1].second = 0;

    for(int idx = 1; idx < count; ++idx)
    {
        // 가장 좋았던 위치
        int mostFavorite = 0; 
        int emptySeat = -1;
        int fy = 0;
        int fx = 0;

        // 모든 자리를 확인해 감
        for(int y = 0; y < n; ++y)
        {
            for(int x = 0; x < n; ++x)
            {
                if(classroom[y][x].first != 0)
                {
                    continue;
                }
                // 현재 자리의 값어치를 계산
                pair<int,int> value = checkSeat(y, x, idx);

                // 좋아하는 친구가 제일 많음
                if(value.first > mostFavorite)
                {
                    mostFavorite = value.first;
                    emptySeat = value.second; 
                    fy = y;
                    fx = x;
                }
                // 좋아하는 친구 수가 같음
                else if(value.first == mostFavorite)
                {
                    // 빈칸이 많음
                    if(value.second > emptySeat)
                    {
                        mostFavorite = value.first;
                        emptySeat = value.second; 
                        fy = y;
                        fx = x;
                    }
                }
            }
        }

        classroom[fy][fx].first = students[idx][0];
        classroom[fy][fx].second = idx;
    }

    int answer = checkValue();
    cout << answer;
}