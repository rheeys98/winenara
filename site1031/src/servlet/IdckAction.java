package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberDTO;

/**
 * Servlet implementation class IdckAction
 */
@WebServlet("/IdckAction")
public class IdckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdckAction() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet IdckAction!");
		
		String id = request.getParameter("ckid");
		System.out.println(id);
		MemberDAO mDao = new MemberDAO();
		int idck = mDao.Login(id);
		int result = 0;
		System.out.println(idck);
		if(idck == 0){
			result = 0;
			
		}else{   
			result = 1;
			
		}
		request.setAttribute("idCount", result);
		request.setAttribute("message", id);
		
		RequestDispatcher dis = request.getRequestDispatcher("idck.jsp");
		dis.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost IdckAction!");
		
		String id = request.getParameter("reid");
		System.out.println(id);
		MemberDAO mDao = new MemberDAO();
		int idck = mDao.Login(id);
		int result = 0;
		System.out.println(idck);
		if(idck == 0){
			result = 0;
			
		}else{   
			result = 1;
			
		}
		request.setAttribute("idCount", result);
		request.setAttribute("message", id);
		
		RequestDispatcher dis = request.getRequestDispatcher("idck.jsp");
		dis.forward(request, response);
	}

}
