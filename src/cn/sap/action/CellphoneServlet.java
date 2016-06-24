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

public class CellphoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CellphoneServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text;html;charset=utf-8");
		String cellphone = request.getParameter("cellphone");
		//System.out.println(cellphone);
		response.setHeader("Content-type","text/html;charset=UTF-8");
	    OutputStream stream = response.getOutputStream();
		if (cellphone.trim().equals("")) {
			//System.out.println("kong111111111");
		    stream.write("null".getBytes("UTF-8"));
		}
		else if(cellphone.trim().matches("[1]\\d{10}")) {
			//System.out.println("ok11111111");
			stream.write("ok".getBytes("UTF-8"));
		}
		else {
			//System.out.println("cuo11111111");
			stream.write("format error!".getBytes("UTF-8"));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
