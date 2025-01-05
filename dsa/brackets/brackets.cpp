#include <iostream>
#include <bits/stdc++.h> 
using namespace std; 

bool check(string RegEx) { 
	stack<char> stc; 
	char x; 

	for (unsigned i=0; i<RegEx.length(); i++) {
		if (RegEx[i]=='('||RegEx[i]=='<') { 
			stc.push(RegEx[i]); 
			continue; 
		} 

		if (stc.empty()) return false; 

		switch (RegEx[i]) { 
		case ')': 
			x = stc.top(); 
			stc.pop(); 
			if (x=='<') 
				return false; 
		break; 
		case '>': 
			x = stc.top(); 
			stc.pop(); 
			if (x=='(') 
				return false; 
		break; 
		} 
	} 
	
	return (stc.empty()); 
} 

int main() { 
	string RegEx;
	cout << "<()>(<>): ";
	cin >> RegEx;


    cout << "Contition is: ";
	(check(RegEx)) ? cout << "True" : cout << "False"; 
    cout << endl;

	return 0; 
} 
