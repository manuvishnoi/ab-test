package com.version.ab;

/**
 * Created by gauravvishnoi on 8/31/15.
 */
public class Version {
    private String name;
    private String url;
    private int from;
    private int to;

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    private int actual;

    public Version(String name, String url, int from, int to) {
        this.name = name;
        this.url = url;
        this.from = from;
        this.to = to;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
}
