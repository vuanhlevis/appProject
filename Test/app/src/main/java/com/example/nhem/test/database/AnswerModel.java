package com.example.nhem.test.database;

import java.io.Serializable;

/**
 * Created by ctrls on 26/09/2017.
 */

public class AnswerModel implements Serializable {
    private int id;
    private String kind;
    private String content;

    public AnswerModel(int id, String kind, String content) {
        this.id = id;
        this.kind = kind;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getKind() {
        return kind;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString(){
        return "StoryModel{" +
                "id=" + id +
                ", kind='" + kind + '\''+
                ", content = '" + content + '\'' +
                '}';
    }
}
