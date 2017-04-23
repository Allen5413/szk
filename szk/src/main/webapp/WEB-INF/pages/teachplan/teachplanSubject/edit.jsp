<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="am-form" id="editForm" name="editForm" method="post">
  <input type="hidden" name="id" value="${teachPlanSubject.id}" />
  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >专题名称：</label></div>
    <div class="am-u-sm-4">
      <input class="am-input-sm" type="text" placeholder="输入专题名称" required id="edit_name" name="name" value="${teachPlanSubject.name}" />
    </div>
    <div class="am-u-sm-5">*必填，不可重复</div>
  </div>
</form>