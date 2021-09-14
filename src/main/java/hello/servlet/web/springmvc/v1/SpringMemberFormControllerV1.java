package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller//해당 애노테이션의 역할 두가지 컴포넌트 스캔의 대상이 됨 , 스프링 MVC에서 애노테이션 기반 컨트롤러로 인식하게함
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form") // 요청정보를 매핑한다.
    public ModelAndView process() {
        //ModelAndView는 모델과 뷰를 담아서 반환
        return new ModelAndView("new-form");
    }
}
