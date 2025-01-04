//
// Matrix Zero Diagonal
//

#include <iostream>
using namespace std;

int main() { 

		int A[3][3] = {
				1, 2, 3,
				4, 5, 6,
				7, 8, 9
		};

		for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
						if(i == j) A[i][j] = 0;
						cout << A[i][j] << " ";
				}
				cout << endl;
		}

		return 0;

}


// A[i][j]
// 1 2 3
// 4 5 6
// 7 8 9
//
// 0 2 3
// 4 0 6
// 7 8 0
