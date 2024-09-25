#include <iostream> 
#include <deque> 
#include <stack>
#include <sstream>

using namespace std;

void process()
{
    string commands = "", arrays = ""; 
    int n = 0; 
    cin >> commands >> n >> arrays;

    deque<int> answer;

    stringstream ss(arrays.substr(1, arrays.length() - 2));

    string word;
    while(getline(ss, word, ','))
    {
        answer.emplace_back(stoi(word));
    }

    bool rev = false;

    for(int i = 0; i < commands.length(); ++i)
    {
        if(commands[i] == 'R')
        {
            rev = !rev;
        }
        else if(commands[i] == 'D')
        {
            if(!answer.empty())
            {
                if(rev)
                {
                    answer.pop_back();
                }
                else
                {
                    answer.pop_front();
                }
            }
            else
            {
                cout << "error\n"; 
                return; 
            }
        }
    }

    if(answer.empty())
    {
        cout << "[]\n"; 
        return;
    }

    cout << '[';
    int s = answer.size();

    // 뒤에서부터 출력 
    if(rev)
    {
        for(int i = s - 1; i > 0; --i)
        {
            cout << answer[i] << ',';
        }

        cout << answer[0] << ']';
    }
    // 앞에서부터 출력
    else
    {
        for(int i = 0; i < s - 1; ++ i)
        {
            cout << answer[i] << ',';
        }

        cout << answer[s - 1] << ']';
    }
    
    cout << '\n';

    answer.clear();
    ss.clear();
    commands.clear();
    arrays.clear();
}

int main()
{
    int T; 

    cin >> T; 

    while(T > 0)
    {
        process();
        --T;
    }

    return 0;
}
