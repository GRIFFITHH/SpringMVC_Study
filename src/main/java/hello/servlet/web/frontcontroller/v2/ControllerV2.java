package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * process가 void가 아닌 MyView 타입을 반환하도록 강제성을 부여
 */
public interface ControllerV2 {
    MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
