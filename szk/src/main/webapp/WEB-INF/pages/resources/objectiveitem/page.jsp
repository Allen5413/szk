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
<div class="container" style="padding: 10px 10px 0 10px; overflow:auto; height: 700px;">
  <div class="conditions" style="background-color: #f1f1f1; border: 1px #cacaca solid; height: auto; margin-bottom: 10px;">
    <br/>
    <form id="objectiveitem_page_form" name="pageForm" method="post">
      <table width="100%">
        <tr>
          <td width="10%" style="text-align: right"><span class="con-span">名称：</span></td>
          <td width="14%" style="text-align: left"><input type="text" name="name" style="height: 28px;" value="${param.name}" /></td>
          <td width="10%" style="text-align: right"><span class="con-span">标签：</span></td>
          <td width="14%" style="text-align: left"><input type="text" name="lable" style="height: 28px;" value="${param.lable}" /></td>
          <td style="text-align: left">
            <c:if test="${isShowFindBtn}">
              <div class="opt-buttons" style="padding-left: 20px;">
                <a href="#" class="easyui-linkbutton" id="search_objectiveitem_btn" data-options="selected:true" onclick="app.searchFormPage('objectiveitem')"><span class="am-icon-search"></span> 查询</a>
              </div>
            </c:if>
          </td>
        </tr>
      </table>
    </form>
    <br/>
  </div>
  <table id="objectiveitem_page_table" style="width: 100%; height:515px" class="easyui-datagrid" data-options="rownumbers:true"
         url="${pageContext.request.contextPath}/findObjectiveItemPage/find.json"
         toolbar="#objectiveitem_page_tb"
         nowrap="false"
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
      <th field="name" width="35%">题目</th>
      <th field="type" width="6%" data-options="formatter:function(value){if(value == 0){
                                                                            return '单选';
                                                                          }
                                                                          else if(value == 1){
                                                                            return '多选';
                                                                          }else{
                                                                            return '不定项';
                                                                          }}">类型</th>
      <th field="labelNames" width="18%">标签</th>
      <th field="state" width="6%" data-options="formatter:function(value){if(value == 0){
                                                                            return '正常';
                                                                          }else{
                                                                            return '关闭';
                                                                          }}">状态</th>
      <th field="creator" width="6%">上传者</th>
      <th field="createTime" width="15%" data-options="formatter:function(value){return app.formatDateValue(value, 1, 6);}">上传时间</th>
      <th field="operate" width="18%" data-options="formatter:function(value, row, index){
                                                                if(row.state == 0){
                                                                  return app.formatString($('#objectiveitem_page_operate').html(), row.id);
                                                                }else{
                                                                  return app.formatString($('#objectiveitem_page_operate2').html(), row.id);
                                                                }
                                                              }">操作</th>
    </tr>
    </thead>
  </table>
  <!-- table的操作按钮 -->
  <div id="objectiveitem_page_tb" style="padding:0 30px;">
    <div class="opt-buttons">
      <c:if test="${isShowAddBtn}">
        <a href="#" class="easyui-linkbutton" data-options="selected:true" onclick="addObjectiveItem()"><span class="am-icon-plus"></span> 添加客观题</a>
      </c:if>
    </div>
  </div>
  <!-- 每行的操作按钮 -->
  <div id="objectiveitem_page_operate" style="display: none;">
    <c:if test="${isShowFindBtn}">
      <a class="am-badge am-badge-secondary am-radius am-text-xs" onClick="editObjectiveItemInfo('{0}')"><span class="am-icon-edit"></span> 修改</a>
    </c:if>
    <c:if test="${isShowEditBtn}">
      <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="editObjectiveItem('{0}', 1)"><span class="am-icon-edit"></span> 关闭</a>
    </c:if>
    <c:if test="${isShowDelBtn}">
      <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="delObjectiveItem('{0}')"><span class="am-icon-trash-o"></span> 删除</a>
    </c:if>
  </div>
  <div id="objectiveitem_page_operate2" style="display: none;">
    <c:if test="${isShowFindBtn}">
      <a class="am-badge am-badge-secondary am-radius am-text-xs" onClick="editObjectiveItemInfo('{0}')"><span class="am-icon-edit"></span> 修改</a>
    </c:if>
    <c:if test="${isShowEditBtn}">
      <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="editObjectiveItem('{0}', 0)"><span class="am-icon-edit"></span> 恢复</a>
    </c:if>
    <c:if test="${isShowDelBtn}">
      <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="delObjectiveItem('{0}')"><span class="am-icon-trash-o"></span> 删除</a>
    </c:if>
  </div>
