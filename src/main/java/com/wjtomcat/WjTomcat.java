package com.wjtomcat;

import com.wjtomcat.config.ServletInfo;
import com.wjtomcat.servlet.MyRequest;
import com.wjtomcat.servlet.MyResponse;
import com.wjtomcat.servlet.MyServlet;
import org.apache.commons.lang.StringUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * **Created by wangjia on 2021/9/16.
 */

public class WjTomcat {

    private int port;

    public WjTomcat(int port) {
        this.port = port;
    }

    private Map<String,String> urlMap = new HashMap<String, String>();

    private void initServletInfo(){
        List<ServletInfo> servletInfoList = ServletInfo.servletInfoList;
        for(ServletInfo servletInfo:servletInfoList){
            urlMap.put(servletInfo.getServletUrl(),servletInfo.getServletClass());
        }
    }

    private void start(){
        initServletInfo();
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            while (true){
                System.out.println("等待请求...");
                Socket socket = serverSocket.accept();
                System.out.println("启动成功,监听端口："+port);
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                MyRequest myRequest = new MyRequest(inputStream);
                MyResponse myResponse = new MyResponse(outputStream);

                //分发请求
                forwardRequest(myRequest,myResponse);
                socket.close();

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(serverSocket != null){
                try{
                    serverSocket.close();
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        }
    }

    private void forwardRequest( MyRequest myRequest,MyResponse myResponse){
        try{
            String className = urlMap.get(myRequest.getUrl());
            if(StringUtils.isEmpty(className)){
               return;
            }
            Class<MyServlet> myServletClass = ( Class<MyServlet>)Class.forName(className);
            MyServlet myServlet = myServletClass.newInstance();
            if(myRequest.getMethod().equalsIgnoreCase("POST")){
                myServlet.doPost(myRequest,myResponse);
            }else if(myRequest.getMethod().equalsIgnoreCase("GET")){
                myServlet.doGet(myRequest,myResponse);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WjTomcat tomcat = new WjTomcat(8088);
        tomcat.start();
    }
}
