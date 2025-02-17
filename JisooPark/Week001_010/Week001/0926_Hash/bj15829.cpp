#include <iostream> 
#include <cmath> 
#include <map> 

using namespace std; 

long long modPow(long long base, long exp, long long mod)
{
    long long result = 1; 
    while(exp > 0)
    {
        if(exp % 2 == 1)
        {
            result = (result * base) % mod;
        }   

        base = (base * base) % mod;
        exp /= 2;
    }

    return result;
}

int main()
{
    map<char, long long> myMap;

    int l; 
    string input;
    long long result = 0, hash = 31, M = 1234567891; 

    cin >> l >> input; 

    for(int i = 0; i < l; ++i)
    {
        long long temp = 0;

        if(myMap.find(input[i]) == myMap.end())
        {
            myMap[input[i]] = input[i] - 96; 
        }

        temp = modPow(hash, i, M);   

        result = (result + (myMap[input[i]] * temp) % M) % M; 
    }

    cout << result; 

    return 0;
}