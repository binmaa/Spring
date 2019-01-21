/*
 * @(#)FirstServlet.java 2019-1-8 下午5:09:42
 * PrcMaven
 * Copyright 2019 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.binmma.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FirstServlet
 * @author mabin
 * @version 1.0
 *
 */
public class FirstServlet extends HttpServlet {
    ThreadLocal l = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            // TODO Auto-generated method stub
            return 1;
        }
    };

    /**
    	 * Destruction of the servlet. <br>
    	 */
    public void destroy() {
        System.out.println("servert...init..修改");
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
    	 * The doDelete method of the servlet. <br>
    	 *
    	 * This method is called when a HTTP delete request is received.
    	 * 
    	 * @param request the request send by the client to the server
    	 * @param response the response send by the server to the client
    	 * @throws ServletException if an error occurred
    	 * @throws IOException if an error occurred
    	 */
    public void doDelete(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        System.out.println();

        // Put your code here
    }

    /**
    	 * The doGet method of the servlet. <br>
    	 *
    	 * This method is called when a form has its tag value method equals to get.
    	 * 
    	 * @param request the request send by the client to the server
    	 * @param response the response send by the server to the client
    	 * @throws ServletException if an error occurred
    	 * @throws IOException if an error occurred
    	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Thread.sleep(1000 * 1);
            int count = ((Integer)(l.get())).intValue();
            System.out.println(count);
            count ++;
            l.set(count);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the GET method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    /**
    	 * The doPost method of the servlet. <br>
    	 *
    	 * This method is called when a form has its tag value method equals to post.
    	 * 
    	 * @param request the request send by the client to the server
    	 * @param response the response send by the server to the client
    	 * @throws ServletException if an error occurred
    	 * @throws IOException if an error occurred
    	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parameter = request.getParameter("key");
        Object attribute = request.getAttribute("key");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the POST method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    /**
    	 * The doPut method of the servlet. <br>
    	 *
    	 * This method is called when a HTTP put request is received.
    	 * 
    	 * @param request the request send by the client to the server
    	 * @param response the response send by the server to the client
    	 * @throws ServletException if an error occurred
    	 * @throws IOException if an error occurred
    	 */
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Put your code here
    }

    /**
    	 * Returns information about the servlet, such as 
    	 * author, version, and copyright. 
    	 *
    	 * @return String information about this servlet
    	 */
    public String getServletInfo() {
        return "This is my default servlet created by Eclipse";
    }

    /**
    	 * Initialization of the servlet. <br>
    	 *
    	 * @throws ServletException if an error occurs
    	 */
    public void init() throws ServletException {
        System.out.println(this.hashCode());
        System.out.println("servert...init..");
    }

}
