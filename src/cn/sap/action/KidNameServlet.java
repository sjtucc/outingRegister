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

public class KidNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KidNameServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text;html;charset=utf-8");
		//String kid_name = request.getParameter("kid_name");
		//System.out.println(kid_name);
		String kid_name = new String(request.getParameter("kid_name").getBytes("iso-8859-1"), "utf-8");
		response.setHeader("Content-type","text/html;charset=UTF-8");
	    OutputStream stream = response.getOutputStream();
	    if (kid_name.trim().equals(""))
		    //stream.write("null".getBytes("UTF-8"));
	    	stream.write("".getBytes("UTF-8"));
		else if(kid_name.trim().matches("[\u4E00-\u9FA5]{2,4}"))
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
