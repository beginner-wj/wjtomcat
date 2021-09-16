package com.wjtomcat.servlet;

/**
 * **Created by wangjia on 2021/9/16.
 */

public abstract class MyServlet {
    public abstract void doGet(MyRequest request,MyResponse myResponse);
    public abstract void doPost(MyRequest request,MyResponse myResponse);

    public void service(MyRequest request,MyResponse myResponse){

    }

}
