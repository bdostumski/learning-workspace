#include <iostream>
using namespace std;

int count = 0;

void merge(int A[], int l, int m, int r) {
		int i, j, k;	
		int n1 = m - l + 1; // begin
		int n2 = r - m; // middle

		// create temp arrays
		int L[n1], R[n2];

		// copy data to temp arrays L[] and R[]
		for(i=0; i<n1; i++)
				L[i] = A[l + i];
		for(j=0; j<n2; j++)
				R[j] = A[m + 1 + j];

		// merge temp arrays into main array
		i = 0;
		j = 0;
		k = l;
		while (i < n1 && j < n2) {
				if(L[i] <= R[j]) {
						A[k] = L[i];
						i++;
						count++;
				} else {
						A[k] = R[j];
						j++;
						count++;
				}
				k++;
		}

		cout << "Count: " << count << endl;
		// copy the remaining elements from L[], if there are any
		while(i < n1) {
				A[k] = L[i];
				i++;
				k++;
		}
		while(j < n2) {
				A[k] = R[j];
				j++;
				k++;
		}
}




void mergeSort(int A[], int l, int r) {
		if(l < r) {
				int m = l + (r - l) / 2;

				mergeSort(A, l, m);
				mergeSort(A, m+1, r);

				merge(A, l, m, r);

		}
}

int main() {

		int A[] = { 7, 8, 0, 5, 0, 3, 2, 4 };
		int n = sizeof(A) / sizeof(A[0]);

		cout << "Unsorted array: " << endl;
		for(int i=0; i<n; i++)
				cout << A[i] << " ";
		cout << endl;

		mergeSort(A, 0, n-1);

		cout << "Sorted array: " << endl;
		for(int i=0; i<n; i++)
				cout << A[i] << " ";
		cout << endl;

		return 0;

}
