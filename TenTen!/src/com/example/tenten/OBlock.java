package com.example.tenten;

public class OBlock extends Block {

	public static final int SIZE = 1;
	private static final int BLOCK_TYPE = TileView.BLOCK_RED; 

	public OBlock(int x, int y) {
		super(x, y);
		initBlock();
	}

	private void initBlock() {
		this.blockMap[0][0]= BLOCK_TYPE;
		this.blockMap[0][1]= BLOCK_TYPE;
		this.blockMap[1][0]= BLOCK_TYPE;
		this.blockMap[1][1]= BLOCK_TYPE;
	}

}