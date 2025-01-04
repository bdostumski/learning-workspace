#include <iostream>
using namespace std;


int partition(int arr[], int left, int right) {
		int l = left; 
		int r = right - 1; 
		
		int eta = arr[right]; 

		do {
				while(arr[l] < eta) l++;
				while(arr[r] > eta) r--;
				if(l <= r) {
						int temp = arr[r];
						arr[r] = arr[l];
						arr[l] = temp;
						l++;
						r--;
				} 
		} while (l<=r);

		int tmp = arr[r+1];
		arr[r+1] = arr[right];
		arr[right] = tmp;
		
		return l; 
}

void qSort(int arr[], int left, int right) {
		int l = left;
		int r = right;
		if(l < r) {
				int pi = partition(arr, l, r);
				 qSort(arr, l, pi - 1);
				 qSort(arr, pi + 1, r);
		}
}


int main() {

		int arr[] = { 8, 9, 1, 11, 3, 4, 6, 5, 7, 2 };

		qSort(arr, 0, 9);

		for(int i=0; i<10; i++) {
				cout << arr[i] << " ";
		}
		
		cout << endl;

		return 0;

}
