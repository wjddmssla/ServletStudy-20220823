package com.servlet.study.web.servlet.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/addition")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request	.getRequestDispatcher("/WEB-INF/views/board/board_insert.jsp")
				.forward(request, response);
	}
}
