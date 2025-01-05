#include <iostream>
using namespace std;

void hanoi(int n, char from, char to, char aux) {

		if(n==1) {
				cout << n << ": " << from << aux << to <<  endl;
				return;
		}

		hanoi(n-1, from, aux, to);
		cout  << n  << ": "<< from << aux << to << endl;
		hanoi(n-1, aux, to, from);

}

int main() {
		
		int n = 4;
		hanoi(n, 'D', 'O', 'S');

		return 0;

}
