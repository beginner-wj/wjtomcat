package com.wjtomcat.servlet;

import java.io.OutputStream;

/**
 * **Created by wangjia on 2021/9/16.
 */

public class MyResponse {
      private OutputStream outputStream;

    public MyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String content){
        try{
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("HTTP/1.1 200 OK\n").append("Content-Type: text/html\n");
            stringBuffer.append("\r\n");
            stringBuffer.append(content);
            outputStream.write(stringBuffer.toString().getBytes());
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
