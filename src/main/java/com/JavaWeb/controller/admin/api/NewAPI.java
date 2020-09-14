package com.JavaWeb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import javaweb.model.News;
import javaweb.service.INewsService;
import javaweb.utils.HttpUtil;

@WebServlet (urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet{
	long id;
	private static final long serialVersionUID = 136437705597966957L;
	@Inject INewsService newService;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		News news = HttpUtil.of(req.getReader()).toModel(News.class);
		mapper.writeValue(resp.getOutputStream(), news);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doDelete(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPut(req, resp);
	}
}
