package org.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SampleServiceTests {

	@Setter(onMethod_ = @Autowired)
	private SampleService service;
	
	@Test
	public void testClass() {
		
		log.info("==testClass== " + service);
		log.info(service.getClass().getName());
		
	}
	
	@Test
	public void testAdd() throws Exception {
		
		log.info("testAdd: " + service.doAdd("123", "456"));
	}
	
	@Test
	public void testAddError() throws Exception {
		
		log.info("testAddError: " + service.doAdd("123", "678"));
	}
	
}
