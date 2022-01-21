package com.thiago.noteswebappback.models.enums;

public enum Errors {
    SYSTEM_ERROR("/system-error", "Something went wrong with the system"),
    INVALID_PARAM("/invalid-param", "Invalid Parameter"),
    DATABASE_ERROR("/database-error", "Database Error"),
    RESOURCE_NOTFOUND("/resource-not-found", "Resource not found");

    private String title;
    private String uri;

    public String getUri(){
        return uri;
    }

    public String getTitle(){
        return title;
    }

    Errors(String path, String title) {
        this.uri = "http://localhost:8080" + path;
        this.title = title;
    }
}
