package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로조회")
    void findBeanByName(){
        MemberService memberSerivce = ac.getBean("memberService",MemberService.class);
        Assertions.assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로조회")
    void findBeanByName2(){
        MemberServiceImpl memberSerivce = ac.getBean("memberService",MemberServiceImpl.class);
        Assertions.assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름없이 타입으로 조회")
    void findBeanByType(){
        MemberService memberSerivce = ac.getBean(MemberService.class);
        Assertions.assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByNoName(){
        //MemberService memberSerivce = ac.getBean("xxxx",MemberService.class);
        //Assertions.assertThat(memberSerivce).isInstanceOf(MemberServiceImpl.class);
        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xxxx",MemberService.class));
    }
}
