package com.shouduo.messager;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 刘亨俊 on 16.10.18.
 */

public class People implements Serializable {
    private String name;
    private int id;
    private int image;
    private List<Msg> msgList;

    public People(String name, int id, int image) {
        this.name = name;
        this.id = id;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public List<Msg> getMsgList() {
        return msgList;
    }

    public void setMsgList(List<Msg> msgList) {
        this.msgList = msgList;
    }
}
