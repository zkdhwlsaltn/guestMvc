package com.java.db;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class DriverInit extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			String jdbcDrvier=config.getInitParameter("jdbcDrvier");
			// System.out.println(jdbcDrvier);
			
			Class.forName(jdbcDrvier);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
