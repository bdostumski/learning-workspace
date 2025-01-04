//
// Find Minimum Value
//

#include <iostream>
using namespace std;

int main() { 

		int arr[] = { 10, 2, 4, 6, 1, 0 };
		int min = arr[0];

		for(int i=0; i<6; i++) {
				if(min>arr[i]) min = arr[i];
		}

		cout << "The minimum value is: " << min << endl;

		return 0;

}
