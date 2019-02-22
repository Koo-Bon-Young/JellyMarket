package kr.co.ljy.jellyshop.dao;

import java.util.List;

import kr.co.ljy.jellyshop.vo.Comment;
import kr.co.ljy.jellyshop.vo.Product;

public interface CommentMapper {
	public void insertComment(Comment comment);
	public List<Comment> selectCommentlist(int selectnum);
}
