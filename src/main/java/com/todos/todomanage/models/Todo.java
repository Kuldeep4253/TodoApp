package com.todos.todomanage.models;

import java.util.Date;

public class Todo {
    private int id;
    private String title;

    private String Contents;
    private String status;
    private Date addedDate;
    private Date todoDate;

    public Todo(int id, String title, String contents, String status,Date addedDate,Date todoDate) {
        this.id = id;
        this.title = title;
        Contents = contents;
        this.status = status;
        this.todoDate=todoDate;
        this.addedDate=addedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return Contents;
    }

    public void setContents(String contents) {
        Contents = contents;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", Contents='" + Contents + '\'' +
                ", status='" + status + '\'' +
                ", addedDate=" + addedDate +
                ", todoDate=" + todoDate +
                '}';
    }
}
