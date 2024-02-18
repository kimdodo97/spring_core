package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


class StatefulServiceTest {
    @Test
    void statfuleServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService sc1 = ac.getBean("statefulService",StatefulService.class);
        StatefulService sc2 = ac.getBean("statefulService",StatefulService.class);

        //ThreadA 사용자 A 10000원 주문
        sc1.order("UserA",10000);

        //ThreadB 사용자 B 20000원 주문
        sc2.order("UserB",20000);

        int price = sc1.getPrice();
        Assertions.assertThat(price).isEqualTo(20000);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}