//
// Matrix Multiplication 
//

#include <iostream>
using namespace std;

int main() {

		int A[3][3] = {
				1, 2, 3,
				4, 5, 6,
				7, 8, 9
		};

		int B[3][3] = {
				3, 2, 1,
				1, 2, 3,
				3, 2, 1
		};

		int C[3][3] = { 0 };

		for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
						for(int k=0; k<3; k++) {
								C[i][j] += A[i][k] * B[k][j];
						}
						cout << C[i][j] << " ";
				}
				cout << endl;
		}
		
		return 0;

}

//
// A[i][k]
// A11 A12 A13
// A21 A22 A23
// A31 A32 A33
//
// B[k][j]
// B11 B12 B13
// B21 B22 B23
// B31 B32 B33
//
// C[i][j]
// C11 C12 C13
// C21 C22 C23
// C31 C32 C33
//
// C11 = A11 * B11 + A12 * B21 + A13 * B31
// C12 = A11 * B12 + A12 * B22 + A13 * B32
// C13 = A11 * B13 + A12 * B23 + A13 * B33
//
// C21 = A21 * B11 + A22 * B21 + A23 * B31
// C22 = A21 * B12 + A22 * B22 + A23 * B32
// C23 = A21 * B13 + A22 * B23 + A23 * B33
//
// C31 = A31 * B11 + A32 * B21 + A33 * B31
// C32 = A31 * B12 + A32 * B22 + A33 * B32
// C33 = A31 * B13 + A32 * B23 + A33 * B33
//
