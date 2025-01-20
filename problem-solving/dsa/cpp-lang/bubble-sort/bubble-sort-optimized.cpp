//
// Optimized implementation of Bubble Sort
// Worst and Avarge Case Time Complexity: O(n2). 
// Worst case occurs when array is reverse sorted.
// Best Case Time Complexity: O(n).
// (n) when elements are already sorted.
//

#include <iostream>
using namespace std;

void swap(int *xp, int *yp) {
		int tmp = *xp;
		*xp = *yp;
		*yp = tmp;
}

// An optimized version of Bubble Sort
void bubbleSort(int arr[], int n) {
		int i, j;
		bool swapped;

		for(i=0; i<n-1; i++) {
				swapped = false;
				for(j=0; j<n-i-1; j++) {
						if(arr[j] > arr[j+1]) { 
								swap(&arr[j], &arr[j+1]);
								swapped = true;
						}
				}
				// if no two elements were aswapped by inner loop, then break
				if(swapped == false) break;
		}
}

void printArray(int arr[], int n) {
		int i;
		
		cout << "[ ";
		for(i=0; i<n; i++) 
				cout << arr[i] << " ";
		cout << "]" << endl;
}

int main() {

		int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
		int n = sizeof(arr) / sizeof(arr[0]);

		bubbleSort(arr, n);
		
		cout << "Sorted array: " << endl;

		printArray(arr, n);
		
		return 0;

}
