<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="../../common/studentMeta.jsp"%>
  <%@ include file="../../common/studentTaglibs.jsp"%>
</head>
<body>
<header>
  <div class="header w">
    <p class="tit">前置学习</p>
    <a href="${pageContext.request.contextPath}/findTeachPlanByStudentId/find.html" class="back icon"></a>
    <a class="next" href="${pageContext.request.contextPath}/findTeachPlanSubjectByTpId/find.html?teachPlanId=${param.teachPlanId}">返回目录</a>
  </div>
</header>
<section class="pm-top-40">
  <div class="auto w bg-f kc-tm-mod">
    <div class="tips-mcc">
      <c:if test="${isRight}">
        <p class="f-20 green">回答正确</p>
      </c:if>
      <c:if test="${!isRight}">
        <p class="f-20 red">回答错误</p>
      </c:if>
      <p>用时 ${timeStr}</p>
    </div>
    <p class="opr-t">
      <c:if test="${empty nextOiId}">
        <a class="btn-com" href="#">答题完成</a>
      </c:if>
      <c:if test="${!empty nextOiId}">
        <a class="btn-com" href="${pageContext.request.contextPath}/doKgt/doing.html?tpsId=${param.tpsId}&oiId=${nextOiId}&sort=${nextSno}&teachPlanId=${param.teachPlanId}">下一题</a>
      </c:if>
    </p>
  </div>
</section>
</body>
</html>
