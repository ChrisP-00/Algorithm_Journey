#include <string>
#include <vector>
#include <sstream>
#include <cmath>
#include <map>

using namespace std;

int stom (string& time)
{
    int h = (time[0] - '0') * 10 + time[1] - '0';
    int m = (time[3] - '0') * 10 + time[4] - '0';
         
    return h * 60 + m;
}

vector<int> solution(vector<int> fees, vector<string> records) {

    map<string, vector<int>> cars;
    for(const string& record : records)
    {
        string time, number, status; 
        stringstream ss (record);
        ss >> time >> number >> status; 
        
        cars[number].push_back(stom(time));
    }
    
    vector<int> answer;
    for(auto& car : cars)
    {      
        if(car.second.size() % 2 != 0)
        {
            car.second.push_back(1439);
        }
        
        int ttl = 0;
        for(int idx = 1; idx < car.second.size(); idx += 2)
        {
            ttl += car.second[idx] - car.second[idx - 1];
        }
        
        int cost = fees[1];
        if(ttl - fees[0] > 0)
        {
            cost += ceil((double)(ttl - fees[0]) / fees[2]) * fees[3];
        }
        
        answer.push_back(cost);
    }
    
    return answer;
}