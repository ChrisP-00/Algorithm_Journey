#include <iostream> 
#define fastCPP ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);

using namespace std; 

int ctoi(char letter)
{
    if(letter >= 'A' && letter <= 'Z')
    {
        return letter - 'A';
    }

    return letter - 'a' + 26;
}

int main()
{
    fastCPP;
    
    int words [53] {0};
    int wordCount [53] {0};

    int targetLength, stringLength; 
    cin >> targetLength >> stringLength;

    char targetWord[3005]; 
    char input[3000005];
    cin >> targetWord >> input; 

    for(int i = 0; i < targetLength; ++i)
    {
        words[ctoi(targetWord[i])]++;
        wordCount[ctoi(input[i])]++;
    }

    int start = 0;
    int end = targetLength;
    int count = 0;

    while(end <= stringLength)
    {
        bool hasFound = true;
        for(int i = 0; i < targetLength; ++i)
        {
            if(words[ctoi(targetWord[i])] != wordCount[ctoi(targetWord[i])])
            {
                hasFound = false; 
                break;
            }
        }

        if(hasFound)
        {
            count++;
        }

        if(end < stringLength)
        {
            wordCount[ctoi(input[start])]--;
            wordCount[ctoi(input[end])]++;
        }

        start++;
        end++;
    }

    cout << count;
}