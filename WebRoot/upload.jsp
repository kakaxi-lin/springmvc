<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>测试springmvc中上传的实现</title>
		<script type="text/javascript">
		function check_img(){
			var a=fom.file;
			var imgSize=fom.file.files[0].size;
			console.log("size..."+imgSize);
			//上传图片要小于 200kb  以byte
			if(imgSize>204800){
				alert("上传图片要小于 200kb");
				return false;
			}
			//上传图片要小于 200kb 
			var aa=fom.file.value;
			var bb=aa.substring(aa.length-3,aa.length);
			bb=bb.toLowerCase();
				if(aa==""){
					alert('请选择要上传的文件');
					return false;
				}
			
				if(bb=="jpg"||bb=="bmp"||bb=="png"){
					return true;
				}else{
					alert('该类型不允许上传');
					return false;
				}
				
		}
		function funsub(){
			fom.action="u?method=upload";
			fom.enctype="multipart/form-data";
			//fom.target="_blank";
			if(check_img()){
				fom.submit();
			}
		}
		</script>
	</head>
	<body>
	<!-- onsubmit="return check_img() -->
		<form method="post" enctype="multipart/form-data" name="fom" >
			<input type="text" name="name" />
			<input type="file" name="file" />
			<input type="button" onclick="funsub()" value="上传图片"/>
		</form>
	</body>
</html>

