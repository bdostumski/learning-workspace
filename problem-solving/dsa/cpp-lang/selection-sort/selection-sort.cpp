//
// Selection Sort - complexity O(n2)
//

#include <iostream>
using namespace std;

void swap(int *xp, int *yp) {
		int temp = *xp;
		*xp = *yp;
		*yp = temp;
}

void selectionSort(int arr[], int n) {
		int i, j, min_idx;

		// One by one move boundary of unsorted subarray
		for(i=0; i<n-1; i++) {
				// find the minimum element in unsorted array
				min_idx = i;
				for(j=i+1; j<n; j++) 
						if(arr[j] < arr[min_idx])
								min_idx = j;
				// swap the found minimum element with the first element
				swap(&arr[min_idx], &arr[i]);
		}
}

void printArray(int arr[], int n) {
		int i;

		for(i=0; i<n; i++) 
				cout << arr[i] << " ";
		cout << endl;
}

int main() { 

		int arr[] = { 64, 25, 12, 22, 11 };
		int n = sizeof(arr) / sizeof(arr[0]);

		selectionSort(arr, n);

		cout << "Sorted array: ";
		cout << endl;

		printArray(arr, n);

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
