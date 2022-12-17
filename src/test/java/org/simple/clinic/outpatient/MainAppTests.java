package org.simple.clinic.outpatient;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MainAppTests {

	@BeforeAll
	static void setup(){
		System.setProperty("java.awt.headless", "false");
	}

	@Test
	void contextLoads() {
		
	}

}
