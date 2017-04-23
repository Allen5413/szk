<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<div style="font-size: 20px; padding-left: -10px;">
  <div class="am-g am-margin-top">
    <div class="am-u-sm-2 am-text-right"><label >计划名称：</label></div>
    <div id="edit_tp_tpName" class="am-u-sm-8">${teachPlan.name}</div>
    <div class="am-u-sm-1"></div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-2 am-text-right"><label >授课教师：</label></div>
    <div id="edit_tp_uName" class="am-u-sm-8">${userName}</div>
    <div class="am-u-sm-1"></div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-2 am-text-right"><label >计划描述：</label></div>
    <div id="edit_tp_detail" class="am-u-sm-8">${teachPlan.detail}</div>
    <div class="am-u-sm-1"></div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-2 am-text-right">
      <div class="opt-buttons">
        <a href="#" class="easyui-linkbutton" data-options="selected:true" onclick="editTeachPlan()"><span class="am-icon-edit"></span> 修改</a>
      </div>
    </div>
    <div class="am-u-sm-8"></div>
    <div class="am-u-sm-1"></div>
  </div>
</div>
<script>
  function editTeachPlan(){
    app.openDialog("${pageContext.request.contextPath}/editTeachPlan/open.html?id=${param.id}", "创建教学计划", 600, 400, function(index){
      var name = $("#edit_name").val().trim();
      if(name == ""){
        app.msg("请输入计划名称", 1);
        return;
      }
      app.edit("${pageContext.request.contextPath}/editTeachPlan/editor.json", $('#editForm').serialize(), index, "", function(data){
        $("#edit_tp_tpName").html(data.tpName);
        $("#edit_tp_uName").html(data.uName);
        $("#edit_tp_detail").html(data.detail);
        app.searchFormPage('teachplan');
      });
    });
  }
</script>