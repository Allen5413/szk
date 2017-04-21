<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
  <%@ include file="common/meta2.jsp"%>
  <%@ include file="common/taglibs2.jsp"%>
</head>
<body>
<div class="container">
  <div id="pf-hd" style="background-color: #11B6F4">
    <div class="pf-logo">
      <img src="${pageContext.request.contextPath}/easyui/images/main/main_logo.png" alt="logo">
    </div>

    <div class="pf-user">
      <img src="${pageContext.request.contextPath}/easyui/images/main/user.png"
           style="width:48px;height:48px;border-radius:50px; float: left; margin: 12px 10px 0 0;">
      <h4 class="pf-user-name ellipsis">${name}</h4>
      <i class="iconfont xiala" style="top: 2px;">&#xe607;</i>

      <div class="pf-user-panel">
        <ul class="pf-user-opt">
          <li>
            <a href="javascript:;">
              <i class="iconfont">&#xe60d;</i>
              <span class="pf-opt-name">用户信息</span>
            </a>
          </li>
          <li class="pf-modify-pwd">
            <a href="#" onclick="openEditPwd()">
              <i class="iconfont">&#xe634;</i>
              <span class="pf-opt-name">修改密码</span>
            </a>
          </li>
          <li class="pf-logout">
            <a href="${pageContext.request.contextPath}/logout.html">
              <i class="iconfont">&#xe60e;</i>
              <span class="pf-opt-name">退出</span>
            </a>
          </li>
        </ul>
      </div>
    </div>

  </div>

  <div id="pf-bd">
    <div id="pf-sider">
      <h2 class="pf-model-name">
        <span class="iconfont">&#xe64a;</span>
        <span class="pf-name">组织管理</span>
        <span class="toggle-icon"></span>
      </h2>

      <ul class="sider-nav">
        <c:forEach var="menu" items="${menu}" varStatus="status">
          <li>
            <a href="javascript:;">
              <span class="iconfont sider-nav-icon">&#xe620;</span>
              <span class="sider-nav-title">${menu.key}</span>
              <i class="iconfont">&#xe642;</i>
            </a>
            <ul class="sider-nav-s" style="margin-top: 0px;">
              <c:forEach var="resource" items="${menu.value}" varStatus="status2">
                <c:if test="${resource.isButton==1}">
                  <li onclick="app.addTab('${pageContext.request.contextPath}${resource.url}?resourceId=${resource.id}', '${resource.name}', ${status.index}, ${status2.index}, 0)"><a href="#">${resource.name}</a></li>
                </c:if>
              </c:forEach>
            </ul>
          </li>
        </c:forEach>
      </ul>
    </div>

    <div id="pf-page">
      <div id="tab" class="easyui-tabs1" style="width:100%;height:100%;">
        <div title="首页" style="padding:10px 5px 5px 10px;">
          首页
        </div>
      </div>
    </div>
  </div>

  <div id="pf-ft">
    <div class="system-name">
      <i class="iconfont">&#xe6fe;</i>
      <span>信息管理系统&nbsp;v1.0</span>
    </div>
    <div class="copyright-name">
      <span>CopyRight&nbsp;2017&nbsp;&nbsp;Allen&nbsp;版权所有</span>
      <i class="iconfont" >&#xe6ff;</i>
    </div>
  </div>
</div>

<!--[if IE 7]>
<script type="text/javascript">
  $(window).resize(function(){
    $('#pf-bd').height($(window).height()-76);
  }).resize();

</script>
<![endif]-->


<script type="text/javascript">
  $('.easyui-tabs1').tabs({
    tabHeight: 44
  });

  function openEditPwd(){
    app.openDialog('${pageContext.request.contextPath}/editPwd/open.html', '修改密码', 550, 300, function(index){
      var oldPwd = $("#oldPwd").val();
      var newPwd = $("#newPwd").val();
      var newPwdAgain = $("#newPwdAgain").val();
      if(oldPwd == ""){
        app.msg("请输入旧密码", 1);
        return;
      }
      if(newPwd == ""){
        app.msg("请输入新密码", 1);
        return;
      }
      if(newPwd != newPwdAgain){
        app.msg("新密码不一致", 1);
        return;
      }
      app.edit("${pageContext.request.contextPath}/editPwd/editor.json", $('#editForm').serialize(), index);
    });
  }
</script>
</body>
</html>
