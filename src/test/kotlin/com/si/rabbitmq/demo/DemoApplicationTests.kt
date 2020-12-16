package com.si.rabbitmq.demo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DemoApplicationTests {

	@Test
	fun contextLoads() {

	}

	@Test
	fun `Sum validation` (){
		val result=9+9
		assertEquals(18, result)
	}

}
