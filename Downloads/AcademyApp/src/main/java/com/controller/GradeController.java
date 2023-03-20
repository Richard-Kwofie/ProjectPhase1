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
import com.service.GradeService;

/**
 * Servlet implementation class GradeController
 */
@WebServlet("/GradeController")
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeController() {
        super();
        // TODO Auto-generated constructor stub
        
    }
      //retrieve grade details
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		PrintWriter pw = response.getWriter();
    		response.setContentType("text/html");
    		GradeService ps = new GradeService();
    		List<Grade> listOfGrade = ps.findAllGrade();
    		pw.println("Number of grades are "+listOfGrade.size());
    		
    		Iterator<Grade> ii = listOfGrade.iterator();
    		while(ii.hasNext()) {
    		    Grade g = ii.next();
    			pw.println("<div>");
    			pw.println("<g>GradeID is "+g.getGradeID()+" Section is "+g.getSection()+"</g>");
    			pw.println("</div>");
    		}
    		
    		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    		rd.include(request, response);
    		response.setContentType("text/html");
    		
    		
    		
    		
    		
    		
    		
    	}

    	//store grade details
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		PrintWriter pw = response.getWriter();
    		
    		response.setContentType("text/html");
    		
 //   		int GradeID = Integer.parseInt(request.getParameter("GradeID"));
    		String Section = request.getParameter("Section");
    		
    		Grade g = new Grade();
 //   		g.setGradeID(GradeID);
    		g.setSection(Section);
    		
    		System.out.println("grade is " + g);
    		GradeService gs = new GradeService();
    		String result = gs.addGrade(g);
    		
    		pw.println(result);
    		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    		rd.include(request, response);
    		
    	}

    }