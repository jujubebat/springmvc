package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    // @Slf4j이 아래 코드를 자동으로 넣어준다.
    // private final Logger log = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/log-test")
    private String logTest() {
        String name = "Spring";

        // 아래 처럼 로깅하면, 문자열을 더하는 연산이 수행된다. 연산은 메모리와 cpu를 사용한다.
        // 예를들어 로그 레벨이 error여서 trace를 출력하지 않아도, 문자열 더하기 연산이 발생하는 문제가 있다.
        //log.trace("trace my log=" + name);

        // 아래 형식으로 사용하면, 문자열 더하는 연산이 수행되지 않는다. 그냥 파라미터로 넘길 뿐.
        log.trace("trace log={}", name);

        log.debug("debug log={}", name); // 디버그 할때 보는 로그(개발서버에서 보는 것)
        log.info("info log={}", name); // 중요한 비지니스 정보, 운영 시스템에서 봐야할 정보
        log.warn("warn log={}", name); // 경고 위험한것
        log.error("error log={}", name);

        return "ok";
    }

}
