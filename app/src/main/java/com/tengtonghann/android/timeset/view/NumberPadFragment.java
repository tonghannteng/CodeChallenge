package com.tengtonghann.android.timeset.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.tengtonghann.android.timeset.R;
import com.tengtonghann.android.timeset.adapter.NumberAdapter;
import com.tengtonghann.android.timeset.data.AllNumbersAsset;

/**
 * Created by tonghannteng on 5/11/17.
 */

public class NumberPadFragment extends Fragment {

    OnImageInterface mCallBack;

    public interface OnImageInterface {
        void onImageSelected(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallBack = (OnImageInterface) context;

        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnImageClickListener");
        }
    }

    public NumberPadFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_gridview, container, false);

        GridView gridView = (GridView) rootView.findViewById(R.id.number_grid_view);

        NumberAdapter adapter = new NumberAdapter(getContext(), AllNumbersAsset.getAllNumbers());

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mCallBack.onImageSelected(position);
            }
        });

        // return root view
        return rootView;
    }
}
