//
// Find Maximum Value
//

#include <iostream>
using namespace std;

int main() {

		int arr[] = { 1, 5, 6, 2, 7, 10, 200 };
		int max = arr[0];

		for(int i=0; i<=6; i++) {
				if(max < arr[i]) max = arr[i];
		}

		cout << "The maximum value is: " << max << endl;

		return 0;

}
