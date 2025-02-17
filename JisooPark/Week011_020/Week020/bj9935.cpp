#include <iostream> 
#include <vector>
#include <string> 

using namespace std;

int main()
{
    ios::sync_with_stdio(false), cin.tie(NULL);
    string input, bomb; 
    cin >> input >> bomb; 

    int bombSize = bomb.size();
    string word = "";
    for(char c : input)
    {   
        word += c;

        if(word.size() >= bombSize && word.substr(word.size() - bombSize, bombSize) == bomb)
        {
            word.erase(word.size() - bombSize);
        }
    }

    if(word.empty())
    {
        cout << "FRULA";
    }
    else
    {
        cout << word;
    }

    return 0;
}