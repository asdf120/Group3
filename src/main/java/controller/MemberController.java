package controller;

import model.vo.MemberVO;
import model.vo.PurchaseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.MemberService;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;


    @RequestMapping("/main.ing")
    public void main() {
        System.out.println("메인페이지 이동스");
    }//end  main이동

    @RequestMapping("/memberupdate.ing")
    public void update() {
        System.out.println("회원정보수정 페이지로 이동스");
    }//end  회원정보수정



    @RequestMapping("/login.ing")
    public String test() {
        System.out.println("로그인 요청가나요??");
        return "/login";
    }//end login

    @RequestMapping("/hello.ing")
    public void hello(){
        System.out.println("hello이동하나요????????");
    }//end hello


        @RequestMapping("/logout.ing")
        public String logout(HttpSession session) {
            System.out.println("로그아웃페이지로 이동~~~~");
//            session.removeAttribute("memberName");
            session.invalidate();
            return "/hello";
        }//end logout

        @RequestMapping("/memberjoin.ing")
        public String memberjoin() {
        System.out.println("회원가입페이지로 이동");
        return "/memberjoin";
    }//end memberlogin

    @RequestMapping("/userok.ing")
    public String userok(MemberVO vo, Model m) {
        System.out.println("회원가입 성공페이지로 이동");

        int result = memberService.memberInsert(vo);

        String msguserok = "제대로 된 정보를 입력해주세요";
        if (result > 0) {
            msguserok = vo.getName() + " 님 회원가입 성공ㅇㅇㅇㅇㅇ";
        }
        m.addAttribute("msguserok", msguserok);
        return "/userok";
    }//end userok

        @RequestMapping("/updateok.ing")
        public String updateok(MemberVO vo, Model m){
            System.out.println("회원정보수정 완료페이지~~");
            int result = memberService.memberupdate(vo);

            String msgupdate = vo.getName() + " 님 회원정보가 수정되엇습니다~~~~";
            if (result > 0) {
                msgupdate= vo.getName() + " 님 회원정보가 수정되엇습니다~~~~다시 로그인해주세요~~~~";
            } else {
                msgupdate= vo.getName() + " 님 회원정보가 수정되지 않앗습니다. 다시 시도해주세요.";
            }
            m.addAttribute("msgupdate", msgupdate);
        return "/updateok";

}//end  회원정보수정


    @RequestMapping("/memberlogin.ing")
    public String memberlogin(MemberVO vo, HttpSession session) {
        System.out.println("멤버로그인으로 이동하겟습니다");

        MemberVO result = memberService.memberlogin(vo);


        if (result == null) {
            System.out.println("로그인실패~~~~~");
            return "/memberlogin";

        } else {
            System.out.println("로그인성공~~~~~~");
            session.setAttribute("memberId",result.getId());
            session.setAttribute("memberName", result.getName());
            session.setAttribute("memberPassword", result.getPassword());
            session.setAttribute("memberTel", result.getTel());
            session.setAttribute("memberEmail", result.getEmail());
            session.setAttribute("memberDomain", result.getDomain());
            session.setAttribute("memberAddr1", result.getAddr1());
            session.setAttribute("memberAddr2", result.getAddr2());
            session.setAttribute("memberAddr3", result.getAddr3());
            session.setAttribute("memberGrade", result.getGrade());
            session.setAttribute("memberPoint", result.getPoint());
            return "/hello";
        }
    }//end memberlogin


    @RequestMapping(value = "/orderList.ing")
    public void orderlist(PurchaseVO purchaseVO, Model model){
        System.out.println("주문확인페이지입니다.");
        model.addAttribute("memberOrderList", memberService.memberOrderList(purchaseVO));
//        return "/orderList";
    }
    @RequestMapping(value = "/memberDelete.ing")
    public String memberDelete(MemberVO membervo,HttpSession session){
        System.out.println("회원탈퇴하겟습니다.");
        int result = memberService.memberDelete(membervo);
        session.invalidate();
        return "/hello";
    }

    @RequestMapping(value= "idCheck.ing" ,produces="application/text;charset=utf-8")
    @ResponseBody
    public String idCheck(MemberVO membervo){
        System.out.println("아이디체크 됩니까?????");

        String message = "이미 사용중인 아이디입니다.";
        MemberVO result = memberService.memberlogin(membervo);

        System.out.println(result.getId());

        if(result == null) {
            message="사용 가능한 아이디입니다.";
            System.out.println("아이디찾기성공?");
        }
        System.out.println("아이디찾기실패?");
        return message;
    }
//아이디 1 11 111 1111은 잇고 11111없어서 null나오는데 글씨가안찍힙니다 js문제일까요
    // null 이면 아이디찾기성공? 나오는거 맞지 사용가능한 아이디라고 나와야대는데
//    1 11 111 1111은 사용불가능아이디  값은 받아왓다는건데
}//end MemberController
