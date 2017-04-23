<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="am-form" id="addForm" name="addForm" method="post">
  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >计划名称：</label></div>
    <div class="am-u-sm-4">
      <input class="am-input-sm" type="text" placeholder="输入计划名称" required id="add_name" name="name"  />
    </div>
    <div class="am-u-sm-5">*必填，不可重复</div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >授课教师：</label></div>
    <div class="am-u-sm-4">
      <select lang="amaze_select" id="teachplan_page_state" name="zz" data-am-selected="{btnWidth: 150, maxHeight: 500, searchBox: 1}">
        <c:forEach var="teacher" items="${teacherList}">
          <option value="${teacher.zz}">${teacher.name}</option>
        </c:forEach>
      </select>
    </div>
    <div class="am-u-sm-5">*必选</div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >计划描述：</label></div>
    <div class="am-u-sm-8">
      <textarea rows="4" placeholder="输入计划描述" name="detail"></textarea>
    </div>
    <div class="am-u-sm-1"></div>
  </div>
</form>
<script>
  app.initAmazeSelect();
</script>