<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
<table id="search_student_page_table" style="width: 1000px; height:515px;" class="easyui-datagrid" data-options="rownumbers:true"
       url="${pageContext.request.contextPath}/findTeachPlanStudentPage/find.json?teachPlanId=${teachPlan.id}"
       toolbar="#search_student_page_tb"
       pagination="true"
       idField="id"
       pageSize="10"
       pageList="[10, 20, 50, 100, 999999]"
       sortName="id"
       sortOrder="desc"
       checkOnSelect="true"
       selectOnCheck="true"
       fitColumns="true"
       loadMsg="数据加载中......">
  <thead>
  <tr>
    <th field="student_code" width="30%">学号</th>
    <th field="uName" width="60%">姓名</th>
    <th field="operate" width="20%" data-options="formatter:function(value, row, index){return app.formatString($('#search_student_page_operate').html(), row.id);}">操作</th>
  </tr>
  </thead>
</table>
<!-- table的操作按钮 -->
<div id="search_student_page_tb" style="padding:0 30px;">
  <div class="opt-buttons">
    <a href="#" class="easyui-linkbutton" data-options="selected:true" onclick="addTeachPlanStudent()"><span class="am-icon-plus"></span> 添加学员</a>
  </div>
</div>
<!-- 每行的操作按钮 -->
<div id="search_student_page_operate" style="display: none;">
  <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="findTeachPlanStudent('{0}')"><span class="am-icon-trash-o"></span> 删除</a>
</div>
<script>
  function addTeachPlanStudent(){
    app.openDialog("${pageContext.request.contextPath}/addTeachPlanStudent/open.html?teachPlanId=${teachPlan.id}", "添加学员", 600, 300, function(index){
      var studentCodes = $("#add_studentCodes").val().trim();
      if(studentCodes == ""){
        app.msg("请输入学号", 1);
        return;
      }
      app.add("${pageContext.request.contextPath}/addTeachPlanStudent/add.json", $('#addForm').serialize(), index, "", function(){
        $("#search_student_page_table").datagrid("reload");
      });
    });
  }

  function findTeachPlanStudent(id){
    app.del("您确定要删除该学员？", "${pageContext.request.contextPath}/delTeachPlanStudent/del.json", {"id":id}, "", function(){
      $("#search_student_page_table").datagrid("reload");
    });
  }
</script>