// Recurce In

#include <iostream>

using namespace std;

void euclid(int a, int b) {
		
		if(a % b > 0) { 
				cout << a << " = " << a / b << " . " << b << " + "  << a % b << endl;
				euclid(b, a % b);
		} else {
				cout << a << " = " << a / b << " . " << b << " + "  << a % b << endl;
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
