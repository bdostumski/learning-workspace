#include <iostream>
using namespace std;

char board[3][3] = {
		'1', '2', '3', 
		'4', '5', '6', 
		'7', '8', '9' 
};

char player = 'X';

void Move();
void Draw();
void Player();
int Win();

int main() {

		Draw();

		while(1) {
				Move();
				Player();
				Draw();
				if(Win() == 1) {
						cout << "\nThe winner is: X\n\n\n";
						break;
				} else if (Win() == 0) {
						cout << "\nThe winner is: O\n\n\n";
						break;
				} else if (Win() == -1) {
						cout << "\nThe game is REMI\n\n\n";
						break;
				}
		}

		return 0;

}

void Move() { 

		int choice;
		cout << "\nPress the number of the field: ";
		cin >> choice;

		if(choice == 1 && board[0][0] == '1') board[0][0] = player;
		else if (choice == 2 && board[0][1] == '2') board[0][1] = player;
		else if (choice == 3 && board[0][2] == '3') board[0][2] = player;
		else if (choice == 4 && board[1][0] == '4') board[1][0] = player;
		else if (choice == 5 && board[1][1] == '5') board[1][1] = player;
		else if (choice == 6 && board[1][2] == '6') board[1][2] = player;
		else if (choice == 7 && board[2][0] == '7') board[2][0] = player;
		else if (choice == 8 && board[2][1] == '8') board[2][1] = player;
		else if (choice == 9 && board[2][2] == '9') board[2][2] = player;

		Draw();
}

void Player() {

		if(player == 'X') player = 'O';
		else player = 'X';

}

void Draw() {
		
		system("clear");

		cout << "\nTic Tac Toe Game\n\n";
		cout << "Player: " << player << endl;
		cout << endl;

		cout << "\t|_______|_______|_______|\n";
		
		for(int i=0; i<3; i++) {
				cout << "\t|       |       |       |\n";
				cout << "\t|   "; 
				for(int j=0; j<3; j++) {
						cout << board[i][j] << "   |   ";
				}
				cout << "\n\t|_______|_______|_______|\n";
		}

		cout << "\t|       |       |       |\n";
}

// 00 01 02
// 10 11 12
// 20 21 22

int Win() {
		
		// First Player
		if(board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') return 1;
		if (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') return 1;
		if (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') return 1;
		if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') return 1;
		if (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') return 1;
		if (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') return 1;
		if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') return 1;
		if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') return 1;
		
		// Second Player
		if(board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') return 0;
		if (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') return 0;
		if (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') return 0;
		if (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') return 0;
		if (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') return 0;
		if (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') return 0;
		if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') return 0;
		if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') return 0;


		if(board[0][0] != '1' && board[0][1] != '2' && board[0][2] != '3'
						&& board[1][0] != '4' && board[1][1] != '5' && board[1][2] != '6'
						&& board[2][0] != '7' && board[2][1] != '8' && board[2][2] != '9') return -1; 
		return 2;
}
