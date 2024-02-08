package hello.core;

import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class AutoAppConfigTest {
    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService1 = ac.getBean("memberServiceImpl" ,MemberService.class);
        Assertions.assertThat(memberService1).isInstanceOf(MemberService.class);
    }

}