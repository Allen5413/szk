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
    <%--<p class="tit" style="text-align:center;">马克思主义基本原理概论</p>--%>
    <p class="tit" style="text-align:center;">中国近现代史纲要</p>
    <a href="javascript:history.go(-1);" class="back icon"></a>
  </div>
</header>
<section class="pm-top-40">
  <div class="auto w bg-f">
    <%--<div class="cover"><img src="${pageContext.request.contextPath}/student/images/cover-bc.png"></div>--%>
    <div class="cover"><img src="${pageContext.request.contextPath}/student/images/cover-bc3.png"></div>
    <dl class="catalog">
      <dt class="line-b1">
      <div class="content"><i class="i-log"></i>${teachPlanSubject.name}</div>
      </dt>
      <dd>
        <ul>
          <li><a href="${pageContext.request.contextPath}/doKgt/open.html?tpsId=${teachPlanSubject.id}&teachPlanId=${param.teachPlanId}">第一环节 前置学习（前测）</a></li>
          <li><a href="${pageContext.request.contextPath}/doZy/open.html?tpsId=${teachPlanSubject.id}&teachPlanId=${param.teachPlanId}">第二环节 参与课堂讨论（资源包支持）</a></li>
          <li><a href="${pageContext.request.contextPath}/doZgt/open.html?tpsId=${teachPlanSubject.id}&teachPlanId=${param.teachPlanId}">第三环节 学习巩固与内化（后测与提升）</a></li>
        </ul>
      </dd>
    </dl>
  </div>
</section>
</body>
</html>
