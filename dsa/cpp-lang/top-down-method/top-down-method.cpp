//
// Top Down Method - complexity O(n2)
// (n-1)+(n-1)*(n-1) => (n-1)+(n-1)^2 => n-1 + n^2 - 2n+1 => n^2 - n=> O(n2)
// Sorted one array in another array
//

#include <iostream>
using namespace std;

int main() {

		int A[100], B[100], I, J, N, Flag, Min, Max;

		cout << "Enter the array size: ";
		cin >> N;

		for(I=0; I<N; I++) {
				cout << "Number " << I+1 << ": ";
				cin >> A[I];
		}

		//
		// find max value from A array
		// add max value to end of B array
		//

		Max = A[0];
		for(I=1; I<N; I++) {
				if(A[I] > Max) Max = A[I];
		}
		B[N-1] = Max;

		//
		// array A pass "N-1" loops in "I < N-1" loop
		// loop "J" looking for Min value
		// Flag gets the index of Min value
		// Finded Min is added to B
		// "transfered" B element is deactivate with Max value
		//

		for(I=0; I<N-1; I++) {
				Min = A[0];
				Flag = 0;

				for(J=1; J<N; J++) {
						if(A[J] < Min) {
								Min = A[J];
								Flag = J;
						}
				}
				B[I] = Min;
				A[Flag] = Max;
		}

		cout << endl;
		cout << "----------";
		cout << endl;

		for(I=0; I<N; I++) { 
				cout << "Sorted " << I+1 << ": ";
				cout << B[I] << endl;
		}

		return 0;

}
