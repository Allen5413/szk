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
<c:set var="isShowSetResourceBtn" value="${my:isPermission(requestScope.resourceId,'setResource',sessionScope.menuMap)}" />
<div class="container" style="padding: 10px 10px 0 10px; overflow:auto; height: 700px;">
  <div class="conditions" style="background-color: #f1f1f1; border: 1px #cacaca solid; height: auto; margin-bottom: 10px;">
    <br/>
    <form id="menu_page_form" name="pageForm" method="post">
      <table width="100%">
        <tr>
          <td width="10%" style="text-align: right"><span class="con-span">菜单名称：</span></td>
          <td width="14%" style="text-align: left"><input type="text" name="name" style="height: 28px;" value="${param.name}" /></td>
          <td style="text-align: left">
            <c:if test="${isShowFindBtn}">
              <div class="opt-buttons">
                <a href="#" class="easyui-linkbutton" id="search_menu_btn" data-options="selected:true" onclick="app.searchFormPage('menu')"><span class="am-icon-search"></span> 查询</a>
              </div>
            </c:if>
          </td>
        </tr>
      </table>
    </form>
    <br/>
  </div>
  <table id="menu_page_table" style="height:515px" class="easyui-datagrid" data-options="rownumbers:true"
         url="${pageContext.request.contextPath}/findMenuPage/find.json"
         toolbar="#menu_page_tb"
         pagination="true"
         idField="id"
         pageSize="10"
         pageList="[10, 20, 50, 100, 999999]"
         sortName="id"
         sortOrder="desc"
         checkOnSelect="true"
         selectOnCheck="true"
         fitColumns="true"
         striped="true"
         loadMsg="数据加载中......">
    <thead>
    <tr>
      <th field="name" width="20%">菜单名称</th>
      <th field="remark" width="30%">备注</th>
      <th field="operator" width="10%">操作人</th>
      <th field="operateTime" width="15%" data-options="formatter:function(value){return app.formatDateValue(value, 1, 6);}">操作时间</th>
      <th field="operate" width="26%" data-options="formatter:function(value, row, index){return app.formatString($('#menu_page_operate').html(), row.id);}">操作</th>
    </tr>
    </thead>
  </table>
    <!-- table的操作按钮 -->
  <div id="menu_page_tb" style="padding:0 30px;">
    <div class="opt-buttons">
      <c:if test="${isShowAddBtn}">
        <a href="#" class="easyui-linkbutton" data-options="selected:true" onclick="addMenu()"><span class="am-icon-plus"></span> 新增</a>
      </c:if>
    </div>
  </div>
  <!-- 每行的操作按钮 -->
  <div id="menu_page_operate" style="display: none;">
    <c:if test="${isShowSetResourceBtn}">
      <a class="am-badge am-badge-success am-radius am-text-xs" onClick="openResource('{0}')"><span class="am-icon-cog"></span> 关联资源</a>
    </c:if>
    <c:if test="${isShowEditBtn}">
      <a class="am-badge am-badge-secondary am-radius am-text-xs" onClick="editMenu('{0}')"><span class="am-icon-edit"></span> 修改</a>
    </c:if>
    <c:if test="${isShowDelBtn}">
      <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="delMenu('{0}')"><span class="am-icon-trash-o"></span> 删除</a>
    </c:if>
  </div>
</div>
<%@ include file="../../common/loadGrid.jsp"%>
<script>
    function addMenu(){
        app.openDialog("${pageContext.request.contextPath}/addMenu/open.html", "新增菜单", 600, 300, function(index){
            app.add("${pageContext.request.contextPath}/addMenu/add.json", $('#addForm').serialize(), index, "menu");
        });
    }

    function delMenu(id){
        app.del("您确定要删除该菜单信息？", "${pageContext.request.contextPath}/delMenu/del.json", {"id":id}, "menu");
    }

    function editMenu(id){
        var url = '${pageContext.request.contextPath}/editMenu/open.html?id='+id;
        app.openDialog(url, '编辑菜单', 600, 300, function(index){
            var name = $("#edit_name").val().trim();
            if(name == ""){
                app.msg("请输入名称", 1);
                return;
            }
            app.edit("${pageContext.request.contextPath}/editMenu/editor.json", $('#editForm').serialize(), index, "menu");
        });
    }

    function openResource(id){
        app.openOneBtnDialog('${pageContext.request.contextPath}/findResourceByMenuId/open.html?menuId='+id, '关联资源', 1200, 0.8);
    }
</script>