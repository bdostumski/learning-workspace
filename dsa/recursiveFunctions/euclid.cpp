// Recurce Out

#include <iostream>
using namespace std;

void euclid(int a, int b) {

		if(a % b > 0) {
				euclid(b, a % b);
				cout << a << " = " << a / b << " . " << b << " + " << a % b << endl;
		} else {
				cout << a << " = " << a / b << " . " << b << " + " << a % b << endl;
		}
}


int main() {

		int a, b;
		cout << "Enter A: ";
		cin >> a;
		cout << "Enter B: ";
		cin >> b;

		euclid(a, b);

		return 0;

}
