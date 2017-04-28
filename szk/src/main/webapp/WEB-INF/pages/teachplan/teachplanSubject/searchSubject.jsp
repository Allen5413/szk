<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
<table id="search_subject_page_table" style="width: 1180px; height:515px;" class="easyui-datagrid" data-options="rownumbers:true"
       url="${pageContext.request.contextPath}/findTeachPlanSubjectPage/find.json?teachPlanId=${teachPlan.id}"
       toolbar="#search_subject_page_tb"
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
    <th field="name" width="30%">专题名称</th>
    <th field="objectiveState" width="17%" data-options="formatter:function(value, row, index){return setBtn(value, 0, row.id);}">前测</th>
    <th field="resourceState" width="17%" data-options="formatter:function(value, row, index){return setBtn(value, 1, row.id);}">课堂讨论</th>
    <th field="subjectiveState" width="17%" data-options="formatter:function(value, row, index){return setBtn(value, 2, row.id);}">后测</th>
    <th field="state" width="10%" data-options="formatter:function(value, row, index){return value == 0 ? '正常' : '关闭';}">状态</th>
    <th field="operate" width="20%" data-options="formatter:function(value, row, index){if(row.state == 0){
                                                                                            return app.formatString($('#search_subject_page_operate2').html(), row.id);
                                                                                        }else{
                                                                                            return app.formatString($('#search_subject_page_operate').html(), row.id);
                                                                                        }}">操作</th>
  </tr>
  </thead>
</table>
<!-- table的操作按钮 -->
<div id="search_subject_page_tb" style="padding:0 30px;">
  <div class="opt-buttons">
    <a href="#" class="easyui-linkbutton" data-options="selected:true" onclick="addTeachPlanSubject()"><span class="am-icon-plus"></span> 添加专题</a>
  </div>
</div>
<!-- 每行的操作按钮 -->
<div id="search_subject_page_operate" style="display: none;">
    <a class="am-badge am-badge-secondary am-radius am-text-xs" onClick="editTeachPlanSubjectName('{0}')"><span class="am-icon-edit"></span> 编辑</a>
    <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="editTeachPlanSubjectState('{0}', 0)"><span class="am-icon-edit"></span> 开启</a>
</div>
<div id="search_subject_page_operate2" style="display: none;">
    <a class="am-badge am-badge-secondary am-radius am-text-xs" onClick="editTeachPlanSubjectName('{0}')"><span class="am-icon-edit"></span> 编辑</a>
    <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="editTeachPlanSubjectState('{0}', 1)"><span class="am-icon-edit"></span> 关闭</a>
</div>
<script>
  function setBtn(value, flag, id){
    var html = (value == 0 ? '未设置' : '已设置');
    html += "&nbsp;&nbsp;<a href='#' onclick='";
    if(0 == flag) {
      html += "setOi("+id+")";
    }
    if(1 == flag) {
      html += "setResources("+id+")";
    }
    if(2 == flag) {
      html += "setSi("+id+")";
    }
    html += "'><span class='am-icon-edit'></span></a>";
    return html;
  }

  function setOi(id){
      app.openDialog("${pageContext.request.contextPath}/setTeachPlanSubjectOi/open.html?id="+id, "前测设置", 1000, 700, function(index){
          var beginTime = $("#add_beginTime").val().trim();
          var endTime = $("#add_endTime").val().trim();
          if(beginTime == ""){
              app.msg("请选择开始时间", 1);
              return;
          }
          if(endTime == ""){
              app.msg("请选择结束时间", 1);
              return;
          }
          app.add("${pageContext.request.contextPath}/setTeachPlanSubjectOi/set.json", $('#addForm').serialize(), index, "", function(){
              $("#search_subject_page_table").datagrid("reload");
          });
      });
  }

  function setResources(id){
      app.openDialog("${pageContext.request.contextPath}/setTeachPlanSubjectResources/open.html?id="+id, "课堂讨论设置", 1000, 700, function(index){
          var beginTime = $("#add_beginTime").val().trim();
          var endTime = $("#add_endTime").val().trim();
          if(beginTime == ""){
              app.msg("请选择开始时间", 1);
              return;
          }
          if(endTime == ""){
              app.msg("请选择结束时间", 1);
              return;
          }
          app.add("${pageContext.request.contextPath}/setTeachPlanSubjectResources/set.json", $('#addForm').serialize(), index, "", function(){
              $("#search_subject_page_table").datagrid("reload");
          });
      });
  }

  function setSi(id){
      app.openDialog("${pageContext.request.contextPath}/setTeachPlanSubjectSi/open.html?id="+id, "后测设置", 1000, 700, function(index){
          var beginTime = $("#add_beginTime").val().trim();
          var endTime = $("#add_endTime").val().trim();
          if(beginTime == ""){
              app.msg("请选择开始时间", 1);
              return;
          }
          if(endTime == ""){
              app.msg("请选择结束时间", 1);
              return;
          }
          app.add("${pageContext.request.contextPath}/setTeachPlanSubjectSi/set.json", $('#addForm').serialize(), index, "", function(){
              $("#search_subject_page_table").datagrid("reload");
          });
      });
  }

  function addTeachPlanSubject(){
    app.openDialog("${pageContext.request.contextPath}/addTeachPlanSubject/open.html?teachPlanId=${teachPlan.id}", "添加专题", 600, 200, function(index){
      var studentCodes = $("#add_name").val().trim();
      if(studentCodes == ""){
        app.msg("请输入名称", 1);
        return;
      }
      app.add("${pageContext.request.contextPath}/addTeachPlanSubject/add.json", $('#addForm').serialize(), index, "", function(){
        $("#search_subject_page_table").datagrid("reload");
      });
    });
  }

  function editTeachPlanSubjectName(id){
      app.openDialog("${pageContext.request.contextPath}/editTeachPlanSubjectForName/open.html?id="+id, "编辑专题", 600, 200, function(index){
          var studentCodes = $("#edit_name").val().trim();
          if(studentCodes == ""){
              app.msg("请输入名称", 1);
              return;
          }
          app.edit("${pageContext.request.contextPath}/editTeachPlanSubjectForName/editor.json", $('#editForm').serialize(), index, "", function(){
              $("#search_subject_page_table").datagrid("reload");
          });
      });
  }

  function editTeachPlanSubjectState(id, state){
      app.operator("您确定要"+(0 == state ? "开启" : "关闭")+"该专题？", "${pageContext.request.contextPath}/editTeachPlanStudentForState/editor.json", {"id":id, "state":state}, "", function(){
          $("#search_subject_page_table").datagrid("reload");
      });
  }
</script>