package co.edu.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

@WebServlet("/member")
public class MemberServlet extends HttpServlet { // Servlet: 화면 요청 들어오면 요청한것을 가져와서 보여주는 것.
	private static final long serialVersionUID = 1L;

	public MemberServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 응답정보에 한글처리.
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");

		String cmd = request.getParameter("cmd"); // 파라메타에 cmd를 읽어옴.
		Gson gson = new GsonBuilder().create(); // json 데이터 생성.
		MemberDAO dao = new MemberDAO();

		if (cmd.equals("list")) {
			// 전체 리스트 => json 화면 보여주기.
			List<MemberVO> list = dao.memberList(); // ctrl + shift + o
			response.getWriter().print(gson.toJson(list));

		} else if (cmd.equals("insert")) {
			String name = request.getParameter("name");
			String addr = request.getParameter("addr");

			MemberVO vo = new MemberVO();
			vo.setMembName(name);
			vo.setMembAddr(addr);
			dao.insertMember(vo);
			response.getWriter().print(gson.toJson(vo));
			// http://localhost/formPrj/member?cmd=update&no=9
		} else if (cmd.equals("update")) {
			// 12 - 전화번호 변경.
			String numb = request.getParameter("no"); // 파라메타명 같을 필요 없음.
			String phone = request.getParameter("ph");

			MemberVO vo = new MemberVO();
			vo.setMembNo(Integer.parseInt(numb)); // "12"문자타입 -> 정수
			vo.setMembPhone(phone);

			if (dao.updateMember(vo)) {
				// {"retCod": "Success"}
				response.getWriter().print("{\"retCod\": \"Success\"}");
			} else {
				// {"retCod":"Fail"}
				response.getWriter().print("{\"retCod\":\"Fail\"}");
			}
			// http://localhost/formPrj/member?cmd=delete&delNumber=9
		} else if (cmd.equals("delete")) {
			String delNo = request.getParameter("delNumber");

			if (dao.deleteMember(Integer.parseInt(delNo))) {
				// {"retCod": "Success"}
				response.getWriter().print("{\"retCod\": \"Success\"}");
			} else {
				// {"retCod":"Fail"}
				response.getWriter().print("{\"retCod\":\"Fail\"}");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		// post 방식의 요청이 들어오면 실행 메소드.
		String cmd = request.getParameter("cmd");
		
		String membName = request.getParameter("name");
		String membAddr = request.getParameter("addr");
		String membPhon = request.getParameter("phone");
		String membBirt = request.getParameter("birth");
		String membImag = request.getParameter("image");
		
		MemberVO vo = new MemberVO();
		vo.setMembName(membName);
		vo.setMembAddr(membAddr);
		vo.setMembPhone(membPhon);
		vo.setMemBirth(membBirt);
		vo.setMembImage(membImag);
		
		MemberDAO dao = new MemberDAO();
		
		Gson gson = new GsonBuilder().create();
		
		PrintWriter out = response.getWriter();
		// 1. 입력
		if(cmd.equals("add")) {
			dao.insertMember(vo);
			out.print(gson.toJson(vo)); //vo를 json 타입으로 변경.
			
		//2. 수정
		} else if (cmd.equals("modify")) {
			String mNo = request.getParameter("membNo");
			vo.setMembNo(Integer.parseInt(mNo));
			JsonObject obj = new JsonObject();
			if(dao.updateMember(vo)) {
				// {"membNo": "mNo", "membName": "membName", "membAddr": "membAddr", "membPhone":"membPhon", "membBirth":"membBirt", "retCod": "Success"}
				// {"mNo": ?, "mName":?, "mAddr":?, ...} => object
				//out.print("{\"retCod\": \"Success\"}");
				
//				out.print(" {\"membNo\": \""+mNo+"\", \"membName\": \""+membName
//				+"\", \"membAddr\": \""+membAddr+"\", \"membPhone\":\""+membPhon
//				+"\", \"membBirth\":\""+membBirt+"\", \"retCod\": \"Success\"}");
				
				 // {"name":홍길동, "age":20}
				obj.addProperty("membNo", mNo); // {"membNo": 20}
				obj.addProperty("membName", membName); // {"membNo": 20, "membName": "홍길동"}
				obj.addProperty("membAddr", membAddr);
				obj.addProperty("membPhone", membPhon);
				obj.addProperty("membBirth", membBirt);
				obj.addProperty("retCod", "Success");
				
			} else {
				obj.addProperty("retCod", "Fail");
			}
			out.print(gson.toJson(obj));
			
		// 3. 삭제
		} else if (cmd.equals("remove")) {
			String delNo = request.getParameter("delNo");
			if(dao.deleteMember(Integer.parseInt(delNo))) {
				out.print("{\"retCod\": \"Success\"}");
			} else {
				out.print("{\"retCod\":\"Fail\"}");
			}
			
		}
		
	}

}
