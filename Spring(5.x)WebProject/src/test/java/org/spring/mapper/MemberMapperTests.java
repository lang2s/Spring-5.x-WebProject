package org.spring.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.domain.MemberVO;
import org.spring.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberMapperTests {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Test
	public void testRead() {
		
		MemberVO vo = mapper.read("user90");
		
		log.info("vo: " + vo);
		
		vo.getAuthList().forEach(authVO -> log.info("authVO: " + authVO));
	}
}
