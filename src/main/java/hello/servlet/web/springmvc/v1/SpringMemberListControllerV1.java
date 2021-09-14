package hello.servlet.web.springmvc.v1;


import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @Controller :
 * 스프링이 자동으로 스프링 빈으로 등록한다. (내부에 @Component 애노테이션이 있어서 컴포넌트
 * 스캔의 대상이 됨)
 * 스프링 MVC에서 애노테이션 기반 컨트롤러로 인식한다.
 * @RequestMapping : 요청 정보를 매핑한다. 해당 URL이 호출되면 이 메서드가 호출된다. 애노테이션을
 * 기반으로 동작하기 때문에, 메서드의 이름은 임의로 지으면 된다.
 * ModelAndView : 모델과 뷰 정보를 담아서 반환하면 된다.
 */

@Controller
public class SpringMemberListControllerV1 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members")
    public ModelAndView process(Map<String, String> paraMap) {
        List<Member> members = memberRepository.findAll();
        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members",members);
        return mv;
    }
}
