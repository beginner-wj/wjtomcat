package com.wjtomcat.servlet;

import java.io.IOException;
import java.io.InputStream;

/**
 * **Created by wangjia on 2021/9/16.
 */

public class MyRequest {
    private String url;
    private String method;

    public MyRequest(InputStream inputStream) throws IOException {
        String httpRequestStr = "";
        byte[] httpRequestBytes = new byte[1024];
        int length =0;
        if((length = inputStream.read(httpRequestBytes)) > 0){
            httpRequestStr = new String(httpRequestBytes,0,length);
        }
        String requestHead = httpRequestStr.split("\n")[0];
        String url = requestHead.split("\\s")[1];
        String method = requestHead.split("\\s")[0];

        this.method = method;
        this.url = url;

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
