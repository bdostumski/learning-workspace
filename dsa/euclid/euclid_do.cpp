//
// GCD - Greatest Common Division
//

#include <iostream>
using namespace std;

int main() {

		int A, B, r;

		cout << "Enter A: ";
		cin >> A;
		cout << "Enter B: ";
		cin >> B;

		r = A % B;

		while(r > 0) {
				A = B;
				B = r;
				r = A % B;
		}

		cout << "The answer is: ";
		cout << B << endl;

		return 0;

}
