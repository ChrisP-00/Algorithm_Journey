#include <iostream> 
#include <vector>
#include <queue>

using namespace std; 

int main()
{
    int m, n, answer = 0;  
    cin >> m >> n;

    vector<pair<int, int> > dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    vector<vector<int> > box (n, vector<int>(m, 0)); 
    queue<pair<int,int> > goodTomato; 

    for(int y = 0; y < n; ++y)
    {
        for(int x = 0; x < m; ++x)
        {
            int tomato; 
            cin >> tomato; 

            box[y][x] = tomato; 

            if(tomato == 1)
            {
                goodTomato.push(make_pair(y, x));
            }
        }
    }

    while(!goodTomato.empty())
    {
        int qSize = goodTomato.size();
        bool isGoodTomato = false;

        for(int idx = 0; idx < qSize; ++idx)
        {
            pair<int, int> cur = goodTomato.front();
            goodTomato.pop();

            // 4방향 확인하기
            // dir (y, x) (-1, 0) 위, (1, 0) 아래, (0 -1) 왼, (0 1) 오른
            for(int idx = 0; idx < 4; idx++)
            {
                int tY = cur.first + dir[idx].first;
                int tX = cur.second + dir[idx].second;

                if(tY < 0 || tY >= n || tX < 0 || tX >= m)
                {
                    continue;
                }

                if(box[tY][tX] == 0)
                {
                    box[tY][tX] = 1;
                    goodTomato.push(make_pair(tY, tX));
                    isGoodTomato = true;
                }
            }
        }

        if(isGoodTomato)
        {
            answer++;
        }
    }

    for(int y = 0; y < n; ++y)
    {
        for(int x = 0; x < m; ++x)
        {
            if(box[y][x] == 0)
            {
                answer = -1;
                break;
            }
        }
        if(answer == -1)
        {
            break;
        }
    }

    cout << answer;


    return 0;
}