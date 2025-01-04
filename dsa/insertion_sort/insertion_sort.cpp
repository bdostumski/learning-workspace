//
// Insertion Sort - complexity O(n2)
//

#include <iostream>
using namespace std;

void insertionSort(int arr[], int n) {
		int i, j, key;

		for(i=1; i<n; i++) { 
				key = arr[i];
				j = i - 1;

				/* move elements of arr[0...i-1], that are
				 * greater then key, to one position ahead
				 * of their currnet position */
				while(j>=0 && arr[j] > key) {
						arr[j+1] = arr[j];
						j = j - 1;
				}
				arr[j+1] = key;
		}
}

void printArray(int arr[], int n)  {
		int i;

		for(i=0; i<n; i++) 
				cout << arr[i] << " ";
		cout << endl;
}

int main() {
		
		int arr[] = { 4, 3, 2, 10, 12, 1, 5, 6 };
		int n = sizeof(arr) / sizeof(arr[0]);

		insertionSort(arr, n);
		printArray(arr, n);

		return 0;

}

