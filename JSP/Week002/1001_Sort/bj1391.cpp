#include <iostream>
#include <vector> 
#include <algorithm> 

using namespace std; 

int main()
{
    int answer = 1, n, currentHour; 
    vector<pair<int, int> > meetings;

    cin >> n;

    for(int i = 0; i < n; ++i)
    {
        int start, end; 

        cin >> start >> end; 

        meetings.push_back(make_pair(end, start));
    }

    sort(meetings.begin(), meetings.end());

    currentHour = meetings[0].first;

    for(int i = 1; i < n; ++i)
    {
        if(meetings[i].second >= currentHour)
        {
            answer++;
            currentHour = meetings[i].first;
        }
    }

    cout << answer;

    return 0;
}