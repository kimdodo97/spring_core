package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 ID 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        MemberService memberService1 = appConfig.memberService();

        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberservice1 = " + memberService1);
        System.out.println("memberservice2 = " + memberService2);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 객체 사용 테스트")
    void singletonServiceTest(){
        SingletonService singleService1 = SingletonService.getInstance();
        SingletonService singleService2 = SingletonService.getInstance();


        System.out.println("memberservice1 = " + singleService1);
        System.out.println("memberservice2 = " + singleService2);

        Assertions.assertThat(singleService1).isSameAs(singleService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        AnnotationConfigApplicationContext ax = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ax.getBean("memberService",MemberService.class);

        MemberService memberService2 = ax.getBean("memberService",MemberService.class);

        System.out.println("memberservice1 = " + memberService1);
        System.out.println("memberservice2 = " + memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }

}
