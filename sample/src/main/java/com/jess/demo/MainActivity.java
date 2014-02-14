package com.jess.demo;

import com.jess.ui.R;
import com.jess.ui.TwoWayGridView;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";

	private Cursor mImageCursor;
	private ImageAdapter mAdapter;
	private TwoWayGridView mImageGrid;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initGrid();
	}


	private void initGrid() {
		mImageGrid = (TwoWayGridView) findViewById(R.id.gridview);
        mAdapter = new ImageAdapter(this);
        mImageGrid.setAdapter(mAdapter);
	}
}