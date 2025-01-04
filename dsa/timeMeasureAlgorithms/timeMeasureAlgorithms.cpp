#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <sys/types.h>

using namespace std;

void swap(long int *xp, long int *yp) {
		int tmp = *xp;
		*xp = *yp;
		*yp = tmp;
}


// Bubble Sort
void bubbleSort(long int arr[], int n) {
		int i, j;
		for(i=0; i<n-1; i++)
				for(j=0; j<n-1; j++) 
						if(arr[j] > arr[j+1])
								swap(&arr[j], &arr[j+1]);
}

// Insertion Sort
void insertionSort(long int arr[], int n) {
		int i, j, key;
		
		for(i=1; i<n; i++) {
				key = arr[i];
				j = i - 1;
				while(j>=0 && arr[j] > key) {
						arr[j+1] = arr[j];
						j = j - 1;
				}
				arr[j+1] = key;
		}
}

// Selection Sort
void selectionSort(long int arr[], int n) {
		int i, j, min_idx;
		for(i=0; i<n-1; i++) {
				min_idx = i;
				for(j=i+1; j<n; j++) 
						if(arr[j] < arr[min_idx])
								min_idx = j;
				swap(&arr[min_idx], &arr[i]);
		}
}
	


void printBubble(int arr[], int n) {
		int i;
		
		cout << "Bubble Sort: ";
		for(i=0; i<n; i++)
				cout <<  arr[i] << " ";
		cout << endl;
}

void printInsertion(int arr[], int n) {
		int i;
		cout << "Insertion Sort: ";
		for(i=0; i<n; i++) 
				cout << arr[i] << " ";
		cout  << endl;
}

void printSelection(int arr[], int n) {
		int i; 
		cout << "Selection Sort: ";
		for(i=0; i<n; i++)
				cout <<  arr[i] << " ";
		cout << endl;
}

int main() { 

		time_t t0, t1;
		clock_t c0, c1;
		srand(time(NULL));

		const long int ARRAY_SIZE = 10;
		long int arr[ARRAY_SIZE];
		
		for(int i=0; i<ARRAY_SIZE; i++) {
				arr[i] = rand() % 100 + 1;
		}
		
		t0 = time(NULL);
		c0 = clock();


		// int arr[] = { 3, 2, 5, 1};
		int n = sizeof(arr) / sizeof(arr[0]);
		
	   	bubbleSort(arr, n);
		insertionSort(arr, n);
		selectionSort(arr, n);

		c1 = clock();
		t1 = time(NULL);

		cout << "Ellapsetd wall clock time" << ((long)(t1 - t0)) << endl;
		cout << "Ellapsetd wall clock time" << (float)(c1 - c0) / CLOCKS_PER_SEC << endl;


		printBubble(arr, ARRAY_SIZE);
		printInsertion(arr, ARRAY_SIZE);
		printSelection(arr, ARRAY_SIZE);
	

		return 0;

}
