package com.happy.news.domain;

import java.io.Serializable;

/**
 * Created by zhonglongquan on 2017/4/6.
 */

public class News implements Serializable {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
