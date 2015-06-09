package com.example.tenten;

import android.app.Activity;
import android.os.Bundle;
import android.R.color;

public class GameActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		
		getWindow().setBackgroundDrawableResource(R.drawable.grid);
		
	}
	
	//TODO override onPause and onStop
	
}
