<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
  <%@ include file="common/meta2.jsp"%>
  <%@ include file="common/taglibs2.jsp"%>
</head>
<script type="text/javascript">
  $(function(){
    //回车事件
    document.onkeydown = function(e){
      var ev = document.all ? window.event : e;
      if(ev.keyCode==13) {
        sub();
      }
    }
  });

  function sub(){
    var loginName = $.trim($("#loginName").val());
    var pwd = $.trim($("#pwd").val());
    if(loginName == ""){
      $("#msg").show();
      $("#msg").html("<i class='iconfont'>&#xe62e;&nbsp;&nbsp;&nbsp;&nbsp;</i>请输入账号");
    }
    else if(pwd == ""){
      $("#msg").show();
      $("#msg").html("<i class='iconfont'>&#xe62e;&nbsp;&nbsp;&nbsp;&nbsp;</i>请输入密码");
    }else{
      var params = {
        "loginName":loginName,
        "pwd":pwd
      };
      $.ajax({
        url:"${pageContext.request.contextPath}/login.json",
        method : 'POST',
        async:false,
        data:params,
        success:function(data){
          if(data.state == "0"){
            location.href = "${pageContext.request.contextPath}/openIndex.html";
          }else {
            $("#msg").show();
            $("#msg").html("<i class='iconfont'>&#xe62e;&nbsp;&nbsp;&nbsp;&nbsp;</i>"+data.msg);
          }
        }
      });
    }
  }
</script>
<body>
<div class="login-hd">
  <div class="left-bg"></div>
  <div class="right-bg"></div>
  <div class="hd-inner">
    <span class="logo"></span>
  </div>
</div>
<div class="login-bd">
  <div class="bd-inner">
    <div class="inner-wrap">
      <div class="lg-zone">
        <div class="lg-box" style="margin-top: 60px;">
          <div class="lg-label"><h4>用户登录</h4></div>
          <div id="msg" class="alert alert-error" style="display: none;">
            <i class="iconfont">&#xe62e;</i>
            <span>请输入用户名</span>
          </div>
          <form>
            <div class="lg-username input-item clearfix">
              <i class="iconfont">&#xe60d;</i>
              <input type="text" id="loginName" name="loginName" placeholder="账号">
            </div>
            <div class="lg-password input-item clearfix">
              <i class="iconfont">&#xe634;</i>
              <input type="password" id="pwd" name="pwd" placeholder="请输入密码">
            </div>
            <div class="enter">
              <a href="javascript:;" class="purchaser" onClick="sub();">登录</a>
            </div>
          </form>
        </div>
      </div>
      <div class="lg-poster"></div>
    </div>
  </div>
</div>
</body>
</html>