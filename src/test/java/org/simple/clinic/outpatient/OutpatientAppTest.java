package org.simple.clinic.outpatient;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OutpatientAppTest {

	@BeforeAll
	static void setup(){
		System.setProperty("java.awt.headless", "false");
	}

}
