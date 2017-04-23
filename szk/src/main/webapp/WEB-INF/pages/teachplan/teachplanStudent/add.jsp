<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="am-form" id="addForm" name="addForm" method="post">
  <input type="hidden" name="teachPlanId" value="${param.teachPlanId}" />
  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >学号：</label></div>
    <div class="am-u-sm-8">
      <textarea rows="4" placeholder="输入学号" id="add_studentCodes" name="studentCodes"></textarea>
    </div>
    <div class="am-u-sm-9"><br />*必填，可以输入多个学号用英文逗号","隔开</div>
  </div>
</form>