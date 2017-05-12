package com.tengtonghann.android.timeset.service;

import android.os.AsyncTask;

import com.tengtonghann.android.timeset.R;
import com.tengtonghann.android.timeset.constant.Constant;
import com.tengtonghann.android.timeset.model.Photo;
import com.tengtonghann.android.timeset.model.service.FlickApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonghannteng on 5/11/17.
 */

public class MapApiImpl implements FlickApi {

    public static List<Photo> allPhotos = new ArrayList<>();

    @Override
    public void getAllFlicks(FlickServiceCallBack callback) {
        new LoadFlicksAsyncTask(callback).execute();
    }

    protected class LoadFlicksAsyncTask extends AsyncTask<Void, Void, List<Photo>> {

        private final FlickServiceCallBack mCallBack;

        public LoadFlicksAsyncTask(FlickServiceCallBack callBack) {
            this.mCallBack = callBack;
        }

        @Override
        protected List<Photo> doInBackground(Void... voids) {

            try {
                URL url = new URL(Constant.API_URL);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

                StringBuilder content = new StringBuilder();

                String line;
                while ((line = in.readLine()) != null) {
                    content.append(line);
                }

                JSONObject photos = new JSONObject(content.toString()).getJSONObject(Constant.photos);
                JSONArray photo = photos.getJSONArray(Constant.photo);
                JSONObject object;

                for (int i = 0; i < photo.length(); i++) {

                    object = photo.getJSONObject(i);
                    String title = object.getString(Constant.title);
                    String ownername = object.getString(Constant.ownername);
                    String latitude = object.getString(Constant.latitude);
                    String longitude = object.getString(Constant.longitude);
                    allPhotos.add(new Photo(title, ownername, latitude, longitude));

                }

                return allPhotos;

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Photo> photos) {
            if (photos != null) {
                mCallBack.onSuccess(photos);
            } else {
                mCallBack.onFailure();
            }
        }
    }
}