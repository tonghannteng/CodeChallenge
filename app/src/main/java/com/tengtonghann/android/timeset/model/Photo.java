package com.tengtonghann.android.timeset.model;

/**
 * Created by tonghannteng on 5/11/17.
 */

public class Photo {

    private String title;
    private String ownername;
    private String latitude;
    private String longitude;


    public Photo(String title, String ownername, String latitude, String longitude) {
        this.title = title;
        this.ownername = ownername;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getTitle() {
        return title;
    }

    public String getOwnername() {
        return ownername;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

}
