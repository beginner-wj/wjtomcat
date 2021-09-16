package com.wjtomcat.config;

import java.util.ArrayList;
import java.util.List;

/**
 * **Created by wangjia on 2021/9/16.
 */

public class ServletInfo {
    private String servletName;
    private String servletUrl;
    private String servletClass;

    public ServletInfo(String servletName, String servletUrl, String servletClass) {
        this.servletName = servletName;
        this.servletUrl = servletUrl;
        this.servletClass = servletClass;
    }

    public String getServletName() {
        return servletName;
    }

    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    public String getServletUrl() {
        return servletUrl;
    }

    public void setServletUrl(String servletUrl) {
        this.servletUrl = servletUrl;
    }

    public String getServletClass() {
        return servletClass;
    }

    public void setServletClass(String servletClass) {
        this.servletClass = servletClass;
    }

    @Override
    public String toString() {
        return "ServletInfo{" +
                "servletName='" + servletName + '\'' +
                ", servletUrl='" + servletUrl + '\'' +
                ", servletClass='" + servletClass + '\'' +
                '}';
    }

    public static List<ServletInfo> servletInfoList = new ArrayList<ServletInfo>();
    static {
        servletInfoList.add(new ServletInfo("Student","/student","com.wjtomcat.servlet.StudentServlet"));
    }
}
