<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" uri="/WEB-INF/permission.tld" %>
<p />
<div class="container" style="padding: 10px 10px 0 10px; overflow:auto;">
  <table id="addResources_findResources_page_table" style="width: 100%; height:350px" class="easyui-datagrid"
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
      <th field="name" width="70%" >资源名称</th>
      <th field="labelNames" width="25%">标签</th>
    </tr>
    </thead>
  </table>
</div>
<%@ include file="../../common/loadGrid.jsp"%>
<script>
  $("#addResources_findResources_page_table").datagrid({url:"${pageContext.request.contextPath}/findTeachResourcesPage/find.json?isLink=0&page=1&rows=99999"});
</script>
