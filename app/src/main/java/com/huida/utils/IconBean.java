package com.huida.utils;

/**
 * Created by liling on 2017/10/6.
 */

public class IconBean {
    private int iId;
    private String iName;

    public IconBean() {
    }

    public IconBean(int iId, String iName) {
        this.iId = iId;
        this.iName = iName;
    }

    public int getiId() {
        return iId;
    }

    public String getiName() {
        return iName;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }


}
