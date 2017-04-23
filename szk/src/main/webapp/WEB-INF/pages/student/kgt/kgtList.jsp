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
  <div class="auto w kc-tm-list">
    <div class="intro">
      <div class="title">习题说明</div>
      <p>1.	该部分共四道习题，均为不定项选择题；</p>
      <p>2.	所有习题只有1次答题机会，系统将自动记录答题情况；</p>
      <p>3.	习题不提供参考答案，请仔细核对答案后再提交。
    </div>
    <ul class="list-tm">
      <c:forEach var="data" items="${list}" varStatus="status">
        <li>
          <div class="flex-cel">
            <div class="tm-ig">第${status.index+1}题</div>
            <div class="cl-txt">
              <c:if test="${empty data.is_right}">
                <a class="btn" href="${pageContext.request.contextPath}/doKgt/doing.html?tpsId=${param.tpsId}&oiId=${data.objective_item_id}&sort=${status.index+1}&teachPlanId=${param.teachPlanId}">开始答题</a>
              </c:if>
              <c:if test="${!empty data.is_right}">
                <c:if test="${'0' eq data.is_right}">
                  <span class="red">回答错误</span>
                </c:if>
                <c:if test="${'1' eq data.is_right}">
                  <span class="green">回答正确</span>
                </c:if>
                ${data.time_str}
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
