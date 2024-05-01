package com.example.openurl;

public class TableRow {
    private String language;
    private String creator;
    private String reference;

    public TableRow(String language, String creator, String reference) {
        this.language = language;
        this.creator = creator;
        this.reference = reference;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}

