package com.tengtonghann.android.timeset.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tengtonghann.android.timeset.R;

import java.util.List;

/**
 * Created by tonghannteng on 5/11/17.
 */

// Custom adapter class that displays in a GridView
public class NumberAdapter extends BaseAdapter {


    // Keeps track of the context and numbers to display

    private Context mContext;
    private List<Integer> mAllNumbers;
    private LayoutInflater mLayoutInflater;

    public NumberAdapter(Context context, List<Integer> allNumbers) {
        this.mContext = context;
        this.mAllNumbers = allNumbers;
    }

    /**
     * Returns the number of items the adapter will display
     */

    @Override
    public int getCount() {
        return mAllNumbers.size();
    }

    @Override
    public Object getItem(int i) {
        return mAllNumbers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    /**
     * Creates a new TextView for each item referenced by the adapter
     */

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(mContext);
        }

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.number_layout, null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.txtNumberId);
            convertView.setTag(viewHolder);
        }

        if (viewHolder == null) {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(mAllNumbers.get(position).toString());

        return convertView;
    }

    public static class ViewHolder {
        public TextView textView;
    }
}
