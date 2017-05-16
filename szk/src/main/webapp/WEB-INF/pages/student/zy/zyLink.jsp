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
    <p class="tit">${teachResources.name}</p>
    <a href="javascript:history.go(-1);" class="close icon"></a>
  </div>
</header>
<section class="pm-top-40">
  <div class="auto w bg-f news-text-info">
    <div class="xx-intro">
      ${teachResources.content}
    </div>
  </div>
</section>
</body>
</html>
