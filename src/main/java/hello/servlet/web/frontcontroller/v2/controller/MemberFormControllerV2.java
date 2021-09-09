package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * FrontController로 인하여 기존의 Controller를 생성할때마다 중복되는 코드를 줄일 수 있었다.
 * 그리하여 이젠 View로 이동시켜주는 코드만 남은 상태에서 view마저 분리해주었다.
 * MyView라는 클래스를 만들고 render라는 메서드를 생성, 기존의 disPatcher.forword()의 역할을 해주도록하고.
 * 이제 process는 void가 아닌 MyView를 반환시킴으로써 process의 역할이 결국 view를 반환하도록하는 역할도 강제하고
 * 코드도 깔끔해졌다.
 *
 * 여기서 강제란 컴파일단계에서 에러를 잡음으로써 오류를 방지시켜줌
 */

public class MemberFormControllerV2 implements ControllerV2 {

    @Override
    public MyView process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
