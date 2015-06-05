package com.javacodegeeks.android.dragndroptest;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends Activity {

	private ImageView btn1;
	private ImageView btn2;
	private ImageView btn3;
	private LinearLayout left;
	private LinearLayout right;
	private LinearLayout btnSpace;
	private static final String IMAGEVIEW_TAG1 = "Button1";
	private static final String IMAGEVIEW_TAG2 = "Button2";
	private static final String IMAGEVIEW_TAG3 = "Button3";
	private LayoutParams layoutParams;

	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//sets the view to the xml file
		setContentView(R.layout.activity_main);

		//connecting layout widgets and java
		btn1 = (ImageView)findViewById(R.id.btn1);
		btn2 = (ImageView)findViewById(R.id.btn2);
		btn3 = (ImageView)findViewById(R.id.btn3);

		left=(LinearLayout)findViewById(R.id.left);
		right=(LinearLayout)findViewById(R.id.right);
		btnSpace = (LinearLayout)findViewById(R.id.btnspace);

		// Sets the tag
		btn1.setTag(IMAGEVIEW_TAG1);
		btn2.setTag(IMAGEVIEW_TAG2);
		btn3.setTag(IMAGEVIEW_TAG3);

		// set the listener to the dragging data
		btn1.setOnLongClickListener(new MyClickListener());
		btn2.setOnLongClickListener(new MyClickListener());
		btn3.setOnLongClickListener(new MyClickListener());

		left.setOnDragListener(new MyDragListener());
		right.setOnDragListener(new MyDragListener());
		btnSpace.setOnDragListener(new MyDragListener());
	}

	private final class MyClickListener implements OnLongClickListener {

		// called when the item is long-clicked
		@Override
		public boolean onLongClick(View view) {
			// TODO Auto-generated method stub

			// create it from the object's tag
			ClipData.Item item = new ClipData.Item((CharSequence)view.getTag());

			String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
			ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);
			DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

			view.startDrag( data, shadowBuilder, view, 0   );
			view.setVisibility(View.INVISIBLE);

			return true;
		}	
	}


	//Custom drag listener
	class MyDragListener implements OnDragListener {

		@Override
		public boolean onDrag(View v, DragEvent event) {

			// Handles each of the expected events
			switch (event.getAction()) {

			//signal for the start of a drag and drop operation.
			case DragEvent.ACTION_DRAG_STARTED:
				//save original layout

				layoutParams = (LinearLayout.LayoutParams)v.getLayoutParams();

				View viewOriginal = (View) event.getLocalState();
				ViewGroup prevViewGroup=(ViewGroup) viewOriginal.getParent();
				break;

				//the drag point has entered the bounding box of the View
			case DragEvent.ACTION_DRAG_ENTERED:
				break;

				//the user has moved the drag shadow outside the bounding box of the View
			case DragEvent.ACTION_DRAG_EXITED:

				break;

			case DragEvent.ACTION_DRAG_LOCATION:
				break;

				//drag shadow has been released,the drag point is within the bounding box of the View
			case DragEvent.ACTION_DROP:

				//Removes the target from the previous screen
				View view = (View) event.getLocalState();
				ViewGroup viewgroup = (ViewGroup) view.getParent();
				viewgroup.removeView(view);

				//TODO add view to the new view  group but also specify parameter so that it stays at the place that the
				//user dropped the target

				//another method lets adding at certain parameter
				LinearLayout containView = (LinearLayout) v;
				containView.addView(view);
				view.setVisibility(View.VISIBLE);
				break;

				//the drag and drop operation has concluded.
			case DragEvent.ACTION_DRAG_ENDED:

				//background color is gray if the linear layout contains at least one target
				//call method to check the number of child view that the layout has and if it
				//is greater than or equal to 1 then change color
				//this will automatically update every time drag is ended so extra notifier is
				//unnecessary
				View viewLocal = (View) event.getLocalState();
				ViewGroup curViewGroup=(ViewGroup) viewLocal.getParent();

				//TODO color change needs to happen before drag ends since it changes the color of
				//the original layout

				//origLayout.setBackgroudColor(Color.GRAY); 
				//also reverse the button back to the original layout
				//save the original layout and addView to the previous layout

			default:
				break;
			}
			return true;
		}
	}
}