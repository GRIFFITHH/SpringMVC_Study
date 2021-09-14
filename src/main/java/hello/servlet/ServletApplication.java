package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //서블릿 자동등록 스프링이 자동으로 현재패키지를 뒤져서 서블릿을 찾아서 등록해준다. 첫번째
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) { SpringApplication.run(ServletApplication.class, args);


	}

}
