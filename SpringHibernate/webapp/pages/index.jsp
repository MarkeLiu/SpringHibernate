<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String basepath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getLocalPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript"
	src="<%=basepath%>jquery-easyui-1.4.3/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basepath%>jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=basepath%>jquery-easyui-1.4.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=basepath %>/js/util.js"></script>	
<link rel="stylesheet"
	href="<%=basepath%>jquery-easyui-1.4.3/themes/default/easyui.css">
<link rel="stylesheet"
	href="<%=basepath%>jquery-easyui-1.4.3/themes/icon.css">
	
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$("#regest_form").form({
	            url:"/SpringHibernate/user/userAction!addUser.action",
			    onSubmit: function(){
			        //进行表单验证
			        //如果返回false阻止提交
			    },
			    success:function(data){
			    	
			        if (data==true){
			        	$.messager.show({
			        		    title:'注册成功',
			    				msg:'注册成功！',
			    				timeout:5000,
			    				showType:'slide'});
			    		$('#regest_modal').dialog('close');
			    		$('#login_modal').dialog('open');
			        	}else{
			        		$.messager.show({
			        		    title:'注册失败',
			    				msg:'注册失败，请检查参数',
			    				timeout:5000,
			    				showType:'slide'});
			        	}
			    }	
	}
	);
	
	
});
	
function reg(){
	$.messager.confirm('Confirm','是否进行注册？',function(r){
		if(r){
			$('#regest_form').submit();
		}
		});
}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false,split:true"
		style="height: 60px; background: #B3DFDA; padding: 10px">north
		region</div>
	<div data-options="region:'west',border:false,split:true,title:'West'"
		style="width: 150px; padding: 10px;">west content</div>
	<div
		data-options="region:'east',border:false,split:true,collapsed:true,title:'East'"
		style="width: 100px; padding: 10px;">east region</div>
	<div data-options="region:'south',border:false,split:true"
		style="height: 50px; background: #A9FACD; padding: 10px;">south
		region</div>
	<div data-options="region:'center',title:'Center'"></div>

	<!-- 登录部分 -->
	<div class="easyui-dialog" id="login_modal"
		data-options="title:'登陆',modal:true,closable:false,resizable:true,
		buttons:[{text:'注册',iconCls:'icon-edit',handler:function(){
		<!-- $(this).dialog('destory'); -->
		$('#regest_modal').dialog('open');$('#login_modal').dialog('close')}},
		{text:'登陆',menu:'#mm2',iconCls:'icon-ok',handler:function(){alert('login')}}]"
		>
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" id="username" value=""></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" id="password" value=""></td>
			</tr>
			<!-- <tr><td colspan="2" style="text-align: center;"><input type="button" value="注册">&nbsp;&nbsp;<input type="button" value="登陆"></td><td></td></tr> -->
		</table>
	</div>
	<!-- 注册部分 -->
	<div class="easyui-dialog" id='regest_modal'
		data-options="title:'注册',modal:true,closed:true,buttons:[{text:'注册',iconCls:'icon-edit',handler:function(){
		
		
		
		reg();

		}},
		{text:'取消',iconCls:'icon-cancel',handler:function(){
		$('#regest_modal').dialog('close');
		}}]"
		style="width: 300px; height: 150px">
		<form id='regest_form' action="" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input class="easyui-validatebox" data-options="required:true,validType:'length[1,36]'" name="userName" type="text" id="username" value=""></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input class="easyui-validatebox" data-options="required:true,validType:'length[1,20]'" name="passWord" type="password" id="password" value=""></td>
			</tr>
             <tr>
				<td>再次输入密码：</td>
				<td><input  class="easyui-validatebox" data-options="required:true,validType:'pwd[\'#regest_form input[name=passWord]\']'" type="password" id="password" value=""></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>