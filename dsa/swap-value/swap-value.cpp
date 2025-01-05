//
// SWAP VALUE from A to B 
//

#include <iostream>
using namespace std;

int main() {

		int A, B, T;

		cout << "Enter A(value): ";
		cin >> A;
		cout << "Enter B(value); ";
		cin >> B;

		cout << "Before SWAP (A) is: " << A << ", (B) is: " << B << "." << endl;

		T = B;
		B = A;
		A = T;

		cout << "------" << endl;

		cout << "After SWAP (A) is: " << A << ", (B) is: " << B << "." << endl;

		return 0;

}
