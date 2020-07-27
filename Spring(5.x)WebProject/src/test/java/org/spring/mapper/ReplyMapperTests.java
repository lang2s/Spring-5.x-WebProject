package org.spring.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.spring.domain.Criteria;
import org.spring.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTests {

	private Long[] bnoArr = {4587736L, 4587735L, 4587734L, 4587733L, 4587732L};
	
	@Setter(onMethod_ = {@Autowired})
	private ReplyMapper mapper;
	
	@Test
	public void testCreate() {
		
		IntStream.range(1, 10).forEach(i -> {
		
		ReplyVO vo = new ReplyVO();
		
		vo.setBno(bnoArr[i % 5]);
		vo.setReply("댓글 테스트" + i);
		vo.setReplyer("replyer" + i);
		
		mapper.insert(vo);
		
		});
	}
	
	@Test
	public void testRead() {
		
		Long targetRno = 5L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		log.info("====testRead====" + vo);
	}
	
	@Test
	public void testDelete() {
		
		Long targetRno = 1L;
		
		mapper.delete(targetRno);
	}
	
	@Test
	public void testUpdate() {
		
		Long targetRno = 10L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		vo.setReply("Update Reply ");
		
		int count = mapper.update(vo);
		
		log.info("UPDATE COUNT: " + count);
	}
	
	@Test
	public void testList() {
		
		Criteria cri = new Criteria();
		
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
		
		replies.forEach(reply -> log.info("====testList====" + reply));
	}
	
	@Test
	public void testMapper() {
		log.info("====testMapper====" + mapper);
	}
	
	@Test
	public void testList2() {
		
		Criteria cri = new Criteria(2, 10);
		
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 4587736L);
		
		replies.forEach(reply -> log.info("====testList2====" + reply));
	}
	
	
	
}
