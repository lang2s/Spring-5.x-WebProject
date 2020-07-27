package org.spring.service;

import java.util.List;

import org.spring.domain.Criteria;
import org.spring.domain.ReplyPageDTO;
import org.spring.domain.ReplyVO;
import org.spring.mapper.BoardMapper;
import org.spring.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReplyServiceImpl implements ReplyService {

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;

	@Transactional
	@Override
	public int register(ReplyVO vo) {

		log.info("register......" + vo);

		boardMapper.updateReplyCnt(vo.getBno(), 1);

		return mapper.insert(vo);

	}

	@Override
	public ReplyVO get(Long rno) {

		log.info("get......" + rno);

		return mapper.read(rno);

	}

	@Override
	public int modify(ReplyVO vo) {

		log.info("modify......" + vo);

		return mapper.update(vo);

	}

	@Transactional
	@Override
	public int remove(Long rno) {

		log.info("remove...." + rno);

		ReplyVO vo = mapper.read(rno);

		boardMapper.updateReplyCnt(vo.getBno(), -1);
		return mapper.delete(rno);

	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {

		log.info("get Reply List of a Board " + bno);

		return mapper.getListWithPaging(cri, bno);

	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {

		return new ReplyPageDTO(mapper.getCountByBno(bno), mapper.getListWithPaging(cri, bno));
	}

}