<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table id="count_answer_table" style="width: 100%; height:515px" class="easyui-datagrid" data-options="rownumbers:true"
       sortName="id"
       sortOrder="desc"
       checkOnSelect="true"
       selectOnCheck="true"
       fitColumns="true"
       loadMsg="数据加载中......">
  <thead>
  <tr>
    <th field="student_code" width="20%">学号</th>
    <th field="name" width="50%">姓名</th>
    <th field="time_str" width="20%">答题用时</th>
  </tr>
  </thead>
</table>
<script>
  $("#count_answer_table").datagrid({url:"${pageContext.request.contextPath}/findTpsoisByTpsIdAndOiIdController/find.json?tpsoiId="+tpsoiId});
</script>