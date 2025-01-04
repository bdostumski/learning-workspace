#include <iostream>
#include <string>
using namespace std;


int partition(int arr[], int left, int right, string text) {
	
	cout << "\nКопие, граници на дела от " << left << " до " << right << endl;
	
	int l = left; 
	int r = right - 1; 
	
	int eta = arr[right]; 
	cout << "Еталон: " << eta << endl;
	
	do {				
			while(arr[l] < eta) l++;
			while(arr[r] > eta) r--;

			if(l <= r) {
					cout << "\tРазмяна на: " << arr[l] << " и " << arr[r] << endl; 
					int temp = arr[r];
					arr[r] = arr[l];
					arr[l] = temp;
					l++;
					r--;
					cout << "\tДъно" << endl;
			} 
			cout << "\tИзплуване" << endl;
	} while (l<=r);

	int tmp = arr[r+1];
	arr[r+1] = arr[right];
	arr[right] = tmp;

	cout << "\tРазмяна на: " << arr[right] << " и " << arr[r+1] << endl; 

	cout << "\tКрай на размените" << endl;
	cout << text << endl;

	return l; 
}

void qSort(int arr[], int left, int right, string text) {
		int l = left;
		int r = right;
        string lDown = "Потъване наляво";
        string rDown = "Потъване надясно";


		if(l < r) {
				int pi = partition(arr, l, r, text);
				 qSort(arr, l, pi - 1, lDown);
				 qSort(arr, pi + 1, r, rDown);

		}
}


int main() {

		int arr[] = { 20, 2, 1, 5, 10, 6, 7, 20, 50, 11, 32, 68, 33, 66, 55, 9, 3, 7, 3, 3, 8, 8, 1, 2, 1, 4 };
		// int arr[] = { 93, 7, 3, 38, 8, 1,  2 };

        string text = "";

        cout << "Начално състояние на масива: ";
		for(int i=0; i<26; i++) {
		// for(int i=0; i<7; i++) {
			cout << arr[i] << " ";
		}
		cout << endl;
		

		qSort(arr, 0, 25, text);
		// qSort(arr, 0, 6, text);

		cout << "Крайно състояние на масива : ";
		for(int i=0; i<26; i++) {
		// for(int i=0; i<7; i++) {
				cout << arr[i] << " ";
		}
		
		cout << endl;

		return 0;

}
