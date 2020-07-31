#include <iostream>
#include <limits>
#include <ctime>

using  namespace std;

class Solution {
public:
    string multiply(string num1, string num2) {

    }
};
    int main(){
        int x = 3, y = 4;
        int *a = &x, *b = &y;
        cout << ++*a << "\t" << ++*b << endl;
        cout << a << "\t" << b << endl;
        cout << a - 1 << "\t" << b << endl;
        cout << *a - 1 << "\t" << *(a-1) << endl;

        time_t now = time(0);
        tm *ltm = localtime(&now);
        cout << ltm -> tm_hour << ":" << ltm -> tm_min << ":" << ltm -> tm_sec << endl;

        return 0;
    }
