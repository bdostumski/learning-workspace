#include <stdio.h>

#define ROW 5
#define COL 6

#define WALLY '#'
#define EMPTY ' '
#define VISITED '*'
#define EXIT 'X'

void printMaze(char maze[][COL]) {

	for(int i = 0; i < ROW; i++) {
		printf("|");
		for(int j = 0; j < COL; j++) {
			printf(" %c |", maze[i][j]);
		}
		printf("\n");
	}
	printf("\n");
}

bool outOfMaze(char maze[][COL], int row, int col) {
	return row > ROW - 1 || row < 0 || col > COL - 1 || col < 0;
}

void findPath(char maze[][COL], int row, int col) {
	// printMaze(maze);

	if(outOfMaze(maze, row, col)) return;
	if(maze[row][col] == WALLY) return;
	if(maze[row][col] == VISITED) return;

	if(maze[row][col] == EXIT) {
		printf("Exit is found at (%d:%d)\n", row, col);
		printMaze(maze);
		return;
	}

	maze[row][col] = VISITED;

	findPath(maze, row + 1, col);
	findPath(maze, row, col + 1);
	findPath(maze, row, col  - 1);
	findPath(maze, row - 1, col);

	maze[row][col] = EMPTY;
}



bool path(char maze[][COL], int row, int col) {

	if(outOfMaze(maze, row, col)) return false;
	if(maze[row][col] == WALLY) return false;

	if(maze[row][col] == EXIT) {
		printf("Exit is found at (%d:%d)\n", row, col);
		printMaze(maze);
		return true;
	}

	if(maze[row][col] == VISITED) return false;

	maze[row][col] = VISITED;

	return path(maze, row + 1, col) ||
		path(maze, row, col + 1) || 
		path(maze, row, col - 1) ||
		path(maze, row - 1, col);
}

int main() {
			
	char mazeTable[][COL] = {
			{EMPTY, EMPTY, EMPTY, EMPTY, WALLY, EXIT},
			{EMPTY, WALLY, WALLY, EMPTY, WALLY, EMPTY},
			{EMPTY, EMPTY, EXIT, WALLY, WALLY, EMPTY},
			{EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
			{EMPTY, WALLY, WALLY, EMPTY, WALLY, EMPTY},
	};

	printMaze(mazeTable);
	// findPath(mazeTable, 0, 0);
	path(mazeTable, 0, 0);

	return 0;
}

