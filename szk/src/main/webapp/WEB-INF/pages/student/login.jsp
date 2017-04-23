<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="../common/studentMeta.jsp"%>
  <%@ include file="../common/studentTaglibs.jsp"%>
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
    var studentCode = $.trim($("#studentCode").val());
    if(studentCode == ""){
      alert("请输入学号");
    } else{
      $.ajax({
        url:"${pageContext.request.contextPath}/login.json",
        method : 'POST',
        async:false,
        data:{"studentCode":studentCode},
        success:function(data){
          if(data.state == "0"){
            location.href = "${pageContext.request.contextPath}/findTeachPlanByStudentId/find.html";
          }else {
            alert(data.msg);
          }
        }
      });
    }
  }
</script>
<body>
<header>
  <div class="header w">
    <p class="tit" style="text-align:center;">登录</p>
  </div>
</header>
<section class="pm-top-40">
  <div class="auto w bg-f">
    <div class="logon-view">
      <div class="cover"><img src="${pageContext.request.contextPath}/easyui/images/loginbg.png" /></div>
      <p><input type="text" class="logon-input-txt" placeholder="请输入学号" id="studentCode"></p>
      <p><button class="logon-btn" onclick="sub()">确 定</button></p>
    </div>
  </div>
</section>
</body>
</html>
