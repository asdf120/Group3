package service;

import model.vo.MemberVO;
import model.vo.PurchaseVO;

import java.util.List;

public interface MemberService {
//    public MemberVO idCheck_Login(MemberVO vo);

    public int memberInsert(MemberVO vo );

    public MemberVO memberlogin(MemberVO vo );

    public int memberupdate(MemberVO vo);

    public List<PurchaseVO> memberOrderList(PurchaseVO purchaseVO);

    public int memberDelete(MemberVO membervo);

    public MemberVO memberIdCheck(MemberVO membervo );
}

