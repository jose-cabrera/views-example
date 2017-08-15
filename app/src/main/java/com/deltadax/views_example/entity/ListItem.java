package com.deltadax.views_example.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.deltadax.views_example.C;

/**
 * Created by JosePablo on 01/08/17.
 * we
 */

public class ListItem implements Parcelable {

    private String name;
    private int state;
    private String image;
    private int points;
    private String descripcion;

    public ListItem(String name) {
        this.name = name;
        this.state = C.state_active;
    }

    public ListItem(String name, int state, String image, int points) {
        this.name = name;
        this.state = state;
        this.image = image;
        this.points = points;
    }

    protected ListItem(Parcel in) {
        name = in.readString();
        state = in.readInt();
        image = in.readString();
        points = in.readInt();
        descripcion = in.readString();
    }

    public static final Creator<ListItem> CREATOR = new Creator<ListItem>() {
        @Override
        public ListItem createFromParcel(Parcel in) {
            return new ListItem(in);
        }

        @Override
        public ListItem[] newArray(int size) {
            return new ListItem[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(state);
        parcel.writeString(image);
        parcel.writeInt(points);
        parcel.writeString(descripcion);
    }
}
