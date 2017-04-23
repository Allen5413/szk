<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="am-form" id="addForm" name="addForm" method="post">
  <input type="hidden" id="reference" name="reference">
  <input type="hidden" id="answers" name="answers" />
  <input type="hidden" id="labels" name="labels" />
  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >题目：</label></div>
    <div class="am-u-sm-8" style="float: left">${oi.name}</div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >资源参考：</label></div>
    <div class="am-u-sm-8" style="float: left">${oi.reference}</div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >类型：</label></div>
    <div class="am-u-sm-8" style="float: left">
      <c:if test="${oi.type eq '0'}">单选</c:if>
      <c:if test="${oi.type eq '1'}">多选</c:if>
      <c:if test="${oi.type eq '2'}">不定项</c:if>
    </div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >选项：</label></div>
    <div class="am-u-sm-8" style="float: left">
      <table width="580">
        <tr style="height: 50px;">
          <td width="100">选项数：</td>
          <td>${oi.selectCount}</td>
        </tr>
        <c:forEach var="oia" items="${oiaList}">
          <tr style="height: 50px;">
            <td><c:if test="${oia.isAnswer eq '1'}">正确答案</c:if> </td>
            <td>${oia.answer}</td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >标签：</label></div>
    <div class="am-u-sm-8" style="float: left">${oi.labelNames}</div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >备注：</label></div>
    <div class="am-u-sm-8" style="float: left">${oi.remark}</div>
  </div>
</form>