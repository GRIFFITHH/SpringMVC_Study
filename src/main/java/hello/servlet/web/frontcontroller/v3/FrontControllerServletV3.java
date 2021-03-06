package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;

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

@WebServlet(name = "frontControllerServletV3",urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3()); // 맵에 담는과정
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("잘작동하는지 테스트");//실제 테스트할땐 Log를 찍자

        String requestURI = req.getRequestURI(); // 요청받은 URI를 저장

        ControllerV3 controller = controllerMap.get(requestURI);
        //다형성에 의해 인터페이스(ControllerV1)로 받음
        //Map에서 해당 URI(Key)를 검색해서 컨트롤러를 가져옴

        if (controller == null) {//없을땐 404 반환
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }


        Map<String, String> paramMap = createParamMap(req);
        //요청받은 req를 조회하여 얻은 파라미터들을 담은 Map
        //이 paraMap을 process 에 넘겨줘야함
        //디테일한 코드는 메서드로 뺴준다.(createParamMap) ctrl + alt + M

        ModelView mv = controller.process(paramMap);
        //paraMap을 받은 process

        String viewName = mv.getViewName();
        //해당 컨트롤러의 논리이름
        MyView view = viewResolver(viewName);
        // 코드의 흐름이 보일수있게끔 메서드화 해서 코드를 줄이자.
        //viewResolver는 MyView에 viewName을 넣어준다.

        view.render(mv.getModel() , req, resp);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest req) {
        Map<String, String> paramMap = new HashMap<>();
        req.getParameterNames().asIterator()//모든 파라미터 네임들을 가져옴
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
        //Key의 변수명은 paramName(임의로 지은이름) , 그리하여 paramMap의 모든 파라미터를 가져옴
        //전체 파라미터를 조회하는 코드
        return paramMap;
    }
}
