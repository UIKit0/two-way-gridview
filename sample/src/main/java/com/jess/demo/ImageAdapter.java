package com.jess.demo;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rharter on 2/14/14.
 */
public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mUrls = new ArrayList<>();

    public ImageAdapter(Context context) {
        mContext = context;

        Collections.addAll(mUrls, Data.URLS);
        Collections.shuffle(mUrls);

        // Triple up the list
        ArrayList<String> copy = new ArrayList<>(mUrls);
        mUrls.addAll(copy);
        mUrls.addAll(copy);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SquaredImageView view = (SquaredImageView) convertView;
        if (view == null) {
            view = new SquaredImageView(mContext);
            view.setScaleType(ScaleType.CENTER_CROP);
        }

        String url = getItem(position);

        final float density = mContext.getResources().getDisplayMetrics().density;
        final int imageSize = (int) (100 * density);
        Picasso.with(mContext)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .resize(imageSize, imageSize)
                .into(view);

        return view;
    }

    @Override
    public int getCount() {
        return mUrls.size();
    }

    @Override
    public String getItem(int position) {
        return mUrls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
