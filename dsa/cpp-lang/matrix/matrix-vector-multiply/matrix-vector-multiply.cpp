//
// Multiply Matrix With Vector
//

#include <iostream>
using namespace std;

int main() {

		int A[3][3] = {
				1, 2, 3,
				4, 5, 6,
				7, 8, 9
		};

		int V[3] = { 1, 2, 3 };
		
		int Va[3] = { 0 };

		for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
						Va[i] += V[i] * A[i][j];
				}
				cout << Va[i] << endl;
		}

		return 0;

}

// 
// A[i][j]
// A11 A12 A13
// A21 A22 A23
// A31 A32 A33
//
// V[i]
// V1
// V2
// V3
//
// Va[i]
// Va1
// Va2
// Va3
//
// Va1 = A11 * V1 + A12 * V1 + A13 * V1
// Va2 = A21 * V2 + A22 * V2 + A23 * V2
// Va3 = A31 * V3 + A32 * V3 + A33 * V3
//
