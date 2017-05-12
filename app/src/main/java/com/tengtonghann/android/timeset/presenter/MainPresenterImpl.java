package com.tengtonghann.android.timeset.presenter;

import com.tengtonghann.android.timeset.main.MainView;
import com.tengtonghann.android.timeset.service.SumService;

/**
 * Created by tonghannteng on 5/11/17.
 */

public class MainPresenterImpl {

    private MainView mMainView;
    private SumService mSumService;

    public MainPresenterImpl(MainView mainView, SumService sumService) {
        this.mMainView = mainView;
        this.mSumService = sumService;
    }


    public void clickNumber() {
        mMainView.showResultTheResult();
    }

    public void clickToTheMap() {
        mMainView.toTheMap();
    }
}
