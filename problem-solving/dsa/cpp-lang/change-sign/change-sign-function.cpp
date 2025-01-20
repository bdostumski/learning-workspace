//
// Change Sign Function
//

#include <iostream>
using namespace std;

int function(int);

int main() {

		for(int i=0; i<10; i++) {
				cout << i << endl;
				cout << function(i) << endl;
		}

		return 0;

}

int function(int j) {
		j = -j;
		return j;
}
