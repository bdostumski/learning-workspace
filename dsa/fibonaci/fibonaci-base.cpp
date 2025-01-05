#include <iostream>
using namespace std;
const unsigned max = 65100;
const unsigned lineLength = 12;

void fibonacci(int);

int main() {
    cout << "Редица на Фибоначи с 16 члена: \n";
    fibonacci(16);

    return 0;
}

void fibonacci(int max) {
    if(max < 2) return;
    cout << "0\t1\t";
    for(int i=3, v1=0, v2=1, cur; i<=max; ++i) {
        cur = v1 + v2;
        if(cur > ::max) {
            break;
        }
        cout << cur << "\t ";
        v1 = v2;
        v2 = cur;
        if(i % lineLength == 0)
            cout << endl;
    }
}
