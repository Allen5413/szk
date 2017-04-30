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
  <div class="auto w bg-f">
    <dl class="talk-wt-list">
      <dd>
        <div class="title line-b1">${si.name}</div>
        <div class="text">
          ${si.reference}
        </div>
      </dd>
      <dd>
        <div class="text">
          <h5>回答问题：</h5>
          <div class="text-input">
            ${studentAnswer.answer}
          </div>
        </div>
      </dd>
      <dd>
        <div class="text">
          <h5>答案要点：</h5>
          <div class="text-input">
            ${answer.answer}
          </div>
        </div>
      </dd>
    </dl>
  </div>
  <div class="auto w bg-f kc-tm-mod">
    <p class="opr-t">
      <c:if test="${empty nextSiId}">
        <a class="btn-com" href="#">答题完成</a>
      </c:if>
      <c:if test="${!empty nextSiId}">
        <a class="btn-com" href="${pageContext.request.contextPath}/doZgt/doing.html?tpsId=${param.tpsId}&siId=${nextSiId}&sort=${nextSno}&teachPlanId=${param.teachPlanId}">下一题</a>
      </c:if>
    </p>
  </div>
</section>
</body>
</html>
