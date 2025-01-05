#include <iostream>
using namespace std;

int count = 1;
int count1 = 0;

typedef struct Node *po;
struct Node {
  int data;
  po left;
  po right;
};

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

void OBH(po ukaz) {
  po help = ukaz;
  if (help != NULL) {
    OBH(ukaz->left);
    cout << " " << ukaz->data;
    OBH(ukaz->right);
  }
}

po IBD(int n) {
  cout << "Get number of nodes: " << n << ". ";
  po p;

  int nl = n / 2;
  int nd = n - nl - 1;

  if (n > 0) {
    p = new Node;
    int x;
    cout << "Give node value: ";
    cin >> x;
    p->data = x;
    // ::count++;
    p->left = NULL;
    p->right = NULL;

    p->left = IBD(nl);
    p->right = IBD(nd);

  } else {
    p = NULL;
    cout << "Bottom";
  }
  return p;
}

int main() {
  po p;
  p = IBD(10);
  cout << endl;
  print(p, 2);
  cout << endl;
  OBH(p);
  cout << endl;

  return 0;
}
