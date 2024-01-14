package hello.core.beanfind;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import hello.core.AppConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 있으면 중복오류 발생")
    void findBeanByTypeDuplicate(){
        //MemberRepository bean = ac.getBean(MemberRepository.class);
        assertThrows(NoUniqueBeanDefinitionException.class,() -> ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입 조회 시 같은 타입이 둘 이상 있으면, 빈 이름을 지정")
    void findByName(){
        MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("타입 조회 시 같은 타입이 둘 이상 있으면, 빈 이름을 지정")
    void findAllBeanByType(){
        Map<String,MemberRepository> beansOfTypes = ac.getBeansOfType(MemberRepository.class);
        for(String key : beansOfTypes.keySet()){
            System.out.println("Key = " + key + " value = " + beansOfTypes.get(key));
        }
        System.out.println(beansOfTypes);
        assertThat(beansOfTypes.size()).isEqualTo(2);
    }

    @Configuration
    static class SameBeanConfig{
        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }
}
