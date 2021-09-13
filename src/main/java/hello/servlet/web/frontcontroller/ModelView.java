package hello.servlet.web.frontcontroller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ModelView { //Model 과 View의 역할을 한다. 참고로 스프링 MVC에는 Model&View를 동시에 관장하는 기능이 존재
    private String viewName; // 뷰의 논리적이름을 가져감
    private Map<String, Object> model = new HashMap<>(); // 모델을 가져감

    public ModelView(String viewName) {
        this.viewName = viewName;
    }

    public ModelView(Map<String, Object> model) {
        this.model = model;
    }
}
