package com.example.tenten;

import android.graphics.Point;

public class Block {

	/** stores all the blocks that are used in this game. This class imports point
	 * class and utilizes given point class to specify the coordinate of the blocks
	 * unlike tetris tenten doesn't need ghost therefore all the ghost functions are
	 * deprecated. */

	public static final int SIZE = 2;
	public int[][] blockMap;
	private Point pos;

	public Block(int x, int y) {
		blockMap = new int[SIZE][SIZE];
		initBlock(SIZE);
		pos = new Point(x,y);
	}

	private void initBlock(int size) {
		for (int col = 0; col <size; col++) {
			for (int row = 0; row<size; row++){
				blockMap[col][row] = TileView.BLOCK_EMPTY;
			}
		}
	}

	public Point getPos(){
		return pos;
	}

	public void setPos(int x, int y) {

	}
}
