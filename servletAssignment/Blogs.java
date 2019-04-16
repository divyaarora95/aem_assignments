package com.ttn.blogs.core.servlets;

import java.util.Comparator;
import java.util.Date;

public class Blogs {

    private String publish_date;
    private String blog_name;
    private String blog_title;
    private String blog_data;

    public Blogs() { }

    public Blogs(String publish_date, String blog_name, String blog_title, String blog_data) {
        this.publish_date=publish_date;
        this.blog_name=blog_name;
        this.blog_title=blog_data;
        this.blog_data=blog_data;
    }

    public String getPublishDate() {
        return publish_date;
    }

    @Override
    public String toString() {
        return "<br />Publish Date: "+publish_date+"<br />Blog Name: "+blog_name+"<br />Blog Title: "+blog_title+"<br />Blog Data: "+blog_data;
    }
}