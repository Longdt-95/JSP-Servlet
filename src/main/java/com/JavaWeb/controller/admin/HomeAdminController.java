package com.JavaWeb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.service.INewsService;
import javaweb.service.iplm.NewService;


@WebServlet(urlPatterns = {"/admin-Home"})
public class HomeAdminController extends HttpServlet {
	private static final long serialVersionUID = 6607820187615822623L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respon) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher ( "/view/admin/Home.jsp");
		rd.forward(request, respon);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	
}
