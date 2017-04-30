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
    <p class="tit">第三阶段 学习巩固与内化 第${param.sort}题</p>
    <a href="${pageContext.request.contextPath}/findTeachPlanByStudentId/find.html" class="back icon"></a>
    <a class="next" href="${pageContext.request.contextPath}/findTeachPlanSubjectByTpId/find.html?teachPlanId=${param.teachPlanId}">返回目录</a>
  </div>
</header>
<section class="pm-top-40">
  <form id="formZgt" name="formZgt" action="${pageContext.request.contextPath}/doZgt/subAnswer.html" method="post">
    <input type="hidden" name="beginTime" value="${beginTime}" />
    <input type="hidden" name="tpsId" value="${param.tpsId}" />
    <input type="hidden" name="siId" value="${param.siId}" />
    <input type="hidden" name="flag" value="0" />
    <input type="hidden" name="teachPlanId" value="${param.teachPlanId}">
    <input type="hidden" name="answer" value="xxxxxxxxxx">
    <div class="auto w bg-f">
      <dl class="talk-wt-list">
        <dd>
          <div class="title line-b1">${si.name}</div>
          <div class="text">${si.reference}</div>
        </dd>
        <dd>
          <div class="text">
            <h5>回答问题：</h5>
            <div class="text-input">
              <textarea placeholder="请输入您的回答" ></textarea>
            </div>
            <p><a class="btn-com" href="kt-cem-1.html" onclick="subZgt()">确定提交</a></p>
          </div>
        </dd>
      </dl>
    </div>
  </form>
</section>
<script type="text/javascript">
  function subZgt(){
    var answer = $("#answer").val();
    if("" == answer){
      alert("请填写答案");
      return false;
    }
    alert(answer);
    $("#formZgt").submit();
  }
</script>
</body>
</html>
