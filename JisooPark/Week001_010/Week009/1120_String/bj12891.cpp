#include <iostream> 

#define fastCPP ios::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);

using namespace std;

int main()
{
    fastCPP;
    // ACGT 
    int stringLength, windowSize;

    cin >> stringLength >> windowSize;

    string input = ""; 
    cin >> input; 

    int dna[100] {0};

    cin >> dna['A'] >> dna['C'] >> dna['G'] >> dna['T'];

    int start = 0; 
    int end = windowSize - 1;

    int wordCount[100] {0};

    for(int i = 0; i <= end; ++i)
    {
        wordCount[input[i]]++;
    }

    int count = 0;

    while(end < stringLength)
    {
        if(wordCount['A'] >= dna['A'] && wordCount['C'] >= dna['C']
        && wordCount['G'] >= dna['G'] && wordCount['T'] >= dna['T'])
        {
            count++;
        }

        wordCount[input[start++]]--;
        wordCount[input[++end]]++;
    }

    cout << count; 

    return 0;
}