//상품평 등록
package kr.co.ljy.jellyshop.product.controller;

import org.apache.ibatis.session.SqlSession;

import kr.co.ljy.jellyshop.controller.Controllers;
import kr.co.ljy.jellyshop.controller.LoginUserController;
import kr.co.ljy.jellyshop.controller.MainController;
import kr.co.ljy.jellyshop.controller.UserMainController;
import kr.co.ljy.jellyshop.dao.CommentMapper;
import kr.co.ljy.jellyshop.dao.MemberMapper;
import kr.co.ljy.jellyshop.db.MyAppSqlConfig;
import kr.co.ljy.jellyshop.product.controller.ProductMainController;
import kr.co.ljy.jellyshop.vo.Comment;
import kr.co.ljy.jellyshop.vo.Member;

public class WriteCommentController extends Controllers {
	private CommentMapper commentmapper;
	private MemberMapper memberMapper;
	private int selectnum;

	public WriteCommentController(int selectnum) {
		SqlSession session = MyAppSqlConfig.getSqlSession();
		commentmapper = session.getMapper(CommentMapper.class);
		memberMapper = session.getMapper(MemberMapper.class);
		this.selectnum = selectnum;

	}

	private int choiceMenu() {
		printj("=");
		System.out.println("1. 상품평등록");
		System.out.println("0. 메인으로");
		printj("=");
		return Integer.parseInt(input("번호를 입력하세요 : "));
	}

	public void service() {
		try {
			while (true) {
				switch (choiceMenu()) {
				case 1:
					Member m = memberMapper.selectMemberByNo(LoginUserController.userInfo.getMemberNo());
					System.out.println("*****상품평 등록 화면입니다*****");
					Comment comment = new Comment();
					comment.setProductNo(selectnum);
					comment.setMemberNo(m.getMemberNo());
					comment.setCommentContent(input("댓글 내용을 입력하세요 : "));
					commentmapper.insertComment(comment);
					System.out.println("상품평 등록 성공");
					new UserSearchMain().service();
					break;
				case 0:
					new UserMainController().service();

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}