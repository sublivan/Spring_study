package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass());
//    private final Logger log = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "String";

        System.out.println("name = " + name);

        log.trace(" trace log={}", name);
        log.debug(" debug log={}", name); // 디버그할때, 개발서버에서 보는것이다
        log.info(" info log={}", name); // 중요한정보, 비즈니스로직 정보, 운영시스템에서 봐야될 정보
        log.warn(" warn log={}", name); // 경고, 위험한거다
        log.error(" error log={}", name); // 에러, 에러가 나왔다

        //로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행됨, 이런 방식으로 사용하면 X
        log.debug(" String concat log=" + name);
        return "ok";
    }
}
