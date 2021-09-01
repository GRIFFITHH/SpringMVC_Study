package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello") // 해당 클래스가 서블릿임을 선언하는 어노테이션
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req -> 요청을 받는다. 브라우저로부터 GET HTTP 메소드를 받음

        System.out.println("HelloServlet.service");
        System.out.println("req = " + req);
        System.out.println("resp = " + resp); // localhost8080/hello 들어가면 콘솔창에 출력된다.

        String username = req.getParameter("username");// 쿼리 파라미터를 받아줌
        System.out.println("username = " + username);
        //resp -> 응답 메서드드
       resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("hello " + username);

    }
}
