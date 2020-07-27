package org.spring.service;

import java.util.List;

import org.spring.domain.Criteria;
import org.spring.domain.ReplyPageDTO;
import org.spring.domain.ReplyVO;

public interface ReplyService {

	public int register(ReplyVO vo);

	public ReplyVO get(Long rno);

	public int modify(ReplyVO vo);
	
	public int remove(Long rno);

	public List<ReplyVO> getList(Criteria cri, Long bno);
	
	public ReplyPageDTO getListPage(Criteria cri, Long bno);

}

