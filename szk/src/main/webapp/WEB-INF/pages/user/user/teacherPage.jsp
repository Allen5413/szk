<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" uri="/WEB-INF/permission.tld" %>
<p />
<c:set var="isShowAddBtn" value="${my:isPermission(requestScope.resourceId,'add',sessionScope.menuMap)}" />
<c:set var="isShowDelBtn" value="${my:isPermission(requestScope.resourceId,'del',sessionScope.menuMap)}" />
<c:set var="isShowFindBtn" value="${my:isPermission(requestScope.resourceId,'find',sessionScope.menuMap)}" />
<div class="container" style="padding: 10px 10px 0 10px; overflow:auto; height: 700px;">
  <table id="teacher_page_table" style="width: 100%; height:515px" class="easyui-datagrid" data-options="rownumbers:true"
         url="${pageContext.request.contextPath}/findTeacherPage/find.json?type=1"
         toolbar="#teacher_page_tb"
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
      <th field="zz" width="25%">ZZ</th>
      <th field="name" width="25%">姓名</th>
      <th field="operator" width="25%">操作人</th>
      <th field="operateTime" width="15%" data-options="formatter:function(value){return app.formatDateValue(value, 1, 6);}">操作时间</th>
      <th field="operate" width="10%" data-options="formatter:function(value, row, index){return app.formatString($('#teacher_page_operate').html(), row.id);}">操作</th>
    </tr>
    </thead>
  </table>
  <!-- table的操作按钮 -->
  <div id="teacher_page_tb" style="padding:0 30px;">
    <div class="opt-buttons">
      <c:if test="${isShowAddBtn}">
        <a href="#" class="easyui-linkbutton" data-options="selected:true" onclick="addTeacher()"><span class="am-icon-plus"></span> 添加教师</a>
      </c:if>
    </div>
  </div>
  <!-- 每行的操作按钮 -->
  <div id="teacher_page_operate" style="display: none;">
    <c:if test="${isShowDelBtn}">
      <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="delTeacher('{0}')"><span class="am-icon-trash-o"></span> 删除</a>
    </c:if>
  </div>
</div>
<%@ include file="../../common/loadGrid.jsp"%>
<script>
  function addTeacher(){
    app.openDialog("${pageContext.request.contextPath}/addTeacher/open.html", "添加教师", 480, 260, function(index){
      var zz = $("#add_zz").val().trim();
      var name = $("#add_name").val().trim();
      if(zz == ""){
        app.msg("请输入ZZ", 1);
        return;
      }
      if(name == ""){
        app.msg("请输入姓名", 1);
        return;
      }
      app.add("${pageContext.request.contextPath}/addTeacher/add.json", $('#addForm').serialize(), index, "", function(){
          $("#teacher_page_table").datagrid("reload");
      });
    });
  }

  function delTeacher(id){
    app.del("您确定要删除该教师信息？", "${pageContext.request.contextPath}/delUser/del.json", {"id":id}, "", function(){
        $("#teacher_page_table").datagrid("reload");
    });
  }
</script>
