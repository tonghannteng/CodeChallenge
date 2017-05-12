package com.tengtonghann.android.timeset.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.tengtonghann.android.timeset.service.MapApiImpl;
import com.tengtonghann.android.timeset.presenter.MainPresenterImpl;
import com.tengtonghann.android.timeset.main.MainView;
import com.tengtonghann.android.timeset.R;
import com.tengtonghann.android.timeset.presenter.MapPresenterImpl;
import com.tengtonghann.android.timeset.service.SumService;
import com.tengtonghann.android.timeset.data.AllNumbersAsset;

public class MainActivity extends AppCompatActivity implements NumberPadFragment.OnImageInterface, MainView {

    private MainPresenterImpl mMainPresenter;
    private MapPresenterImpl mMapPresenterImpl;
    private TextView textView;
    private int position = 0;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainPresenter = new MainPresenterImpl(this, new SumService());
        mMapPresenterImpl = new MapPresenterImpl(this, new MapApiImpl());
        mMapPresenterImpl.loadFlicksData();
        textView = (TextView) findViewById(R.id.text_result_id);
    }

    @Override
    public void onImageSelected(int position) {

        this.position = position;
        mMainPresenter.clickNumber();

    }

    public void btnClick(View view) {
        mMainPresenter.clickToTheMap();
    }

    @Override
    public void showResultTheResult() {

        double result = new SumService()
                .sumNumber(AllNumbersAsset.getAllNumbers().get(position), 12.61);

        textView.setText(getString(R.string.text_result) + " " + String.valueOf(result));
    }

    @Override
    public void toTheMap() {

        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);

    }

    @Override
    public void showProgress() {
        mProgressBar = (ProgressBar) findViewById(R.id.progressBarId);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar = (ProgressBar) findViewById(R.id.progressBarId);
        mProgressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showConnectionError() {
        mProgressBar = (ProgressBar) findViewById(R.id.progressBarId);
        mProgressBar.setVisibility(View.INVISIBLE);
        Toast.makeText(this, R.string.main_error_connection, Toast.LENGTH_SHORT).show();

    }
}