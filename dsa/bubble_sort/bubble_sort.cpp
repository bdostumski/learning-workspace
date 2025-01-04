//
// Bubble Sort - complexity O(n2)
//

#include <iostream>
using namespace std;

void swap(int *xp, int *yp) {
		int temp = *xp;
		*xp = *yp;
		*yp = temp;
}

void bubbleSort(int arr[], int n) {
		int i, j;

		for(i=0; i<n-1; i++) 
				for(j=0; j<n-1; j++) 
						if(arr[j] > arr[j+1])
								swap(&arr[j], &arr[j+1]);
}

void printArray(int arr[], int n) {
		int i;

		for(i=0; i<n; i++) 
				cout << arr[i] << " ";
		cout << endl;
}

int main() { 

		int arr[] = { 5, 1, 4, 2, 8 };
		int n = sizeof(arr) / sizeof(arr[0]);

		bubbleSort(arr, n);

		cout << "Sorted array: " << endl;

		printArray(arr, n);

		return 0;

}

// First Pass:
// (5 1 4 2 8) -> (1 5 4 2 8), Here alorithm compares the first two elements, and swaps since 5 > 1
// (1 5 4 2 8) -> (1 4 5 2 8), Swap 5 > 4
// (1 4 5 2 8) -> (1 4 2 5 8), Swap 5 > 2
// (1 4 2 5 8) -> (1 4 2 5 8), Now, since these elements are already in order (8 > 5), algorithm does not swap them.
//
// Second Pass:
// (1 4 2 5 8) -> (1 4 2 5 8)
// (1 4 2 5 8) -> (1 2 4 5 8), Swap since 4 > 2
// (1 2 4 5 8) -> (1 2 4 5 8)
// (1 2 4 5 8) -> (1 2 4 5 8)
//
// Third Pass:
// (1 2 4 5 8) -> (1 2 4 5 8)
// (1 2 4 5 8) -> (1 2 4 5 8)
// (1 2 4 5 8) -> (1 2 4 5 8)
// (1 2 4 5 8) -> (1 2 4 5 8)
