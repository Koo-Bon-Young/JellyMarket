package kr.co.ljy.jellyshop.dao;

import java.util.List;

import kr.co.ljy.jellyshop.vo.Qna;

public interface QnaMapper {
	public void insertQna(Qna qna);
	public List<Qna> selectMyQnaList(int no);


}
