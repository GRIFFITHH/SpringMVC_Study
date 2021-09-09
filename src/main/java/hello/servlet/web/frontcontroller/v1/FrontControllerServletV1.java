package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * urlPatterns -> 해당 클래스가 속한 패키지네임/하위패키지네임/.../호출하고자하는 컨트롤러 네임
 * ' /front-controller/v1/* ' 같은 경우는 v1에 속한 모든 컨트롤러를 매핑하겠다는 의미
 */

@WebServlet(name = "frontControllerServletV1",urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("잘작동하는지 테스트");//실제 테스트할땐 Log를 찍자

        String requestURI = req.getRequestURI(); // 요청받은 URI를 저장

        ControllerV1 controller = controllerMap.get(requestURI); //다형성에 의해 인터페이스(ControllerV1)로 받음
        //Map에서 해당 URI를 검색해서 컨트롤러를 가져옴

        if (controller == null) {//없을땐 404 반환
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controller.process(req, resp); //해당 컨트롤러(Member~ Controller)는 ControllerV1을 상속받음 따라서 process 사용가능
    }
}
