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
    <p class="tit">后置学习</p>
    <a href="${pageContext.request.contextPath}/findTeachPlanByStudentId/find.html" class="back icon"></a>
    <a class="next" href="${pageContext.request.contextPath}/findTeachPlanSubjectByTpId/find.html?teachPlanId=${param.teachPlanId}">返回目录</a>
  </div>
</header>
<section class="pm-top-40">
  <div class="auto w kc-tm-list">
    <div class="intro">
      <div class="title">习题说明</div>
      <p>1.	该部分共五道习题，均为主观题；</p>
      <p>2.	请同学们认真作答，系统将自动保存记录。</p>
    </div>
    <ul class="list-tm">
      <c:forEach var="data" items="${list}" varStatus="status">
        <li>
          <div class="flex-cel">
            <div class="tm-ig">第${status.index+1}题</div>
            <div class="cl-txt">
              <c:if test="${empty data.time}">
                <a class="btn" href="${pageContext.request.contextPath}/doZgt/doing.html?tpsId=${param.tpsId}&siId=${data.subjective_item_id}&sort=${status.index+1}&teachPlanId=${param.teachPlanId}&flag=0">开始答题</a>
              </c:if>
              <c:if test="${0 < data.time}">
                ${data.time_str}
                <a class="btn" href="${pageContext.request.contextPath}/doZgt/subAnswer.html?tpsId=${param.tpsId}&siId=${data.subjective_item_id}&sort=${status.index+1}&teachPlanId=${param.teachPlanId}&flag=1">查看答案</a>
              </c:if>
            </div>
          </div>
        </li>
      </c:forEach>
    </ul>
  </div>
</section>
<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
    $(".wt-select-itm li .lb-1 .checkbox-1").click(function(){
      $(this).parent().toggleClass('select-ed');
    })
  })
</script>
</body>
</html>
