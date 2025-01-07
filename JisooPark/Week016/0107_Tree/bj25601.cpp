#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

vector<vector<int> > classes;
vector<bool> isVisited;
unordered_map<string, int> stoiIndex;

bool dfs(int node, int target)
{
    if(node == target)
    {
        return true;
    }
    
    isVisited[node] = true;
    
    for(const int child : classes[node])
    {
        if(!isVisited[child])
        {
            if(dfs(child, target))
            {
                return true;
            }
        }
    }
    
    return false;
}


int main()
{
    int n; 
    cin >> n;
 
    classes.resize(n * 2 + 1);
    string a, b;
    int index = 1;

    for(int i = 1; i < n; ++i)
    {
        cin >> a >> b;
        
        if(!stoiIndex.count(a))
        {
            stoiIndex[a] = index++;
        }
        
        if(!stoiIndex.count(b))
        {
            stoiIndex[b] = index++;
        }   
        
        classes[stoiIndex[a]].push_back(stoiIndex[b]);
    }
    
    cin >> a >> b;

    if(stoiIndex.find(a) == stoiIndex.end() || stoiIndex.find(b) == stoiIndex.end())
    {
        cout << 1;
        return 0;
    }

    int start = stoiIndex[a];
    int target = stoiIndex[b];
    
    isVisited.assign(n + 1, false);
    bool atob = dfs(start, target);

    isVisited.assign( n+ 1, false);
    bool btoa = dfs(target, start);
    
    cout << (atob || btoa);
    
    return 0;
}