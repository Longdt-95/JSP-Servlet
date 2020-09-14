package com.JavaWeb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.service.ICategoryService;
import javaweb.service.IUserService;
@WebServlet(urlPatterns = {"/trang-chu", "/đăng-nhập"})
public class HomeController extends HttpServlet {
	@Inject
	private ICategoryService categoryService;
	
	//@Inject
	//private INewsService newService;
	
	@Inject
	private IUserService iUserService;
	
	private static final long serialVersionUID = 5108489018697863269L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respon) throws ServletException, IOException {
		request.setAttribute("modelCategory", categoryService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher ( "/view/web/Home.jsp");
		rd.forward(request, respon);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
