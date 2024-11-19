#include <iostream> 
#include <unordered_set> 
#include <string> 
#include <vector>

#define fastCPP ios::sync_with_stdio(0), cin.tie(NULL), cout.tie(NULL);

using namespace std;

const size_t base = 31;
const size_t mod = 1e9 + 7;

/* hash * binary search */
bool hasDuplicatedWord(int k, int row, int column, const vector<size_t>& hashTable, const vector<size_t>& basePower, const vector<string>& words)
{
    vector<size_t> rollingHash = hashTable;
    unordered_set<size_t> tempTable; 

    for(int r = 0; r < k; ++r)
    {
        tempTable.clear();

        for(int c = 0; c < column; ++c)
        {
            rollingHash[c] = (rollingHash[c] - (words[r][c] * basePower[row - r - 1]) % mod + mod) % mod;

            if(tempTable.find(rollingHash[c]) != tempTable.end())
            {
                return true;
            }

            tempTable.insert(rollingHash[c]);
        }
    }

    return false;
}


int main()
{
    fastCPP;

    int row, column;
    cin >> row >> column;

    int answer = 0;

    /* ==== substr ======
    vector<string> words; 

    for(int idx = 0; idx < row; ++idx)
    {
        string input; 
        cin >> input; 

        words.push_back(input);
    }

    vector<string> subWords (column, "");

    for(int c = 0; c < column; ++c)
    {       
        for(int r = 0; r < row; ++r)    
        {
            subWords[c] += words[r][c];
        }
    }

    for(int r = 0; r < row; ++r)
    {
        unordered_set<string> tempSet; 
        bool found = false; 

        for(int c = 0; c < column; ++c)
        {
            subWords[c].erase(subWords[c].begin());

            if(tempSet.find(subWords[c]) != tempSet.end())
            {
                answer = r; 
                found = true;
                break;
            }

            tempSet.insert(subWords[c]);
        }

        if(found)
        {
            break;
        }
    } */


    /* ========= Hash table ========== 
    vector<string>words(row);

    for(int r = 0; r < row; ++r)
    {
       cin >> words[r];
    }

    vector<size_t> hashTable (column, 0); 
    vector<size_t> basePower (row, 1);

    for(int i = 1; i < row; ++i)
    {
        basePower[i] = (basePower[i - 1] * base) % mod;
    }

    for(int c = 0; c < column; ++c)
    {
        for(int r = 0; r < row; ++r)
        {
            hashTable[c] = (hashTable[c] * base + words[r][c]) % mod;
        }
    }

    bool found = false;

    for(int r = 0; r < row - 1; ++r)
    {
        unordered_set<size_t> tempTable; 

        for(int c = 0; c < column; ++c)
        {
            hashTable[c] = (hashTable[c] - (words[r][c] * basePower[row - r - 1]) % mod + mod) % mod; 
           
            if(tempTable.find(hashTable[c]) != tempTable.end())
            {
                found = true;
                break;
            }

            tempTable.insert(hashTable[c]);
        }

        if(found)
        {
            break;
        }

        answer++;
    } */



   /* ===== hast table & binary search */

    vector<string>words(row);

    for(int i = 0; i < row; ++i)
    {
        cin >> words[i];
    }

    vector<size_t> hashTable (column, 0); 
    vector<size_t> basePower (row, 1);

    for(int i = 1; i < row; ++i)
    {
        basePower[i] = (basePower[i - 1] * base) % mod;
    }

    for(int c = 0; c < column; ++c)
    {
        for(int r = 0; r < row; ++r)
        {
            hashTable[c] = (hashTable[c] * base + words[r][c]) % mod;
        }
    }

    int high = row - 1; 
    int low = 0;
    
    while(low <= high)
    {
        int mid = (low + high) / 2;

        if(!hasDuplicatedWord(mid, row, column, hashTable, basePower, words))
        {
            answer = mid;
            low = mid + 1;
        }
        else
        {
            high = mid - 1; 
        }
    }

    cout << answer;

    return 0;
}