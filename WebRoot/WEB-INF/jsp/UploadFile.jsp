<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图片上传</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/uploadFile.action" enctype="multipart/form-data" method="post">
	<input type="file" name="fileupload" value="上传"/>
	<input type="submit" value="提交"/>
</form>

</body>
</html>