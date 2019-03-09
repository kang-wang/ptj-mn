package com.ptj.pojo;

import java.io.Serializable;

/**
 * @author wh
 * @create 2018-12-14 19:12
 **/
public class Photo  implements Serializable {
    private String url;

    public Photo(String url) {
        this.url = url;
    }
    public Photo() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
