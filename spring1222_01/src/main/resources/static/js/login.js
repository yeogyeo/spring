/**
 * 
 */

$(function(){
	$("#saveBtn").click(function(){
		//alert("test");
		//alert("아이디 : "+$("#id").val())
		if($("#id").val().length<1){
			alert("아이디를 입력해주세요.");
			$("#id").focus();
			return false;
		}
		loginFrm.submit();
	});
}); 