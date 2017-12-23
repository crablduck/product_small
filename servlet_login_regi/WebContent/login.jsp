<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="<%=request.getContextPath()+"/"%>">
</head>
<body>
	<form action="login" method="post" onsubmit="return sub()">
		<input type="hidden" name="action" value="login"/>
		用户名：<input type="text" id="username" name="username"/><span></span><br/>
		密码：<input type="text" id="password" name="password"/><span></span><br/>
		验证码：<input name="checkcode" type="text" placeholder="请输入校验码"/>
		<img src="checkCode" width="120px" height="50px" onclick="changeImg(this)"><br/>
		<input type="submit" value="submit"/>
	</form>
	
<script type="text/javascript">
		
		function sub(){
			//分别得到账户、密码的对象
			var username = document.getElementById("username");
			var password = document.getElementById("password");
			
			//获得span的对象
			var span1 = document.getElementsByTagName("span")[0];
			var span2 = document.getElementsByTagName("span")[1];
			
			span1.innerText = "";
			span2.innerText = "";
			
			var bool = true;//记录是否可提交
			
			//1.验证账户是否为空
			if(username.value.trim() == ""){
				span1.innerText = "账户不能为空";
				bool = false;
			}
			//2.验证密码是否为空
			if(password.value.trim() == ""){
				span2.innerText = "密码不能为空";
				bool = false;
			}
			
			return bool;
		}
	
		function changeImg(obj){
			var date = new Date();
			obj.src = "checkCode?time=" + date.toGMTString();
		}
		
</script>

</body>
</html>