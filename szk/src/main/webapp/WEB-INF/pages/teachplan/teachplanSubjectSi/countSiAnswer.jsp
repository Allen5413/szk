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
    <th field="student_code" width="10%">学号</th>
    <th field="name" width="10%">姓名</th>
    <th field="answer" width="65%" data-options="formatter:function(value, row, index){return searchContentTdHtml(value, row.id);}">答题内容</th>
    <th field="time_str" width="15%">答题用时</th>
  </tr>
  </thead>
</table>
<script>
  $("#count_answer_table").datagrid({url:"${pageContext.request.contextPath}/findTpssisByTpsIdAndSiIdController/find.json?tpssiId=${param.tpssiId}"});

  function searchContentTdHtml(value, id){
      return "<a href=\"#\" onclick=\"searchContent("+id+")\">"+value.substring(0,40)+"...</a>";
  }

  function searchContent(id){
    app.openOneBtnDialog("${pageContext.request.contextPath}/findTpssisByTpsIdAndSiIdController/searchContent.html?id="+id, "查看答题内容", 1000, 700);
  }
</script>