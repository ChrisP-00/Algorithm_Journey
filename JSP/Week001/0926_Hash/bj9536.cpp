#include <iostream> 
#include <map> 
#include <sstream> 
#include <vector>
#include <unordered_set>

using namespace std;

int main()
{
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    int T;

    cin >> T;
    cin.ignore();

    while(T--)
    {
        string input; 
        vector <string> result; 
        // map <string ,string> sounds;
        unordered_set <string> sounds;

        getline(cin, input);

        stringstream ss(input);
        string word; 

        while(ss >> word)
        {
            result.push_back(word);
        }

        getline(cin, input);

        while(input != "what does the fox say?")
        {
            stringstream ss(input);
            string word;
            int idx = 0;

            while(ss >> word)
            {
                if(idx == 2)
                {
                    if(sounds.find(word) == sounds.end())
                    {
                        sounds.insert(word);
                    }
                }
                idx++;
            }
            getline(cin, input);
        }
        
        if(!result.empty())
        {
            for(string s : result)
            {
                if(sounds.find(s) == sounds.end())
                {
                    cout << s << ' ';
                }
            }

            result.clear();
            sounds.clear();
        }
    
        cout << '\n';
    }

    return 0;
}