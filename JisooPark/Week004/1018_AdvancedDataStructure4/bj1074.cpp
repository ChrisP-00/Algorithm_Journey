#include <iostream> 

#define fastcpp cin.tie(0), cout.tie(0), ios::sync_with_stdio(false)

using namespace std; 


int find(int& x, int& y, int minX, int minY, int yN, int xN, int n)
{
    int maxX = (1 << xN) + minX; 
    int maxY = (1 << yN) + minY;

    // 1/4분면
    if(minX <= x && x < maxX / 2 && minY <= y < maxY / 2)
    {
        return find(x, y, minX, minY, yN - 1, xN - 1, n - 1);
    }

    // 2/4분면
    else if(minX / 2 <= x && x < maxX && minY / 2 <= y && y < maxY)
    {
        return find(x, y, minX / 2, minY, yN - 1, xN, n - 1);
    } 

    // 3/4분면
    else if(minX <= x && x < maxX / 2 && minY / 2 <= y && y < maxY)
    {
        return find(x, y, minX / 2, minY, yN, xN - 1, n - 1);
    }
    // 4/4 분면
    else
    {
       return find(x, y, maxX / 2, maxY / 2, yN, xN, n - 1);
    }
}

int n, r, c; 
int ans;

void find(int y, int x, int size)
{
    if(y == r && x == c)
    {
        cout << ans; 
        return;
    }

    if(r < y + size && r >= y && c < x + size && c >= x)
    {
        find(y, x, size / 2);       // 1사분면
        find(y, x + size / 2, size / 2);    // 2사분면
        find(y + size / 2, x, size / 2);
        find(y + size / 2, x + size / 2, size /2); // 4분면
    }
    else
    {
        ans += size * size;
    }
}




int main()
{
    fastcpp; 

    cin >> n >> r >> c;
    find(0, 0, (1 << n));

    return 0;
}