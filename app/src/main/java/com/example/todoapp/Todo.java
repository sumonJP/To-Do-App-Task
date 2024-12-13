package com.example.todoapp;

public class Todo {
    private int id;
    private String title;
    private String description;
    private String date;
    private String type;
    private String priority;

    public Todo(int id, String title, String description, String date, String type, String priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.type = type;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getPriority() {
        return priority;
    }
}

