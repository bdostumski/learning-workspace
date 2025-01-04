//
// Binary Search (iterative) - complexity O(Log n)
//

#include <iostream>
using namespace std;

int binarySearch(int arr[], int l, int r, int x) {

		// A iterative binary search function. It returns
		// location of x in given array arr[l...r] if present,
		// otherwise -1
		while(l <= r) {
				int m = l + (r - l) / 2;

				// check if x is present at mid
				if (arr[m] == x) return m;
				// if x is greater, ignore left half
				if (arr[m] < x) l = m + 1;
				// if x is smaller, ignore right half
				else r = m - 1;
		}

		// if we reach here, then element was not present 
		return -1;

}

int main() { 

		int arr[] = { 2, 3, 4, 10, 40 };
		int x = 40;
		int n = sizeof(arr) / sizeof(arr[0]);

		int result = binarySearch(arr, 0, n-1, x);
		(result == -1) ? cout << "Element is not present in array."
				: cout << "Element is present at index " << result << endl;

		return 0;

}

// We basically ignore half of the elements just after one comparison
//
// Compare x with the middle element.
// If x matches with middle element, we return the mid index.
// Else If x is greater then the mid element, then x can only lie in right half
// subarray after the mid element. So we recur for right half.
// Else (x is smaller) recur for the left half.
