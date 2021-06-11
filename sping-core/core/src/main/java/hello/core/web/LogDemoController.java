package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor //생성자 자동 주입
public class LogDemoController {

    private final LogDemoService logDemoService;
//    private final ObjectProvider<MyLogger> myLoggersProvider;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody //view이름이 아닌, 보내고자하는 문자 그대로 응답보낼 수 있다.
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
//        MyLogger myLogger = myLoggersProvider.getObject();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");

        return "OK";
    }

}
