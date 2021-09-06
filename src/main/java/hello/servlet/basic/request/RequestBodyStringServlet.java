package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();//요청을 받아 바이트코드로 저장한다.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);//바이트 코드를 문자로 바꿔준다.
        // 바이트를 문자로 바꿀때나 , 문자를 바이트로 바꿀때 인코딩 정보를 알려주어야한다.
        System.out.println("messageBody = " + messageBody);

        resp.getWriter().write("ok"); //ok로 응답
    }
}
