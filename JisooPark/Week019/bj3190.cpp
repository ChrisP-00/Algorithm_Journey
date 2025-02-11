#include <iostream>
#include <deque>
#include <vector>
#include <map> 

using namespace std;


int mapSize, appleCount,directionInfo; 
vector<vector<int> > board;
map<int, char> directions;

// 오른 > 아래 > 왼 > 위 
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int simulate()
{
    deque<pair<int, int>> snake; 
    snake.push_back({0, 0});
    board[0][0] = 2;

    int time = 0, direction = 0;

    while(true)
    {
        time++;
        int ny = snake.front().first + dy[direction];
        int nx = snake.front().second + dx[direction];

        if(ny < 0 || ny >= mapSize || nx < 0 || nx >= mapSize || board[ny][nx] == 2)
        {
            return time;
        }

        if(board[ny][nx] == 1)
        {
            board[ny][nx] = 2;
            snake.push_front({ny, nx});
        }
        else
        {
            board[ny][nx] = 2;
            snake.push_front({ny, nx});

            board[snake.back().first][snake.back().second] = 0;
            snake.pop_back();
        }

        if(directions.count(time))
        {
            if(directions[time] == 'L')
            {
                direction = (direction + 3) % 4;
            }
            else if(directions[time] == 'D')
            {
                direction = (direction + 1) % 4;
            }
        }
    }
    return -1;
}


int main()
{
    cin >> mapSize >> appleCount;
    board.resize(mapSize, vector<int>(mapSize, 0));

    while(appleCount--)
    {
        int x, y;
        cin >> y >> x;
        board[y - 1][x - 1] = 1;
    }

    cin >> directionInfo;
    while(directionInfo--)
    {
        int time;
        char dir;
        cin >> time >> dir;
        directions[time] = dir;
    }

    cout << simulate() << '\n';

    return 0;
}