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

public class PartnerCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartnerCardServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text;html;charset=utf-8");
		String partner_card = request.getParameter("partner_card");
		//System.out.println(partner_card);
		response.setHeader("Content-type","text/html;charset=UTF-8");
		OutputStream stream = response.getOutputStream();
		if (partner_card.trim().equals(""))
		    //stream.write("null".getBytes("UTF-8"));
			stream.write("".getBytes("UTF-8"));
		else if(partner_card.trim().matches("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])") || partner_card.trim().matches("[0-9a-zA-Z]{9}"))
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
