package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes=Configuration.class)
)//이거 하는 이유는 기존의 APpConfig 무시하기 위함
public class AutoAppConfig {

}
