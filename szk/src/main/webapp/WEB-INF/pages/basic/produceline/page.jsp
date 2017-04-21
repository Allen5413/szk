<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <form id="pl_page_form" name="pageForm" method="post">
      <table width="100%">
        <tr>
          <td width="10%" style="text-align: right"><span class="con-span">编码：</span></td>
          <td width="14%" style="text-align: left"><input type="text" name="code" style="height: 28px;" value="${param.code}" /></td>
          <td width="10%" style="text-align: right"><span class="con-span">名称：</span></td>
          <td width="14%" style="text-align: left"><input type="text" name="name" style="height: 28px;" value="${param.name}" /></td>
          <td style="text-align: left">
            <c:if test="${isShowFindBtn}">
              <div class="opt-buttons">
                <a href="#" class="easyui-linkbutton" id="search_pl_btn" data-options="selected:true" onclick="app.searchFormPage('pl')"><span class="am-icon-search"></span> 查询</a>
              </div>
            </c:if>
          </td>
        </tr>
      </table>
    </form>
    <br/>
  </div>
  <table id="pl_page_table" style="height:515px" class="easyui-datagrid" data-options="rownumbers:true"
         url="${pageContext.request.contextPath}/findProduceLinePage/find.json"
         toolbar="#pl_page_tb"
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
      <th field="code" width="7%">编号</th>
      <th field="name" width="15%">名称</th>
      <th field="isPublicStr" width="5%">是否公用</th>
      <th field="isUseStr" swidth="5%">正在使用</th>
      <th field="productNames" width="30%">加工产品</th>
      <th field="operator" width="10%">操作人</th>
      <th field="operateTime" width="15%" data-options="formatter:function(value){return app.formatDateValue(value, 1, 6);}">操作时间</th>
      <th field="operate" width="15%" data-options="formatter:function(value, row, index){return app.formatString($('#pl_page_operate').html(), row.id);}">操作</th>
    </tr>
    </thead>
  </table>
  <!-- table的操作按钮 -->
  <div id="pl_page_tb" style="padding:0 30px;">
    <div class="opt-buttons">
      <c:if test="${isShowAddBtn}">
        <a href="#" class="easyui-linkbutton" data-options="selected:true" onclick="addPl()"><span class="am-icon-plus"></span> 新增</a>
        <a href="#" class="easyui-linkbutton" data-options="selected:true" onclick="setProduceLine()"><span class="am-icon-cog"></span> 配置生产线</a>
      </c:if>
    </div>
  </div>
  <!-- 每行的操作按钮 -->
  <div id="pl_page_operate" style="display: none;">
    <c:if test="${isShowEditBtn}">
      <a class="am-badge am-badge-secondary am-radius am-text-xs" onClick="editPl('{0}')"><span class="am-icon-edit"></span> 修改</a>
    </c:if>
    <c:if test="${isShowDelBtn}">
      <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="delPl('{0}')"><span class="am-icon-trash-o"></span> 删除</a>
    </c:if>
  </div>
</div>
<%@ include file="../../common/loadGrid.jsp"%>
<script>
  function editPl(id){
    var url = '${pageContext.request.contextPath}/editProduceLine/open.html?id='+id;
    app.openDialog(url, '编辑生产线', 600, 300, function(index){
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
      app.edit("${pageContext.request.contextPath}/editProduceLine/editor.json", $('#editForm').serialize(), index, "pl");
    });
  }

  function addPl(){
    app.openDialog("${pageContext.request.contextPath}/addProduceLine/open.html", "新增生产线", 600, 300, function(index){
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
      app.add("${pageContext.request.contextPath}/addProduceLine/add.json", $('#addForm').serialize(), index, "pl");
    });
  }

  function delPl(id){
    app.del("您确定要删除该生产线？", "${pageContext.request.contextPath}/delProduceLine/del.json", {"id":id}, "pl");
  }

  function setProduceLine(){
    app.openOneBtnDialog('${pageContext.request.contextPath}/setProduceLineRelation/open.html', '配置生产线', 0.95, 600);
  }
</script>