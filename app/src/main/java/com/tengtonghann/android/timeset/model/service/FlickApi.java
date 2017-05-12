package com.tengtonghann.android.timeset.model.service;

import com.tengtonghann.android.timeset.model.Photo;

import java.util.List;

/**
 * Created by tonghannteng on 5/11/17.
 */

public interface FlickApi {

    interface FlickServiceCallBack<T> {
        void onSuccess(T flicks);

        void onFailure();
    }

    void getAllFlicks(FlickServiceCallBack<List<Photo>> callback);
}
