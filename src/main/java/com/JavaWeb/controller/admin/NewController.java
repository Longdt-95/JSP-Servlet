package com.JavaWeb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.model.News;
import javaweb.service.INewsService;

@WebServlet(urlPatterns = { "/admin-list-news" })
public class NewController extends HttpServlet {
	private static final long serialVersionUID = 6607820187615822623L;
	@Inject
	INewsService newService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respon) throws ServletException, IOException {
		News news = new News();
		String page = request.getParameter("page");
		String maxPageItem = request.getParameter("maxPageItem");
		if (page != null) {
			news.setPage((Integer.parseInt(page)));
		}
		if (maxPageItem != null) {
			news.setMaxPageItem(Integer.parseInt(maxPageItem));
		}
		Integer offset = (news.getPage() - 1) * news.getMaxPageItem();
		Integer rowOfPgae = news.getMaxPageItem();
		news.setListResult(newService.findAll(offset, rowOfPgae));
		news.setTotalItem((Integer) newService.getTotalItem());
		news.setTotalpage((int) Math.ceil((double) news.getTotalItem() / news.getMaxPageItem()));
		request.setAttribute("model", news);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/news/list-new.jsp");
		rd.forward(request, respon);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
