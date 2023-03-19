package com.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;


import java.util.Iterator;
import java.util.List;
import com.entity.Teacher;
import com.service.TeacherService;

/**
 * Servlet implementation class TeacherController
 */
@WebServlet("/TeacherController")
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherController() {
        super();
        // TODO Auto-generated constructor stub
    }

  //retrieve teacher details
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		
  		PrintWriter pw = response.getWriter();
  		response.setContentType("text/html");
  		TeacherService ts = new TeacherService();
  		List<Teacher> listOfTeacher = ts.findAllTeacher();
  		pw.println("Number of teachers are "+listOfTeacher.size());
  		
  		Iterator<Teacher> ii = listOfTeacher.iterator();
  		while(ii.hasNext()) {
  		    Teacher t = ii.next();
  			pw.println("<div>");
  			pw.println("<t>TeacherID is "+t.getTeacherID()+" TeacherName is "+t.getTeacherName()+"</t>");
  			pw.println("</div>");
  		}
  		
  		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
  		rd.include(request, response);
  		response.setContentType("text/html");
  		
  		
  		
  		
  		
  		
  		
  	}

  	//store teacher details
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		PrintWriter pw = response.getWriter();
  		
  		response.setContentType("text/html");
  		
  		int TeacherID = Integer.parseInt(request.getParameter("TeacherID"));
  		String TeacherName = request.getParameter("TeacherName");
  		
  		Teacher t = new Teacher();
  		t.setTeacherID(TeacherID);
  		t.setTeacherName(TeacherName);
  		
  		
  		TeacherService ts = new TeacherService();
  		String result = ts.addTeacher(t);
  		
  		pw.println(result);
  		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
  		rd.include(request, response);
  		
  	}

  }