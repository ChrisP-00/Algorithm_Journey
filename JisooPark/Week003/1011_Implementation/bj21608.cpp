#include <iostream> 
#include <vector>
#include <cmath>

using namespace std;

vector<vector<int>> dir = {{-1, 0},  {0,-1}, {1, 0}, {0, 1}};
vector<vector<int>> classroom; 
vector<vector<int>> students; 
int n;

pair<int, int> checkSeat(int y, int x, int student)
{
    int favorite = 0; 
    int emptySeat = 0;

    for(int d = 0; d < 4; ++d)
    {
        int ny = y + dir[d][0];
        int nx = x + dir[d][1];

        // 범위를 벗어나나? 
        if(ny < 0 || ny > n || nx < 0 || nx > n)
        {
            continue;
        }

        if(classroom[ny][nx] == 0)
        {
            emptySeat++;
        }
        else
        {
            for(int f = 1; f < 5; ++f)
            {
                if(classroom[ny][nx] == students[student][f])
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

    // 모든 자리를 확인해 감
    for(int y = 0; y < n; ++y)
    {
        for(int x = 0; x < n; ++x)
        {
            int s = classroom[y][x];
            int favorite = 0;

            for(int d = 0; d < 4; ++d)
            {
                int ny = y + dir[d][0];
                int nx = x + dir[d][1];

                // 범위를 벗어나나? 
                if(ny < 0 || ny > n || nx < 0 || nx > n)
                {
                    continue;
                }

                for(int f = 1; f < 5; ++f)
                {
                    if(classroom[ny][nx] == students[s][f])
                    {
                        favorite++;
                        break;
                    }
                }
            }

            ans += pow(10, favorite - 1);
        }
    }

    return ans;
}

int main()
{
    cin >> n;

    classroom.assign(n, vector<int>(n, 0));
    students.assign(n * n + 1, vector<int>(5));

    // student[f][s]
    //  f == 학생 앉는 순서
    // s 의 배열 -> 0 학생, 1~4 친구
    
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

    classroom[1][1] = students[0][0];

    for(int idx = 1; idx < count; ++idx)
    {
        // 자리에 앉을 학생
        int s = students[idx][0];

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
                if(classroom[y][x] != 0)
                {
                    continue;
                }

                // 현재 자리의 값어치를 계산
                pair<int,int> value = checkSeat(y, x, s);

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

        classroom[fy][fx] = s;
    }

    for(int y = 0; y < n; ++y)
    {
        for(int x = 0; x < n; ++x)
        {
            cout << classroom[y][x] << ' ';
        }

        cout << '\n';
    }

    // int answer = checkValue();
    // cout << answer;
}