#include <iostream> 
#include <vector> 

using namespace std;

vector<pair<int, int> > dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

void rotateSubmap(int y, int x, int range, vector<vector<int> >& ice, vector<vector<int> >& temp)
{
    for(int i = 0; i < range; ++i)
    {
        for(int j = 0; j < range; ++j)
        {
            // 90도 시계 방향 회전
            temp[y + j][x + range - i - 1] = ice[y + i][x + j];
        }
    }
}

void rotateMap(vector<vector<int> >& ice, int range)
{
    int mapSize = ice.size();
    vector<vector<int> > tempMap (mapSize, vector<int>(mapSize, 0)); 

    for(int y = 0; y < mapSize; y += range)
    {
        for(int x = 0; x < mapSize; x += range)
        {
            rotateSubmap(y, x, range, ice, tempMap);
        }
    }

    ice = tempMap;
}


bool isIceMelt(vector<vector<int> >& ice, int r, int c)
{
    int count = 0;

    for(int idx = 0; idx < 4; ++idx)
    {
        int nr = r + dir[idx].first;
        int nc = c + dir[idx].second;
    
        if(nr < 0 || nr >= ice.size() || nc < 0 || nc >= ice.size() || ice[nr][nc] == 0)
        {
            continue; 
        }

        count++;
    }

    return count < 3;
}


void meltIce(vector<vector<int> >& ice)
{
    vector<vector<int> > tempMap = ice; 

    for(int r = 0; r < ice.size(); ++r)
    {
        for(int c = 0; c < ice.size(); ++c)
        {
            if(isIceMelt(ice, r, c))
            {
                if (tempMap[r][c] > 0) {
                    tempMap[r][c]--;
                }
            }
        }
    }

    ice = tempMap;
}

vector<vector<bool> > isVisited;

int iceBlock(int r, int c, vector<vector<int> >& ice)
{
    if(ice[r][c] == 0)
    {
        return 0;
    }

    isVisited[r][c] = true;
    
    int size = 1;

    for(int idx = 0; idx < 4; ++idx)
    {
        int nr = r + dir[idx].first;
        int nc = c + dir[idx].second;

        if(nr < 0 || nr >= ice.size() || nc < 0 || nc >= ice.size() || isVisited[nr][nc])
        {
            continue; 
        }

        size += iceBlock(nr, nc, ice);
    }

    return size;
}


int main()
{
    int mapSize, spellCount;
    cin >> mapSize >> spellCount;

    mapSize = 1 << mapSize;

    vector<vector<int> > ice (mapSize, vector<int>(mapSize, 0));
    
    for(int r = 0; r < mapSize; ++r)
    {
        for(int c = 0; c < mapSize; ++c)
        {
            cin >> ice[r][c];
        }
    }


    while(spellCount--)
    {
        int spell; 
        cin >> spell; 

        spell = 1 << spell;

        rotateMap(ice, spell);

        meltIce(ice);
    }

    int totalIce = 0;
    int maxIce = 0;


    isVisited.assign(mapSize, vector<bool>(mapSize, false));

    for(int r = 0; r < mapSize; ++r)
    {
        for(int c = 0; c < mapSize; ++c)
        {
            totalIce += ice[r][c];

            if(ice[r][c] > 0)
            {   
                maxIce = max(maxIce, iceBlock(r, c, ice)); 
            }
        }
    }

    cout << totalIce << '\n' << maxIce;

    return 0;
}