package com.java.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.CommandAction;
import com.java.guest.action.GuestDeleteAction;
import com.java.guest.action.GuestUpdateAction;
import com.java.guest.action.GuestWriteAction;
import com.java.guest.action.GuestWriteOkAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> commandMap=new HashMap<String, Object>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   
	@Override
	public void init() throws ServletException {
		GuestWriteAction guestWrite=new GuestWriteAction();
		commandMap.put("/guest/write.do", guestWrite);
		
		GuestWriteOkAction guestWriteOk=new GuestWriteOkAction();
		commandMap.put("/guest/writeOk.do", guestWriteOk);
		
		GuestDeleteAction guestDelete=new GuestDeleteAction();
		commandMap.put("/guest/delete.do", guestDelete);
		
		GuestUpdateAction guestUpdate=new GuestUpdateAction();
		commandMap.put("/guest/update.do", guestUpdate);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getServletPath();
		System.out.println("cmd:"  + cmd);
		
		String viewPage=null;
		try {
			CommandAction command=(CommandAction) commandMap.get(cmd);
			viewPage=command.actionDo(request, response);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		if(viewPage !=null) {
			RequestDispatcher rd=request.getRequestDispatcher(viewPage);
			rd.forward(request, response);
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}











