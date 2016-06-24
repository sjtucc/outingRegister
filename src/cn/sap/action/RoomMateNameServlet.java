package cn.sap.action;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class SLDSession
 */

public class RoomMateNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomMateNameServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text;html;charset=utf-8");
		
		String room_mate = new String(request.getParameter("room_mate").getBytes("iso-8859-1"), "utf-8");
		response.setHeader("Content-type","text/html;charset=UTF-8");
	    OutputStream stream = response.getOutputStream();
	    if (room_mate.trim().equals(""))
	
	    	stream.write("".getBytes("UTF-8"));
		else if(room_mate.trim().matches("([Ii]\\d{6}|[Cc]\\d{7})"))
			stream.write("ok".getBytes("UTF-8"));
		else
			stream.write("format error!".getBytes("UTF-8"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
