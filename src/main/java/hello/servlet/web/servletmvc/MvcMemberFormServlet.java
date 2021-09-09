package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 가장 기초적인 모습의 Servlet
 * HttpServletRequest req 객체로 요청을 받고 , HttpServletResponse resp 로 응답을 받는다.
 * JSP에서 회원가입 버튼을 누르면 설정된 URL주소로 인하여 /servlet-mvc/members/new-form 을 요청
 * req를 이용하여 뷰로 이동하도록한다. 이때 viewPath가 필요
 * forword()메서드에 req,resp를 담아서 jsp를 불러온다.
 */

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath); //디스패쳐 -> 컨트롤러에서 뷰로 이동할때 , viewPath로 이동할꺼야
        dispatcher.forward(req,resp); // jsp페이지를 불러오는 코드
    }
}
