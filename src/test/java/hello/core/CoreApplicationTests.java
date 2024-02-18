package hello.core;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes={AutoAppConfig.class})
class CoreApplicationTests {

	@Test
	void contextLoads() {
	}

}
