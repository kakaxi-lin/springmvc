<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajax.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="common/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" >
		var return_data;
		  $.ajax({
			  url:"ajax/testAjax",
			  data:{"wname":"凯"},
			  dataType:"json",
			  type:"post",
			  async:false,
			  success:function(data){
			      return_data=data;
			      //alert(data[0].wname);
			      console.log(data[0].wname);
			      //alert(data);
			  }
		  });
		  console.log(3333333);
	</script>
  </head>
  
  <body>
    dddddddddddd <br>
  </body>
</html>
