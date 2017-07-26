package com.happy.rvdemo.domain;

import java.io.Serializable;

/**
 * Created by zhonglongquan on 2017/4/6.
 */

public class Message implements Serializable {
    public static final int TYPE_SEND = 1;
    public static final int TYPE_RECEIVED = 2;

    private String content;
    private int type;

    public Message(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
