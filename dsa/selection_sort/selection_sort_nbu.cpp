//
// Selection Sort NBU - complexity O(n2)
//

#include <iostream>
using namespace std;

int main() {

		int arr[100], i, j, k, n, min, flag, tmp;

		cout << "Enter the size of array: ";
		cin >> n;

		for(i=1; i<=n; i++) {
				cout << "Enter element " << i << ": ";
				cin >> arr[i];
		}

		for(j=1; j<=n-1; j++) {
				min = arr[j];
				flag = j;

				for(k=j+1; k<=n; k++) {
						if(min > arr[k]) {
								min = arr[k];
								flag = k;
						}
				}

				tmp = arr[j];
				arr[j] = arr[flag];
				arr[flag] = tmp;
		}

		cout << "Sorted: " << endl;

		for(i=1; i<=n; i++) {
				cout << arr[i] << endl;
		}

		return 0;

}

//
// arr[] = { 64 25 12 22 11 }
// 64 25 12 22 11
// 11 25 12 22 64
// 11 12 25 22 64
// 11 12 22 25 64
// 11 12 22 25 64
//
