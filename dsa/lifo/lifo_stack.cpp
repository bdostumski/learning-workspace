#include <iostream>
using namespace std;

typedef struct Element *po;
struct Element {
    int data;
    po next;
};

int main() {
    po na = NULL;
    po p;
    // po help;

    int x;

    do {
        cout << "Enter number: ";
        cin >> x;
        p = new Element;
        p->data = x;
        p->next = na;
        na = p;
        // help = na;
    } while(x!=0);

    
    while(na!=NULL) { 
        cout << "Stack LIFO: ";   
        cout << na->data << " " << endl;
        na = na->next;
    }
    
    // while(help!=NULL) {
    //     cout << "Echo" << endl;
    //     p = na;
    //     na = na->next;
    //     help = help->next;
    //     delete p;
    // }


    // while(help!=NULL) { 
    //     cout << "Empty LIFO: ";   
    //     cout << na->data << " " << endl;
    //     help = help->next;
    // }

    // cout << na->data;
    // cout << help->data;

    // DELETE FROM STACK
    // p = na;
    // na = na -> next;
    // delete p;

    return 0;

}