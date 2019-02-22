package kr.co.ljy.jellyshop.dao;

import kr.co.ljy.jellyshop.vo.Member;

//BoardDAO 개념의 클래스
public interface MemberMapper {
	public void insertMember(Member member);
	public void deleteMember(String memberId);
	public void updateMember(Member member);
	public Member selectMemberByNo(int no);
	public Member selectMemberInfo(Member member);
	
	public Member selectUserlogin(String id);


}









