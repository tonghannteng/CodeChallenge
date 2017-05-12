package com.tengtonghann.android.timeset.presenter;

import com.tengtonghann.android.timeset.main.MainView;
import com.tengtonghann.android.timeset.model.Photo;
import com.tengtonghann.android.timeset.model.service.FlickApi;
import com.tengtonghann.android.timeset.service.MapApiImpl;

import java.util.List;


/**
 * Created by tonghannteng on 5/11/17.
 */

public class MapPresenterImpl implements MapPresenter {

    private final MainView mMainView;
    private final MapApiImpl mMapApiImpl;

    public MapPresenterImpl(MainView mMainView, MapApiImpl mMapApiImpl) {
        this.mMainView = mMainView;
        this.mMapApiImpl = mMapApiImpl;
    }


    @Override
    public void loadFlicksData() {

        mMainView.showProgress();
        mMapApiImpl.getAllFlicks(new FlickApi.FlickServiceCallBack<List<Photo>>(){

            @Override
            public void onSuccess(List<Photo> photo) {
                mMainView.hideProgress();
            }

            @Override
            public void onFailure() {
                mMainView.showConnectionError();
            }
        });
    }
}
