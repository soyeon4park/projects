package com.example.tenten;

import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;


public class TileView extends View {

	protected static final int BLOCK_EMPTY=0; 
	//private static int colorNum=6;

	protected static final int BLOCK_RED = 1;
	protected static final int BLOCK_ORANGE = 2;
	protected static final int BLOCK_YELLOW = 3;
	protected static final int BLOCK_GREEN = 4;
	protected static final int BLOCK_BLUE = 5;
	protected static final int BLOCK_DARKBLUE = 6;
	protected static final int BLOCK_PURPLE = 7;
	
	protected static final int mapToView = 7;
	protected static final int numXTile = 10;
	protected static final int numYTile = 10;
	
	//integer representation of tile at the location it is dropped
	private int[][] tileGrid;

	public TileView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
		
		tileGrid = new int[numXTile][numYTile];
		
	}


	//TODO radomizing color of block -> to be done later
	//	public static int random(){
	//		//select a random integer from 0 to 6. This number assigns colors to the blocks
	//		
	//		Random randomGen = new Random();
	//		int randomNum = randomGen.nextInt(colorNum)+1;
	//		
	//		return randomNum; 
	//	}

}
