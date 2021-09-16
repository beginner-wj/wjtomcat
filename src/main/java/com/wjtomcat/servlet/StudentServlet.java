package com.wjtomcat.servlet;

/**
 * **Created by wangjia on 2021/9/16.
 */

public class StudentServlet extends MyServlet {
    public void doGet(MyRequest request, MyResponse myResponse) {
        System.out.println("do get");
        myResponse.write("do get");
    }

    public void doPost(MyRequest request, MyResponse myResponse) {
        System.out.println("do post");
        myResponse.write("do post");
    }
}
