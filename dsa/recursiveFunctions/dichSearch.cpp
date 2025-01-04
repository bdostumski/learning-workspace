//
// Binary Search (recursive) - complexity O(Log n)
//

#include <iostream>
using namespace std;

// A recursive binary search function. It returns
// location of x in given array arr[l...r] is present,
// otherwise -1 

int binarySearch(int arr[], int l, int r, int x) {
		if (r >= 1) {
				int mid = l + (r - l) / 2;

				// if the elements is present at the middle itself
				if (arr[mid] == x) return mid;

				// if element is smaller then mid, then 
				// it can only be present in left subarray
				if (arr[mid] > x) return binarySearch(arr, l, mid-1, x);

				// else the element can only be present in right subarray
				return binarySearch(arr, mid+1, r, x);
		}

		return -1;
}

int main() {

		int arr[] = { 2, 3, 4, 10, 40 };
		int x = 40;
		int n = sizeof(arr) / sizeof(arr[0]);

		int result = binarySearch(arr, 0, n-1, x);

		(result == -1) ? cout << "Element is not present in array."
				: cout << "Element is present at index: " << result << endl;

		return 0;

}

// We basically ignore half of the lements just after one comparison.
//
// Compare x with the middle element
// If x matches with middle element, we return the mid index.
// Else If x is greater then the mid element, 
// then x can only lie in right half subarray after the mid element.
// So we recur for right half.
// Else (x is smaller) recur for the left half.
//
