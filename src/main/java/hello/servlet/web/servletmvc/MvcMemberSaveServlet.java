package hello.servlet.web.servletmvc;
import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberSaveServlet",urlPatterns = "/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();
    //저장소

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //req객체에 담긴 파라미터를 추출
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        //추출한 값들을 객체화 후 메모리저장소(추후 DB)에 저장
        Member member = new Member(username,age);
        memberRepository.save(member);

        //view에 출력할 데이터를 모델에 보관해야함
        req.setAttribute("member", member); // 1) 리퀘스트 객체에 setAttibute를 이용, 회원의 정보를 담아서

        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(viewPath);
        requestDispatcher.forward(req,resp);// 2) 보내준다.
    }
}
