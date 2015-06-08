package com.example.tenten;

public class BigLBlock extends Block{

	public static final int SIZE = 2;
	public static final int XDIM = 2;	//x dimension of the shape
	public static final int YDIM = 2; 	//y dimension of the shape
	private static final int BLOCK_TYPE = TileView.BLOCK_YELLOW; 

	public BigLBlock(int x, int y){
		super(x, y);
		initBlock();
	}

	//not completely worked out graphics
	//small blocks make up a shape
	/**  ㅁ
	 *   ㅁ
	 *   ㅁㅁㅁ
	 */
	private void initBlock() {
		this.blockMap[0][0]= BLOCK_TYPE;
		this.blockMap[0][1]= BLOCK_TYPE;
		this.blockMap[0][2]= BLOCK_TYPE;
		this.blockMap[1][0]= BLOCK_TYPE;
		this.blockMap[1][1]= 0;
		this.blockMap[1][2]= 0;
		this.blockMap[2][0]= BLOCK_TYPE;
		this.blockMap[2][1]= 0;
		this.blockMap[2][2]= 0;
	}
}
