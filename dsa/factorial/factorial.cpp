#include <iostream>
using namespace std;

// Fact (Recursive)
// int fact(int n){ 
//     if(n<=1) {
//         return 1;
//     }
//     return n * fact(n-1);
// }

// int main() {
//     int n;
//     cin >> n;
//     cout << fact(n);
// }


// Fact (Iterative)
unsigned fact(unsigned n) {
    if(n <= 1) return 1;
    unsigned f = 1, i = 1;
    while(i <= n) {
        f *= i;
        i++;
    }

    return f;
}

int main() {
    int n;
    cin >> n;

    cout << fact(n);
}