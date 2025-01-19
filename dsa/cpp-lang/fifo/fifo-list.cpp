#include <iostream>
using namespace std;

typedef struct Element *po;
struct Element {
    int data;
    po next;
};

int main() {

    po na = NULL;
    po contr; 
    po p;
    int x;

    while(x != 0) {

        cout << "Enter number: ";
        cin >> x;
        
        p = new Element;
        p->data = x;
        p->next = na;

        if(na == NULL || na->data >= x) {
            na = p;
        } else {
            while (p->next != NULL && p->next->data <= x) {
                contr = p->next;
                p->next = p->next->next;
            }
            contr->next = p; 
        }

    }

    while(na != NULL) {
        cout << na->data;
        cout << endl;
        na = na->next;
    }

    return 0;

}


// With DELETE
// #include<iostream>
// using namespace std;
// typedef struct Element *po;
// struct Element {
//     int data;
//     po next;
// };
// int main() {
//     po na = NULL;
//     po p;
//     po contrl;
//     int x;
//     do {
//         cout << "Enter number: ";
//         cin >> x;
//         p = new Element;
//         p->data = x;
//         p->next = na;
//         if(na==NULL || na->data >= x) {
//             na = p;
//         } else {
//             while(p->next!=NULL && p->next->data <= x) {
//                 contrl = p->next;
//                 p->next = p->next->next;
//             }
//             contrl->next = p;
//         }
//     } while(x!=0);
//     while(na!=NULL) {
//         cout << na->data << " ";
//         p = na;
//         na = na->next;
//         delete p;
//     }
//     return 0;
// }


// With help 
// #include <iostream>
// using namespace std;
// typedef struct Element *po;
// struct Element {
//     int data;
//     po next;
// };
// int main() {
//     po na = NULL;
//     po p;
//     po contr;
//     po help;
//     int x;
//     do {
//         cout << "Enter number: ";
//         cin >> x;
//         p = new Element;
//         p->data = x;
//         p->next = na;
//         if(na==NULL || na->data >= x) {
//             na = p;
//         } else {
//             while(p->next!=NULL && p->next->data<=x) {
//                 contr = p->next;
//                 p->next = p->next->next;
//             }
//             contr->next = p;
//         }
//         help = na;
//     } while(x!=0);
//     while(help != NULL) {
//         cout << help->data << " ";
//         help = na->next;
//     }
//     return 0;
// }
