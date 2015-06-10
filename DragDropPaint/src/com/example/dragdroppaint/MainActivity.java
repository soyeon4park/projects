package com.example.dragdroppaint;

import android.app.Activity; 
import android.content.ClipData;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends Activity {

	ImageView img;
	LinearLayout background;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		img = (ImageView) findViewById (R.id.img);
		background=(LinearLayout) findViewById (R.id.background);


		//paint(), invalidate(), getX(), getY()

		img.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					ClipData data = ClipData.newPlainText("", "");
					View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(img);

					img.startDrag(data, shadowBuilder, img, 0);
					img.setVisibility(View.VISIBLE);
					return true;
				}
				else
				{

					return false;

				}
			}

		});

		background.setOnDragListener(new View.OnDragListener(){

			@Override
			public boolean onDrag(View v, DragEvent event) {
				switch(event.getAction())
				{
				case DragEvent.ACTION_DRAG_STARTED:

					// Do nothing
					break;

				case DragEvent.ACTION_DRAG_ENTERED:
					break;

				case DragEvent.ACTION_DRAG_EXITED :
					break;

				case DragEvent.ACTION_DRAG_LOCATION :
					break;

				case DragEvent.ACTION_DRAG_ENDED  :

					v.invalidate();
					// Do nothing
					break;

				case DragEvent.ACTION_DROP:

					//TODO- help! 
					float xcord = event.getX()-img.getWidth()/2;	//account for offset
					float ycord = event.getY()+img.getHeight()/2;

					//Toast.makeText(MainActivity.this, "x coord is"+xcord+" and y coord is "+ycord, Toast.LENGTH_SHORT).show();
 
				
					Canvas canvas = new Canvas();
					Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.big_o); 
					Paint paint = new Paint();
					
					canvas.drawBitmap(image, xcord, ycord, paint);
				
					return true;

				default: break;
				}
				return true;
			}

		});
	}
}
