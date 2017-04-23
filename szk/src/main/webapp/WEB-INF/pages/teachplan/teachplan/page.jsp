<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" uri="/WEB-INF/permission.tld" %>
<p />
<c:set var="isShowAddBtn" value="${my:isPermission(requestScope.resourceId,'add',sessionScope.menuMap)}" />
<c:set var="isShowFindBtn" value="${my:isPermission(requestScope.resourceId,'find',sessionScope.menuMap)}" />
<div class="container" style="padding: 10px 10px 0 10px; overflow:auto; height: 700px;">
  <div class="conditions" style="background-color: #f1f1f1; border: 1px #cacaca solid; height: auto; margin-bottom: 10px;">
    <br/>
    <form id="teachplan_page_form" name="pageForm" method="post">
      <table width="100%">
        <tr>
          <td width="10%" style="text-align: right"><span class="con-span">计划名称：</span></td>
          <td width="14%" style="text-align: left"><input type="text" name="name" style="height: 28px;" value="${param.name}" /></td>
          <td width="10%" style="text-align: right"><span class="con-span">状态：</span></td>
          <td width="14%" style="text-align: left">
            <select lang="amaze_select" id="teachplan_page_state" name="state" data-am-selected="{maxHeight: 500}" onchange="app.changeSelect(this)">
              <option value=""></option>
              <option value="null">全部</option>
              <option value="0" <c:if test="${param.state eq '0'}">selected="selected" </c:if> >进行中</option>
              <option value="1" <c:if test="${param.state eq '1'}">selected="selected" </c:if> >已结束</option>
            </select>
          </td>
          <td style="text-align: left">
            <c:if test="${isShowFindBtn}">
              <div class="opt-buttons" style="padding-left: 20px;">
                <a href="#" class="easyui-linkbutton" id="search_teachplan_btn" data-options="selected:true" onclick="app.searchFormPage('teachplan')"><span class="am-icon-search"></span> 查询</a>
              </div>
            </c:if>
          </td>
        </tr>
      </table>
    </form>
    <br/>
  </div>
  <table id="teachplan_page_table" style="width: 100%; height:515px" class="easyui-datagrid" data-options="rownumbers:true"
         url="${pageContext.request.contextPath}/findTeachPlanPage/find.json"
         toolbar="#teachplan_page_tb"
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
      <th field="tpName" width="60%">计划名称</th>
      <th field="studentCount" width="10%">学生人数</th>
      <th field="uName" width="10%">授课教师</th>
      <th field="state" width="10%">状态</th>
      <th field="operate" width="10%" data-options="formatter:function(value, row, index){return app.formatString($('#teachplan_page_operate').html(), row.id);}">操作</th>
    </tr>
    </thead>
  </table>
  <!-- table的操作按钮 -->
  <div id="teachplan_page_tb" style="padding:0 30px;">
    <div class="opt-buttons">
      <c:if test="${isShowAddBtn}">
        <a href="#" class="easyui-linkbutton" data-options="selected:true" onclick="addTeachPlan()"><span class="am-icon-plus"></span> 创建教学计划</a>
      </c:if>
    </div>
  </div>
  <!-- 每行的操作按钮 -->
  <div id="teachplan_page_operate" style="display: none;">
    <c:if test="${isShowFindBtn}">
      <a class="am-badge am-badge-secondary am-radius am-text-xs" onClick="findDetail('{0}')"><span class="am-icon-th-list"></span> 查看</a>
    </c:if>
  </div>
</div>
<%@ include file="../../common/loadGrid.jsp"%>
<script>
  app.initAmazeSelect();

  function addTeachPlan(){
    app.openDialog("${pageContext.request.contextPath}/addTeachPlan/open.html", "创建教学计划", 600, 400, function(index){
      var name = $("#add_name").val().trim();
      if(name == ""){
        app.msg("请输入计划名称", 1);
        return;
      }
      app.add("${pageContext.request.contextPath}/addTeachPlan/add.json", $('#addForm').serialize(), index, "teachplan");
    });
  }

  function findDetail(id){
    $('#tab').tabs('close', '查看计划')
    app.addTab('${pageContext.request.contextPath}/findTeachPlanById/open.html?id='+id, '查看计划');
  }
</script>
