package com.example.tenten;

public class Board {

	//creates a 10x10 board
	public static final int MAP_X_SIZE=10;
	public static final int MAP_Y_SIZE=10;
	private int[][] board;

	//constructor
	public Board(){
		board = new int[MAP_X_SIZE][MAP_Y_SIZE];
		this.resetBoard();
	}

	public void resetBoard(){
		for (int i=0; i<MAP_X_SIZE; i++) {
			for (int j=0; j<MAP_Y_SIZE; j++){
				board[i][j]=0; //BLOCK_EMPTY
			}
		}
	}
	
	//TODO loop needs to be implemented somewhere for automatic update and check

	public boolean putBlockOnBoard(Block shape, int x, int y) {
		//put block iff there's enough space
		//first set drag and drop and get the rounded coordinate of the dropped block
		//if one of board[x][y] != 0 then return to original state
		//two different layout: one for displaying random blocks and another for
		//the board to play on.
		
		//it is either 0 or block type. If block a [x][y] ==block type && block b [x][y] == block type
		//then the block can't be placed in there
		//loop through the square dimension of the shape and condition is when both of the block's have value
		//block type -> otherwise it can fit it
		
		//crate a boolean flag and negate it if desired case is found
		
		//this is just number representation... how to work graphics?
		//imageview?


		return false;
	}

	public void checkLine() {
		boolean isLine1 =true;
		boolean isLine2 = true;
		for (int x=0; x<10; x++) {
			for (int y=0; y<10; y++) {
				if (board[x][y] == TileView.BLOCK_EMPTY) {
					isLine1=false;
				}
				if (board[y][x] == TileView.BLOCK_EMPTY){
					isLine2=false;
				}
			}
			if (isLine1) {
				removeLineHor(x);}
			if (isLine2) {
				removeLineVer(x);}
		}
	}


	//remove horizontal line
	private void removeLineHor(int x) {
		// TODO Auto-generated method stub
		for (int k = 0; k < 10; k++) {
			board[x][k] = TileView.BLOCK_EMPTY;
		}
	}

	//remove vertical line
	private void removeLineVer(int x) {
		// TODO Auto-generated method stub
		for (int k = 0; k < 10; k++) {
			board[k][x] = TileView.BLOCK_EMPTY;
		}
	}
}
