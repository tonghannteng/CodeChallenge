package com.tengtonghann.android.timeset;

import com.tengtonghann.android.timeset.main.MainView;
import com.tengtonghann.android.timeset.presenter.MainPresenterImpl;
import com.tengtonghann.android.timeset.service.SumService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by tonghannteng on 5/11/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {


    private MainPresenterImpl mMainPresenter;
    @Mock
    private MainView mMainView;
    @Mock
    private SumService mSumService;

    @Before
    public void setUp() throws Exception {
        mMainPresenter = new MainPresenterImpl(mMainView, mSumService);
    }

    @Test
    public void startSumNumber() throws Exception {
        mMainPresenter.clickNumber();
        verify(mMainView).showResultTheResult();

    }
}
