#include <iostream> 
#include <vector> 

using namespace std; 


int input = -1;
vector<int> numbers; 
vector<int> answer; 

void printNumber(int n)
{
    if(answer.size() == 6)
    {
        for(int n : answer)
        {
            cout << n << ' ';
        }
        cout << '\n';
        return;
    }

    for(int i = n; i < input; ++i)
    {
        answer.push_back(numbers[i]);
        printNumber(i + 1);
        answer.pop_back();
    }
}


int main()
{
    do
    {
        cin >> input; 

        numbers.resize(input, 0);

        for(int i = 0; i < input; ++i)
        {
            int n; 
            cin >> n;

            numbers[i] = n;
        }

        printNumber(0);

        cout << '\n';


    }while(input != 0);

    return 0;
}