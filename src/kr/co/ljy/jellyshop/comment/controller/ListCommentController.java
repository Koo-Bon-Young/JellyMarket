//상품평 등록
package kr.co.ljy.jellyshop.comment.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.dao.CommentMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.vo.Comment;

public class ListCommentController extends Controllers {
	private static CommentMapper commentmapper;
	private int selectnum;
	
	public ListCommentController(int selectnum) {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		commentmapper = session.getMapper(CommentMapper.class);
		this.selectnum = selectnum;
		
	}
	public void service() throws Exception {
		System.out.println("*****상품평입니다.*****");
		List<Comment> list = commentmapper.selectCommentlist(selectnum);
		for(Comment c : list) {
			System.out.print("댓글번호 : " + c.getCommentNo()+"\t");
			System.out.println("회원번호 : " + c.getMemberNo()+"\t");
			System.out.print("댓글내용 : " + c.getCommentContent()+"\n");
		}
		if(list == null) {
			System.out.println("상품평이 없습니다.");
		}
		WriteCommentController ctrl = new WriteCommentController(selectnum);
		ctrl.service();
	}

}
