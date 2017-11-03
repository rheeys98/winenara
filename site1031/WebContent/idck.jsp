<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#recheck {
		display : none;
	}
</style>
<script src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	function closeOk() {
		opener.document.firminsert.input_pw.focus();
		opener.document.firminsert.ckuid.value = "0";
		opener.document.firminsert.uid2.value = "${message}";
		opener.document.firminsert.input_id.value = "${message}";
		self.close();
		
		
		
	}
	
	/* function closeNg() {
		opener.document.firminsert.input_id.select();
		opener.document.firminsert.ckuid.value = "1";
		
		self.close();
		
	} */
	$(document).on("click", "#reck_bt", function() {
		var re_id = /^[a-z0-9_-]{3,16}$/;
		var id = $.trim($("#reid").val());
		if(id == "") {
			$("#recheck").css("display", "block");
			$("#reck").focus();
			return false;
		} else if ((!re_id.test(id))) {
			$("#recheck").css("display", "block");
			$("#reck").focus();
			return false;
		}
		$("#reck").submit();
		
		
	});
	
</script>
</head>

<body>
	<c:choose>
		<c:when test="${idCount == '0'}">
		${message} 은(는) 사용가능한  id 입니다.
			<button onclick="closeOk()">확인</button>
		</c:when>
		<c:otherwise>
		${message} 중복된  id입니다.<br>
		다른 id를 입력해주세요.
		<form action="IdckAction" id="reck" name="reck" method="post">
			<input type="text" value="${message}"  id="reid" name="reid"> 
			<button id="reck_bt">중복체크</button><br>
			<span id="recheck">잘못된 값을 입력하셨습니다.</span>
			
		</form>	
		</c:otherwise>
	
	</c:choose>

</body>
</html>