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
    <p class="tit">前置学习 第${param.sort}题</p>
    <a href="${pageContext.request.contextPath}/findTeachPlanByStudentId/find.html" class="back icon"></a>
    <a class="next" href="${pageContext.request.contextPath}/findTeachPlanSubjectByTpId/find.html?teachPlanId=${param.teachPlanId}">返回目录</a>
  </div>
</header>
<section class="pm-top-40">
  <div class="auto w bg-f kc-tm-mod">
    <div class="mod-video">
      ${oi.reference}
    </div>
    <div class="tm-txt">
      <form id="form" name="form" action="${pageContext.request.contextPath}/doKgt/subAnswer.html" method="post">
        <input type="hidden" name="beginTime" value="${beginTime}" />
        <input type="hidden" name="tpsId" value="${param.tpsId}" />
        <input type="hidden" name="oiId" value="${param.oiId}" />
        <input type="hidden" id="changeAnwserIds" name="changeAnwserIds" />
        <input type="hidden" name="teachPlanId" value="${param.teachPlanId}">
        <div class="hidden">${oi.name}</div>
        <ul class="wt-select-itm">
          <c:forEach var="oia" items="${oiaList}">
            <li><label class="lb-1"><input class="checkbox-1" type="checkbox" name="answer_cb" value="${oia.id}"></label>
              <div class="itm-txt">${oia.answer}</div>
            </li>
          </c:forEach>
        </ul>
        <p><a class="btn-com" href="#" onclick="sub()">确定提交</a></p>
      </form>
    </div>
  </div>
</section>
<script type="text/javascript">
  $(document).ready(function(){
    $(".wt-select-itm li .lb-1 .checkbox-1").click(function(){
      $(this).parent().toggleClass('select-ed');
    })
  })

  function sub(){
    var changeAnwserIds = $("#changeAnwserIds").val();
    $("[name=answer_cb]").each(function(){
      if($(this).is(":checked")){
        changeAnwserIds += $(this).val()+",";
      }
    });
    if("" == changeAnwserIds){
      alert("请选择答案");
      return false;
    }else{
      changeAnwserIds = changeAnwserIds.substring(0, changeAnwserIds.length-1);
    }
    $("#changeAnwserIds").val(changeAnwserIds);
    $("#form").submit();
  }
</script>
</body>
</html>
