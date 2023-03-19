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
import com.entity.Student;
import com.service.StudentService;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
        
    }
      //retrieve student details
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		PrintWriter pw = response.getWriter();
    		response.setContentType("text/html");
    		StudentService ss = new StudentService();
    		List<Student> listOfStudent = ss.findAllStudent();
    		pw.println("Number of students are "+listOfStudent.size());
    		
    		Iterator<Student> ii = listOfStudent.iterator();
    		while(ii.hasNext()) {
    		    Student s = ii.next();
    			pw.println("<div>");
    			pw.println("<s>StudentID is "+s.getStudentID()+" StudentName is "+s.getStudentName()+"</s>");
    			pw.println("</div>");
    		}
    		
    		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    		rd.include(request, response);
    		response.setContentType("text/html");
    		
    		
    		
    		
    		
    		
    		
    	}

    	//store student details
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		PrintWriter pw = response.getWriter();
    		
    		response.setContentType("text/html");
    		
    		int StudentID = Integer.parseInt(request.getParameter("StudentID"));
    		String StudentName = request.getParameter("StudentName");
    		
    		Student s = new Student();
    		s.setStudentID(StudentID);
    		s.setStudentName(StudentName);
    		
    		
    		StudentService ss = new StudentService();
    		String result = ss.addStudent(s);
    		
    		pw.println(result);
    		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    		rd.include(request, response);
    		
    	}

    }