package hello.servlet.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * MyView 위치는 V3와 공유하기 위해서 FrontController와 같은 위치에 둠
 * MyView
 * 기존의 JSP페이지로의 이동을 렌더링한다고 표현
 */

public class MyView {
    private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    } //view로직을 분리하여 render 메서드를 생성

    /**
     * forEach로 모델의 정보들을 다 꺼내준다.
     *
     * @param model
     * @param req
     * @param resp
     */
    public void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException {
        modelToRequestAttribute(model, req);
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        dispatcher.forward(req , resp);
    }//오버로딩

    private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest req) {
        model.forEach((key, value) -> req.setAttribute(key,value));
        //req에 있는 데이터를 전부 꺼내서 , 모델에 넣어준다.
    }
}
