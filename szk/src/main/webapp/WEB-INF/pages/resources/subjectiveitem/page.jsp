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
    <form id="subjectiveitem_page_form" name="pageForm" method="post">
      <table width="100%">
        <tr>
          <td width="10%" style="text-align: right"><span class="con-span">名称：</span></td>
          <td width="14%" style="text-align: left"><input type="text" name="name" style="height: 28px;" value="${param.name}" /></td>
          <td width="10%" style="text-align: right"><span class="con-span">标签：</span></td>
          <td width="14%" style="text-align: left"><input type="text" name="lable" style="height: 28px;" value="${param.lable}" /></td>
          <td style="text-align: left">
            <c:if test="${isShowFindBtn}">
              <div class="opt-buttons" style="padding-left: 20px;">
                <a href="#" class="easyui-linkbutton" id="search_subjectiveitem_btn" data-options="selected:true" onclick="app.searchFormPage('subjectiveitem')"><span class="am-icon-search"></span> 查询</a>
              </div>
            </c:if>
          </td>
        </tr>
      </table>
    </form>
    <br/>
  </div>
  <table id="subjectiveitem_page_table" style="width: 100%; height:515px" class="easyui-datagrid" data-options="rownumbers:true"
         url="${pageContext.request.contextPath}/findSubjectiveItemPage/find.json"
         toolbar="#subjectiveitem_page_tb"
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
                                                                  return app.formatString($('#subjectiveitem_page_operate').html(), row.id);
                                                                }else{
                                                                  return app.formatString($('#subjectiveitem_page_operate2').html(), row.id);
                                                                }
                                                              }">操作</th>
    </tr>
    </thead>
  </table>
  <!-- table的操作按钮 -->
  <div id="subjectiveitem_page_tb" style="padding:0 30px;">
    <div class="opt-buttons">
      <c:if test="${isShowAddBtn}">
        <a href="#" class="easyui-linkbutton" data-options="selected:true" onclick="addSubjectiveItem()"><span class="am-icon-plus"></span> 添加主观题</a>
      </c:if>
    </div>
  </div>
  <!-- 每行的操作按钮 -->
  <div id="subjectiveitem_page_operate" style="display: none;">
    <c:if test="${isShowFindBtn}">
      <a class="am-badge am-badge-secondary am-radius am-text-xs" onClick="editSubjectiveItem('{0}')"><span class="am-icon-edit"></span> 编辑</a>
    </c:if>
    <c:if test="${isShowEditBtn}">
      <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="editSubjectiveItem('{0}', 1)"><span class="am-icon-edit"></span> 关闭</a>
    </c:if>
    <c:if test="${isShowDelBtn}">
      <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="delSubjectiveItem('{0}')"><span class="am-icon-trash-o"></span> 删除</a>
    </c:if>
  </div>
  <div id="subjectiveitem_page_operate2" style="display: none;">
    <c:if test="${isShowFindBtn}">
      <a class="am-badge am-badge-secondary am-radius am-text-xs" onClick="editSubjectiveItem('{0}')"><span class="am-icon-edit"></span> 编辑</a>
    </c:if>
    <c:if test="${isShowEditBtn}">
      <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="editSubjectiveItem('{0}', 0)"><span class="am-icon-edit"></span> 恢复</a>
    </c:if>
    <c:if test="${isShowDelBtn}">
      <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="delSubjectiveItem('{0}')"><span class="am-icon-trash-o"></span> 删除</a>
    </c:if>
  </div>
</div>
<%@ include file="../../common/loadGrid.jsp"%>
<script>
  function addSubjectiveItem(){
    app.openDialog("${pageContext.request.contextPath}/addSubjectiveItem/open.html", "添加主观题", 1000, 700, function(index){
      var name = $("#add_name").val().trim();
      var reference = UE.getEditor('add_subjectiveitem_reference').getContent();
      var answers =  UE.getEditor('add_answer').getContent();
      var labels = "";
      $("[name=labels_cb]").each(function(){
        if($(this).is(":checked")){
          labels += $(this).val()+",";
        }
      });

      if(name == ""){
        app.msg("请输入题目名称", 1);
        return;
      }
      if(reference == ""){
        app.msg("请输入参考资源", 1);
        return;
      }
      if(answers == ""){
        app.msg("请输入讨论要点", 1);
        return;
      }

      $("#answers").val(answers);
      if(0 < labels.length) {
        $("#labels").val(labels.substring(0, labels.length-1));
      }
      app.add("${pageContext.request.contextPath}/addSubjectiveItem/add.json", $('#addForm').serialize(), index, "subjectiveitem");
    });
  }

  function findSubjectiveItemInfo(id){
    app.openOneBtnDialog('${pageContext.request.contextPath}/findSubjectiveItemById/find.html?id='+id, '查看', 1000, 700);
  }

  function editSubjectiveItem(id, state){
    if(null == state){
      app.openDialog("${pageContext.request.contextPath}/editSubjectiveItem/open.html?id="+id, "修改主观题", 1000, 700, function(index){
        var name = $("#edit_name").val().trim();
        var reference = UE.getEditor('edit_subjectiveitem_reference').getContent();
        var answers =  UE.getEditor('edit_answer').getContent();
        var labels = "";
        $("[name=labels_cb]").each(function(){
          if($(this).is(":checked")){
            labels += $(this).val()+",";
          }
        });

        if(name == ""){
          app.msg("请输入题目名称", 1);
          return;
        }
        if(reference == ""){
          app.msg("请输入参考资源", 1);
          return;
        }
        if(answers == ""){
          app.msg("请输入讨论要点", 1);
          return;
        }

        $("#answers").val(answers);
        if(0 < labels.length) {
          $("#labels").val(labels.substring(0, labels.length-1));
        }
        app.add("${pageContext.request.contextPath}/editSubjectiveItem/editor.json", $('#editForm').serialize(), index, "subjectiveitem");
      });
    }else{
      app.operator("您确定要"+(state == 0 ? "恢复": "关闭")+"该题目？", '${pageContext.request.contextPath}/editSubjectiveItemForState/editor.json', {"id":id, "state":state}, "subjectiveitem");
    }
  }

  function delSubjectiveItem(id){
    app.del("您确定要删除该题目？", '${pageContext.request.contextPath}/delSubjectiveItem/del.json', {"id":id}, "subjectiveitem");
  }
</script>
