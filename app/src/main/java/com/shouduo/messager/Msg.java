package com.shouduo.messager;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by 刘亨俊 on 16.10.20.
 */

public class Msg implements Serializable {

    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;

    private String content;
    private int type;
    private int photoId;
    private Bitmap photo;

    public Msg(String content, int type, Bitmap photo) {
        this.content = content;
        this.type = type;
        this.photo = photo;
    }

    public Msg(String content, int type, int photoId) {
        this.content = content;
        this.type = type;
        this.photoId = photoId;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public int getPhotoId() {
        return photoId;
    }
}
