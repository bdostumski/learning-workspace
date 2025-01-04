#include <iostream>
using namespace std;

int result;

void euclid(int a, int b) {
   
    if(a % b > 0) {
        euclid(b, a % b);
    } else {
        result = b;
    }   
}

void euclidIn(int a, int b) {

	if(a % b > 0) {
		cout << a << " = " << a / b << " . " << b << " + " << a % b << endl;
		euclidIn(b, a % b);

	} else {
		
		cout << a << " = " << a / b << " . " << b << " + " << a % b << endl;
		
	}
}

void euclidOut(int a, int b) {
    
    if(a % b > 0) {
        euclidOut(b, a % b);
		cout << a << " = " << a / b << " . " << b << " + " << a % b << endl;
    } else {
        cout << a << " = " << a / b << " . " << b << " + " << a % b << endl;
    }
}

int main() {
		
	int a, b;

	cout << "Enter A: ";
	cin >> a;
	cout << "Enter B: ";
	cin >> b;
	
	euclid(a,b);
    cout << endl;
    cout << "Result: " << result;
    cout << endl;
	
    cout << endl;
    cout << "Euclid (IN): " << endl;
	euclidIn(a, b);
	cout << "***********************" << endl;
	cout << "Euclid (OUT): "<< endl;
	euclidOut(a, b);
	

	return 0;

}

