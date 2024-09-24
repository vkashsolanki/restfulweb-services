package com.restapi;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JunitTestingApplicationTests {
	
		private Calculator calculator = new Calculator();

	@Test
	void contextLoads() {
	}
	
	@Test
    void testsums() {
		
		int expectedresult=6;
		
    	int actualresult = calculator.doSum(1, 2, 3);
    	
    	// assert method from assertj
    	assertThat(actualresult).isEqualTo(expectedresult);
    	
    }
	
		@Test
		void testmul() {
			int expetedis=6;
			int actualis = calculator.doMul(3, 2);
			
			//using assert method
			assertThat(actualis).isEqualTo(expetedis);
			
			
		}
		
		@Test
		void comparenums() {
			
			boolean actualvalues = calculator.comparenum(2, 2);
			assertThat(actualvalues).isTrue();
		}
	
	

}
