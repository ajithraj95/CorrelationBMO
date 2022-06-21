package com.maven.bmo.correlation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CorrelationServlet
 */
@WebServlet("/correlationServlet")
public class CorrelationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CorrelationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String errors = "";
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		FXCorrCalculator calc = new FXCorrCalculator();
		List<Double> results = new ArrayList<Double>();
		try {
			results = calc.getResults(startDate,endDate);
		} catch (Exception e) {
			errors = e.getMessage();
		}
		if(!errors.isEmpty()) { //Error handling if any exception is thrown
			request.setAttribute("error", errors);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/input.jsp");
			dispatcher.include(request, response);
		}else {
			setAttributes(request,results);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
			dispatcher.include(request, response);
		}
	}

	private void setAttributes(HttpServletRequest request, List<Double> results) {
		request.setAttribute("highFX", results.get(0));
		request.setAttribute("lowFX", results.get(1));
		request.setAttribute("meanFX", results.get(2));
		request.setAttribute("highCORRA", results.get(3));
		request.setAttribute("lowCORRA", results.get(4));
		request.setAttribute("meanCORRA", results.get(5));
		request.setAttribute("coefficient", results.get(6));

	}
}