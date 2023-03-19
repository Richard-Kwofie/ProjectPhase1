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

import com.entity.Grade;
import com.entity.Subject;
import com.service.GradeService;
import com.service.SubjectService;
import com.service.TeacherService;
import com.service.GradeService;



/**
 * Servlet implementation class SubjectController
 */
@WebServlet("/SubjectController")
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectController() {
        super();
        // TODO Auto-generated constructor stub
    }
  //retrieve subject details
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		
  		PrintWriter pw = response.getWriter();
  		response.setContentType("text/html");
  		SubjectService js = new SubjectService();
  		List<Subject> listOfSubject = js.findAllSubject();
  		pw.println("Number of subjects are "+listOfSubject.size());
  		
  		Iterator<Subject> ii = listOfSubject.iterator();
  		while(ii.hasNext()) {
  		    Subject j = ii.next();
  			pw.println("<div>");
  			pw.println("<j>SubjectID is "+j.getSubjectID()+" SubjectName is "+j.getSubjectName()+"</j>");
  			pw.println("</div>");
  		}
  		
  		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
  		rd.include(request, response);
  		response.setContentType("text/html");
  		
  		
  		
  		
  		
  	}

  	//store subject details
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		PrintWriter pw = response.getWriter();
  		
  		response.setContentType("text/html");
  		
  		int SubjectID = Integer.parseInt(request.getParameter("SubjectID"));
  		String SubjectName = request.getParameter("SubjectName");
  		
  		Subject j = new Subject();
  		j.setSubjectID(SubjectID);
  		j.setSubjectName(SubjectName);
  		
  		
  		SubjectService js = new SubjectService();
  		String result = js.addSubject(j);
  		
  		pw.println(result);
  		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
  		rd.include(request, response);
  		
  	}

  }
