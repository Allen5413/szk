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
    <form id="teachresources_page_form" name="pageForm" method="post">
      <table width="100%">
        <tr>
          <td width="10%" style="text-align: right"><span class="con-span">名称：</span></td>
          <td width="14%" style="text-align: left"><input type="text" name="name" style="height: 28px;" value="${param.name}" /></td>
          <td width="10%" style="text-align: right"><span class="con-span">标签：</span></td>
          <td width="14%" style="text-align: left"><input type="text" name="lable" style="height: 28px;" value="${param.lable}" /></td>
          <td style="text-align: left">
            <c:if test="${isShowFindBtn}">
              <div class="opt-buttons" style="padding-left: 20px;">
                <a href="#" class="easyui-linkbutton" id="search_teachresources_btn" data-options="selected:true" onclick="app.searchFormPage('teachresources')"><span class="am-icon-search"></span> 查询</a>
              </div>
            </c:if>
          </td>
        </tr>
      </table>
    </form>
    <br/>
  </div>
  <table id="teachresources_page_table" style="width: 100%; height:515px" class="easyui-datagrid" data-options="rownumbers:true"
         url="${pageContext.request.contextPath}/findTeachResourcesPage/find.json"
         toolbar="#teachresources_page_tb"
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
      <th field="name" width="40%">资源名称</th>
      <th field="labelNames" width="20%">标签</th>
      <th field="creator" width="10%">上传者</th>
      <th field="createTime" width="15%" data-options="formatter:function(value){return app.formatDateValue(value, 1, 6);}">上传时间</th>
      <th field="operate" width="15%" data-options="formatter:function(value, row, index){return app.formatString($('#teachresources_page_operate').html(), row.id);}">操作</th>
    </tr>
    </thead>
  </table>
  <!-- table的操作按钮 -->
  <div id="teachresources_page_tb" style="padding:0 30px;">
    <div class="opt-buttons">
      <c:if test="${isShowAddBtn}">
        <a href="#" class="easyui-linkbutton" data-options="selected:true" onclick="addTeachResources()"><span class="am-icon-plus"></span> 添加资源</a>
      </c:if>
    </div>
  </div>
  <!-- 每行的操作按钮 -->
  <div id="teachresources_page_operate" style="display: none;">
    <c:if test="${isShowFindBtn}">
      <a class="am-badge am-badge-secondary am-radius am-text-xs" onClick="findTeachResourcesInfo('{0}')"><span class="am-icon-th-list"></span> 查看</a>
    </c:if>
    <c:if test="${isShowDelBtn}">
      <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="delTeachResources('{0}')"><span class="am-icon-trash-o"></span> 删除</a>
    </c:if>
  </div>
</div>
<%@ include file="../../common/loadGrid.jsp"%>
<script>
  function addTeachResources(){
    app.openDialog("${pageContext.request.contextPath}/addTeachResources/open.html", "添加客观题", 1000, 700, function(index){
      var name = $("#add_name").val().trim();
      var content = UE.getEditor('add_teachresources_reference').getContent();
      var labels = "";

      $("[name=labels_cb]").each(function(){
        if($(this).is(":checked")){
          labels += $(this).val()+",";
        }
      });

      if(name == ""){
        app.msg("请输入资源名称", 1);
        return;
      }
      if(content == ""){
        app.msg("请输入资源内容", 1);
        return;
      }

      if(0 < labels.length) {
        $("#labels").val(labels.substring(0, labels.length-1));
      }
      app.add("${pageContext.request.contextPath}/addTeachResources/add.json", $('#addForm').serialize(), index, "teachresources");
    });
  }

  function findTeachResourcesInfo(id){
    app.openOneBtnDialog('${pageContext.request.contextPath}/findTeachResourcesById/find.html?id='+id, '查看', 1000, 700);
  }

  function delTeachResources(id){
    app.del("您确定要删除该资源？", '${pageContext.request.contextPath}/delTeachResources/del.json', {"id":id}, "teachresources");
  }
</script>