</div>
<%@ include file="../../common/loadGrid.jsp"%>
<script>
  function addObjectiveItem(){
    app.openDialog("${pageContext.request.contextPath}/addObjectiveItem/open.html", "添加客观题", 1000, 700, function(index){
      var name = $("#add_name").val().trim();
      var type = $('input:radio[name="type"]:checked').val();
      var selectCount = $('input:radio[name="selectCount"]:checked').val();
      var answers = "";
      var isHaveAnswer = 0;
      var labels = "";
      for(var i=1; i<=selectCount; i++){
        var isAnswer = ($('#add_answer_cb'+i).is(":checked")) ? 1 : 0;
        var answer = UE.getEditor('add_answer'+i).getContent();
        if(1 < i){
          answers += "#@#";
        }
        answers += answer+"@#@"+isAnswer;
        if(isAnswer == 1){
          isHaveAnswer++;
        }
      }

      $("[name=labels_cb]").each(function(){
        if($(this).is(":checked")){
          labels += $(this).val()+",";
        }
      });

      if(name == ""){
        app.msg("请输入题目名称", 1);
        return;
      }
      if(0 == isHaveAnswer){
        app.msg("请至少选择一个正确答案", 1);
        return;
      }
      if(0 == type && 1 < isHaveAnswer){
        app.msg("当前为单选题，只能选择一个正确答案", 1);
        return;
      }

      $("#reference").val(UE.getEditor('add_objectiveitem_reference').getContent());
      $("#answers").val(answers);
      if(0 < labels.length) {
        $("#labels").val(labels.substring(0, labels.length-1));
      }
      app.add("${pageContext.request.contextPath}/addObjectiveItem/add.json", $('#addForm').serialize(), index, "objectiveitem");
    });
  }

  function editObjectiveItemInfo(id){
    app.openDialog('${pageContext.request.contextPath}/editObjectiveItem/open.html?id='+id, '修改', 1000, 700, function(index){
      var name = $("#edit_name").val().trim();
      var type = $('input:radio[name="type"]:checked').val();
      var selectCount = $('input:radio[name="selectCount"]:checked').val();
      var answers = "";
      var isHaveAnswer = 0;
      var labels = "";
      for(var i=1; i<=selectCount; i++){
        var isAnswer = ($('#add_answer_cb'+i).is(":checked")) ? 1 : 0;
        var answer = UE.getEditor('add_answer'+i).getContent();
        if(1 < i){
          answers += "#@#";
        }
        answers += answer+"@#@"+isAnswer;
        if(isAnswer == 1){
          isHaveAnswer++;
        }
      }

      $("[name=labels_cb]").each(function(){
        if($(this).is(":checked")){
          labels += $(this).val()+",";
        }
      });

      if(name == ""){
        app.msg("请输入题目名称", 1);
        return;
      }
      if(0 == isHaveAnswer){
        app.msg("请至少选择一个正确答案", 1);
        return;
      }
      if(0 == type && 1 < isHaveAnswer){
        app.msg("当前为单选题，只能选择一个正确答案", 1);
        return;
      }

      $("#reference").val(UE.getEditor('edit_objectiveitem_reference').getContent());
      $("#answers").val(answers);
      if(0 < labels.length) {
        $("#labels").val(labels.substring(0, labels.length-1));
      }
      app.edit("${pageContext.request.contextPath}/editObjectiveItem/editor.json", $('#editForm').serialize(), index, "objectiveitem");
    });
  }

  function editObjectiveItem(id, state){
    app.operator("您确定要"+(state == 0 ? "恢复": "关闭")+"该题目？", '${pageContext.request.contextPath}/editObjectiveItemForState/editor.json', {"id":id, "state":state}, "objectiveitem");
  }

  function delObjectiveItem(id){
    app.del("您确定要删除该题目？", '${pageContext.request.contextPath}/delObjectiveItem/del.json', {"id":id}, "objectiveitem");
  }
</script>
