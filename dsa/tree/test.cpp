#include <iostream>

using namespace std;

typedef int dataT;
typedef struct Node * po;

struct Node {
	dataT data;
	po left;
	po right;
};

po DDP(int n) {
	po durjach;
	dataT x;
	cout << "Number of nodes: " << n << endl;
	if (n > 0)
	{
		int nl = n / 2;
		int nd = n - nl - 1;
		durjach = new Node;
		cout << "Node value: ";
		cin >> x; durjach->data = x;
		durjach->left = DDP(nl);
		durjach->right = DDP(nd);
		return durjach;
	}
	else return NULL;
}


void OBH(po ukz) {
	po help = ukz;
	if (help != NULL) {
		cout << help->data << " ";
		OBH(help->left);
		OBH(help->right);
	
	}
	return;
}

void print(po root, int space) {

	if (root == NULL)
		return;
	int COUNT = 10;
	space += COUNT;
	print(root->right, space);
	cout << " ";
	for (int i = COUNT; i < space; i++)
		cout << " ";
	cout << root->data << "\n";
	print(root->left, space);
}


int main() {
	int n;
	po root;

	cout << "Enter the number of nodes: ";
	cin >> n;
	root = DDP(n);
	print (root,2);
	cout << "obhojdane" << "\n";
	OBH(root);
	system("pause");
}
