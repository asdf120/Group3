function execPostCode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 도로명 조합형 주소 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
                extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }
            // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
            if(fullRoadAddr !== ''){
                fullRoadAddr += extraRoadAddr;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            console.log(data.zonecode);
            console.log(fullRoadAddr);


            $("[name=addr1]").val(data.zonecode);
            $("[name=addr2]").val(fullRoadAddr);

            document.getElementById('addr1').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('addr2').value = fullRoadAddr;

        }
    }).open();
}//end 주소찾기 api
// 이거 우선 중복이당 ㅋㅋ
$(function(){
    //$(document).ready(function(){

        $('select[name=emailSelection]').change(function() {  //여기도 줄쳐져잇는데 셀렉트박스작동댐 응 되긴 될거야
            if($(this).val()=="1"){
                $('#domain').val("");
        } else {
            $('#domain').val($(this).val());
            $("#domain").attr("readonly", true);
                }
        });
       // });  //end $(document).ready(function() 이메일셀렉트박스입력관련.

    $('#userinput').oninvalid(swal('회원정보를 입력해주세요^ㅡ^'));


//     $('#id').keyup(function(){
//         // alert('키업 이벤트 발생'); 오우 여기에 아예 못들어오넹 #id한개박에없어서 댈텐데 오해안대지
//         $.ajax({
//             type : 'post',
//             async : true,
//             url : '/idCheck.ing',  //아에 이게 작동을모함 그러네..
// //슬래시 붙여서인동적없는데 왜안대지 이거 나도 해볼게 지금  다른거 하고있어봐 상연아 ㅋㅋ
    //ㅇㅋ 유효성검사는 다른사람....수고혀
//             contentType : 'application/x-www-form-urlencoded;charset=utf-8',
//             data : {
//                 'id' : $('#id').val() // 보내는 데이터
//             },
//             success : function (result) {
//                 $('#idCheckResult').text(result); // 성공했을 때
//             },
//             error : function (err) {
//                 console.log(err);
//             }
//         });
//     })

}); //end $(function)



