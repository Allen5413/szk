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
    <p class="tit">第二阶段 参与课堂讨论</p>
    <a href="${pageContext.request.contextPath}/findTeachPlanByStudentId/find.html" class="back icon"></a>
    <a class="next" href="${pageContext.request.contextPath}/findTeachPlanSubjectByTpId/find.html?teachPlanId=${param.teachPlanId}">返回目录</a>
  </div>
</header>
<section class="pm-top-40">
  <div class="auto w bg-f">
    <dl class="talk-wt-list">
      <c:forEach var="data" items="${list}" varStatus="status">
        <dd>
          <div class="title">${data.name}</div>
          <div class="text">
            ${data.content}
          </div>
        </dd>
      </c:forEach>
    </dl>
  </div>
</section>
</body>
</html>
