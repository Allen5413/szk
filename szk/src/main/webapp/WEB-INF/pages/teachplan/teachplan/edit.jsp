<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="am-form" id="editForm" name="editForm" method="post">
  <input type="hidden" name="id" value="${teachPlan.id}" />
  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >计划名称：</label></div>
    <div class="am-u-sm-5">
      <input class="am-input-sm" type="text" placeholder="输入计划名称" required id="edit_name" name="name" value="${teachPlan.name}"  />
    </div>
    <div class="am-u-sm-4">*必填，不可重复</div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >授课教师：</label></div>
    <div class="am-u-sm-5">
      <select lang="amaze_select" id="teachplan_page_state" name="zz" data-am-selected="{btnWidth: 200, maxHeight: 500, searchBox: 1}">
        <c:forEach var="teacher" items="${teacherList}">
          <option value="${teacher.zz}" <c:if test="${teachPlan.zz eq teacher.zz}">selected="selected" </c:if> >${teacher.name}</option>
        </c:forEach>
      </select>
    </div>
    <div class="am-u-sm-4">*必选</div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >计划描述：</label></div>
    <div class="am-u-sm-8">
      <textarea rows="4" placeholder="输入计划描述" name="detail">${teachPlan.detail}</textarea>
    </div>
    <div class="am-u-sm-1"></div>
  </div>
</form>
<script>
  app.initAmazeSelect();
</script>