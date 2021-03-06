<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" uri="/WEB-INF/permission.tld" %>
<p />
<c:set var="isShowAddBtn" value="${my:isPermission(requestScope.resourceId,'add',sessionScope.menuMap)}" />
<c:set var="isShowEditBtn" value="${my:isPermission(requestScope.resourceId,'edit',sessionScope.menuMap)}" />
<c:set var="isShowDelBtn" value="${my:isPermission(requestScope.resourceId,'del',sessionScope.menuMap)}" />
<c:set var="isShowFindBtn" value="${my:isPermission(requestScope.resourceId,'find',sessionScope.menuMap)}" />
<div class="container" style="padding: 10px 10px 0 10px; overflow:auto;">
  <table id="addOi_findOi_page_table" style="width: 100%; height:350px" class="easyui-datagrid"
         nowrap="false"
         idField="id"
         sortName="id"
         sortOrder="desc"
         checkOnSelect="true"
         selectOnCheck="true"
         fitColumns="true"
         loadMsg="数据加载中......">
    <thead>
    <tr>
      <th field="id" checkbox="true" width="5%" ></th>
      <th field="name" width="70%" >题目</th>
      <th field="type" width="10%" data-options="formatter:function(value){if(value == 0){
                                                                            return '单选';
                                                                          }
                                                                          else if(value == 1){
                                                                            return '多选';
                                                                          }else{
                                                                            return '不定项';
                                                                          }}">类型</th>
      <th field="labelNames" width="25%">标签</th>
    </tr>
    </thead>
  </table>
</div>
<%@ include file="../../common/loadGrid.jsp"%>
<script>
  $("#addOi_findOi_page_table").datagrid({url:"${pageContext.request.contextPath}/findObjectiveItemPage/find.json?state=0&page=1&rows=99999"});
</script>
