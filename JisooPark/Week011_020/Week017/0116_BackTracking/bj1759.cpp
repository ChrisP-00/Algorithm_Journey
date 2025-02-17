#include <iostream> 
#include <vector> 
#include <algorithm>

using namespace std;

int l, c;
vector<char> alphabets;
vector<string> ans;
char current[16];
int vowelCount = 0, consonantCount = 0;

bool isVowel(char ch)
{
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
}

void makeCode(int wordLength, int idx)
{
    if(wordLength == l)
    {
        if(vowelCount >= 1 && consonantCount >= 2)
        {
            ans.push_back(string(current, l));
        }
        return;
    }
    
    for(int i = idx; i < c; ++i)
    {
        current[wordLength] = alphabets[i];
        if(isVowel(alphabets[i]))
        {
            vowelCount++;
        }
        else
        {
            consonantCount++;
        }

        makeCode(wordLength + 1, i + 1);

        if(isVowel(alphabets[i]))
        {
            vowelCount--;
        }
        else
        {
            consonantCount--;
        }
    }
}

int main()
{
    cin >> l >> c;
    
    alphabets.resize(c);
    for(int idx = 0; idx < c; ++idx)
    {
        cin >> alphabets[idx];
    }
    
    sort(alphabets.begin(), alphabets.end());
    
    makeCode(0, 0);

    for(const string& s : ans)
    {
        cout << s << '\n';
    }
    
    return 0;
}