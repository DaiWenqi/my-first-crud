package firstCrud;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath*:applicationContext.xml")
public class ApplicationTest {
//	@Autowired
	private ApplicationContext applicationContext;
//	@Test
	public void beanNameTest()throws Exception{
		System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
	}
}
