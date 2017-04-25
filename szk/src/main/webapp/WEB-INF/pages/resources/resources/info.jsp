<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="am-form" id="addForm" name="addForm" method="post">
  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >标题：</label></div>
    <div class="am-u-sm-8" style="float: left">${teachResources.name}</div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >内容：</label></div>
    <div class="am-u-sm-8" style="float: left">${teachResources.content}</div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >标签：</label></div>
    <div class="am-u-sm-8" style="float: left">${teachResources.labelNames}</div>
  </div>
</form>