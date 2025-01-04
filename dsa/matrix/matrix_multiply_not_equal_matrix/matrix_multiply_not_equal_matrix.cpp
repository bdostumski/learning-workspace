//
// Multiply not Equal Matrix
//

#include <iostream>
using namespace std;

int main() {

		int A[3][3] = {
				1, 5, 7,
				6, 2, 4,
				-5, 1, 6
		};

		int B[3][2] = {
				5, 3,
				-6, 4,
				2, 7
		};

		int C[3][2] = { 0 };

		for(int i=0; i<3; i++) {
				for(int j=0; j<2; j++) {
						for(int k=0; k<3; k++) {
								C[i][j] += A[i][k] * B[k][j];
						}
						cout << C[i][j] << " ";
				}
				cout << endl;
		}

		return 0;

}

// A[i][k]
// A11 A12 A13 
// A21 A22 A23
// A31 A32 A33
//
// B[k][j]
// B11 B12
// B21 B22
// B31 B32
//
// C[i][j]
// C11 C12
// C21 C22
// C31 C32
//
// C11 = A11 * B11 + A12 * B21 + A13 * B31
// C12 = A11 * B21 + A12 * B22 + A13 * B23
//
// C21 = A21 * B11 + A22 * B21 + A23 * B31
// C22 = A21 * B12 + A22 * B22 + A23 * B32
//
// C31 = A31 * B11 + A32 * B21 + A33 * B31
// C32 = A31 * B12 + A32 * B22 + A33 * B32
