package com.udl.android.widgets;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by CarloSergio on 24/03/2017.
 */


public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private int [] images;

    public ImageAdapter(Context c, int[] images) {//se pasa la activity(Layout) y el array de imagenes
        mContext = c;
        this.images = images;
    }

    public int getCount() {
        return images.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(400, 400));
            imageView.setScaleType(ImageView.ScaleType.FIT_END);
            imageView.setPadding(8, 8, 8, 8);

        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(this.images[position]);
        return imageView;
    }

}
