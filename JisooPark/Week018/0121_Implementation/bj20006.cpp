#include <iostream> 
#include <vector>
#include <string> 
#include <algorithm>

using namespace std; 

int p, m;

struct Player 
{
    int level;
    string id;
};

struct Room 
{
    int minLevel;
    int maxLevel;

    vector<Player> playerList;
};


int main() 
{
    cin >> p >> m;

    vector<Room> rooms;     

    for(int idx = 0; idx < p; ++idx)
    {
        int level;
        string id; 
        cin >> level >> id;

        bool isAssigned = false;

        for(auto& room : rooms)
        {
            if(room.minLevel <= level && level <= room.maxLevel 
            && room.playerList.size() < m)
            {
                room.playerList.push_back({level, id});
                isAssigned = true;
                break;
            }
        }

        if(!isAssigned)
        {
            rooms.push_back({level - 10, level + 10, {{level, id}}});
        }
    }

    for(auto& room : rooms)
    {
        sort(room.playerList.begin(), room.playerList.end(), 
        [](const Player& a, const Player& b)
        {
            return a.id < b.id;
        });
        
        if(room.playerList.size() == m)
        {
            cout << "Started!\n";
        }
        else
        {
            cout << "Waiting!\n";
        }
        
        for(auto& player : room.playerList)
        {
            cout << player.level << ' ' << player.id << '\n';
        }
    }

    return 0;
}