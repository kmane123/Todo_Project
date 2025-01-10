package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.TodoDAO;
import com.DB.DBConnection;
import com.entity.TodoDtls;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String username=req.getParameter("username");
		String todo=req.getParameter("todo");
		String status=req.getParameter("status");
		
		TodoDAO dao=new TodoDAO(DBConnection.getConnect());
		TodoDtls t=new TodoDtls();
		t.setId(id);
		t.setName(username);
		t.setTodo(todo);
		t.setStatus(status);
		
		boolean f=dao.UpdateTodo(t);
		HttpSession session=req.getSession();
		
		if(f) {
			session.setAttribute("sucMSG", "Todo Updated succesfully");
			resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("failedMSG", "Something error on serverside");
			resp.sendRedirect("index.jsp");
		}
	}

}
