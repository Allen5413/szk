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
<c:set var="isShowSetWorkCoreBtn" value="${my:isPermission(requestScope.resourceId,'setWorkCore',sessionScope.menuMap)}" />
<div class="container" style="padding: 10px 10px 0 10px; overflow:auto; height: 700px;">
  <div class="conditions" style="background-color: #f1f1f1; border: 1px #cacaca solid; height: auto; margin-bottom: 10px;">
    <br/>
    <form id="wg_page_form" name="pageForm" method="post">
      <table width="100%">
        <tr>
          <td width="10%" style="text-align: right"><span class="con-span">编码：</span></td>
          <td width="14%" style="text-align: left"><input type="text" name="code" style="height: 28px;" value="${param.name}" /></td>
          <td width="10%" style="text-align: right"><span class="con-span">名称：</span></td>
          <td width="14%" style="text-align: left"><input type="text" name="name" style="height: 28px;" value="${param.name}" /></td>
          <td style="text-align: left">
            <c:if test="${isShowFindBtn}">
              <div class="opt-buttons">
                <a href="#" class="easyui-linkbutton" id="search_wg_btn" data-options="selected:true" onclick="app.searchFormPage('wg')"><span class="am-icon-search"></span> 查询</a>
              </div>
            </c:if>
          </td>
        </tr>
      </table>
    </form>
    <br/>
  </div>
  <table id="wg_page_table" style="height:515px" class="easyui-datagrid" data-options="rownumbers:true"
         url="${pageContext.request.contextPath}/findWorkGroupPage/find.json"
         toolbar="#wg_page_tb"
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
      <th field="code" width="20%">编号</th>
      <th field="name" width="20%">名称</th>
      <th field="operator" width="10%">操作人</th>
      <th field="operateTime" width="15%" data-options="formatter:function(value){return app.formatDateValue(value, 1, 6);}">操作时间</th>
      <th field="operate" width="35%" data-options="formatter:function(value, row, index){return app.formatString($('#wg_page_operate').html(), row.id);}">操作</th>
    </tr>
    </thead>
  </table>
  <!-- table的操作按钮 -->
  <div id="wg_page_tb" style="padding:0 30px;">
    <div class="opt-buttons">
      <c:if test="${isShowAddBtn}">
        <a href="#" class="easyui-linkbutton" data-options="selected:true" onclick="addWg()"><span class="am-icon-plus"></span> 新增</a>
      </c:if>
    </div>
  </div>
  <!-- 每行的操作按钮 -->
  <div id="wg_page_operate" style="display: none;">
    <c:if test="${isShowSetWorkCoreBtn}">
      <a class="am-badge am-badge-success am-radius am-text-xs" onClick="setWorkGroupCore('{0}')"><span class="am-icon-cog"></span> 关联工作中心</a>
    </c:if>
    <c:if test="${isShowEditBtn}">
      <a class="am-badge am-badge-secondary am-radius am-text-xs" onClick="editWg('{0}')"><span class="am-icon-edit"></span> 修改</a>
    </c:if>
    <c:if test="${isShowDelBtn}">
      <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="delWg('{0}')"><span class="am-icon-trash-o"></span> 删除</a>
    </c:if>
  </div>
</div>
<%@ include file="../../common/loadGrid.jsp"%>
<script>

  function editWg(id){
    var url = '${pageContext.request.contextPath}/editWorkGroup/open.html?id='+id;
    app.openDialog(url, '编辑工作组', 600, 260, function(index){
      var code = $("#edit_code").val().trim();
      var name = $("#edit_name").val().trim();
      if(code == ""){
        app.msg("请输入编号", 1);
        return;
      }
      if(name == ""){
        app.msg("请输入名称", 1);
        return;
      }
      app.edit("${pageContext.request.contextPath}/editWorkGroup/editor.json", $('#editForm').serialize(), index, "wg");
    });
  }

  function addWg(){
    app.openDialog("${pageContext.request.contextPath}/addWorkGroup/open.html", "新增工作组", 600, 260, function(index){
      var code = $("#add_code").val().trim();
      var name = $("#add_name").val().trim();
      if(code == ""){
        app.msg("请输入编号", 1);
        return;
      }
      if(name == ""){
        app.msg("请输入名称", 1);
        return;
      }
      app.add("${pageContext.request.contextPath}/addWorkGroup/add.json", $('#addForm').serialize(), index, "wg");
    });
  }

  function delWg(id){
    app.del("您确定要删除该工作组信息？", "${pageContext.request.contextPath}/delWorkGroup/del.json", {"id":id}, "wg");
  }

  function setWorkGroupCore(id){
    app.openDialog('${pageContext.request.contextPath}/setWorkGroupCoreForWgId/open.html?wgId='+id, '关联工作中心', 800, 600, function(index){
      app.add("${pageContext.request.contextPath}/setWorkGroupCoreForWgId/set.json", $('#setForm').serialize(), index, "wg");
    });
  }
</script>
