<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>1213 05index 페이지 입니다</h1>
<ul>
<c:if test="${session_id==null}">
<li><strong style="font-size:20px;">로그인을 해주세요</strong></li>
<a href="login"><li>로그인</li></a>
</c:if>

<c:if test="${session_id!=null}">
<li><strong>${session_name} 님 환영합니다.</strong></li>
<a href="logout"><li>로그아웃</li></a>
</c:if>

<a href="bList"><li>공지사항리스트(list)</li></a>
<a href="mInsert"><li>회원가입</li></a>
<br>
<a href="bInsert2"><li>다중업로드</li></a>
<a href="bList2"><li>다중업로드리스트(list)</li></a>
</ul>

</body>
</html>