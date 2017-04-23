<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="../common/studentMeta.jsp"%>
  <%@ include file="../common/studentTaglibs.jsp"%>
</head>
<body>
<header>
  <div class="header w">
    <p class="tit" style="text-align:center;">上海大学</p>
  </div>
</header>
<section class="pm-top-40">
  <div class="auto w bg-f">
    <div class="cover"><img src="${pageContext.request.contextPath}/easyui/images/loginbg.png"></div>
    <ul class="intro-list">
      <li>
        <div class="itg-1">课程名称：</div>
        <div class="cl-txt">${teachPlan.tpName}</div>
      </li>
      <li>
        <div class="itg-1">授课教师：</div>
        <div class="cl-txt">${teachPlan.uName}</div>
      </li>
      <li>
        <div class="title">学习流程说明:</div>
        <div class="intro">
          <p>1.前置学习：共四道客观题，4月20日之前完成。</p>
          <p>2.参与课堂讨论：给学生提供课堂学习中所需的相关资源。</p>
          <p>3.学习巩固与内化：5月3日前完成答题，提交后由老师评阅。</p>
          <p>4.教师总结并布置课后作业：5月3日前完成答题，提交后由学生互评，互评期限为5月3日-5月8日，每个学生至少评5份。</p>
        </div>
      </li>
    </ul>
    <div class="btn-opr"><a class="btn-com" href="${pageContext.request.contextPath}/findTeachPlanSubjectByTpId/find.html?teachPlanId=${teachPlan.id}">开始学习</a></div>
  </div>
</section>
</body>
</html>