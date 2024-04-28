package com.ro18767.notepad;


import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class NoteData {

    private UUID id;
    private String header;

    private String content;

    private Date added;

    private Date updated;

    private static final SimpleDateFormat sqlFormat =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    public NoteData(UUID id, String header, String content, Date added, Date updated) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.added = added;
        this.updated = updated;
    }

    public NoteData() {
        this.id = UUID.randomUUID();
        this.header = "";
        this.content = "";
        this.added = new Date();
        this.updated = new Date();
    }

    // factory
    public static NoteData fromJson(JSONObject jsonObject) throws JSONException, ParseException {

        return new NoteData(
                UUID.fromString(jsonObject.getString("id")),
                jsonObject.getString("header"),
                jsonObject.getString("content"),
                sqlFormat.parse(jsonObject.getString("added")),
                sqlFormat.parse(jsonObject.getString("updated"))
        );
    }

    public JSONObject toJson() throws JSONException {
        return new JSONObject()
                .put("id", this.getId().toString())
                .put("header", this.getHeader())
                .put("content", this.getContent())
                .put("added", this.getAdded())
                .put("updated", this.getUpdated());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

}
