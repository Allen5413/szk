<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" uri="/WEB-INF/permission.tld" %>
<br /><br />
<div class="opt-buttons" style="padding-left: 10px;">
  <a id="teachSetBtn" href="#" class="easyui-linkbutton" data-options="selected:true" onclick="changeSet(1)">教学设置</a>
  <a id="studentSetBtn" href="#" class="easyui-linkbutton" data-options="selected:false" onclick="changeSet(2)">学员设置</a>
  <a id="subjectSetBtn" href="#" class="easyui-linkbutton" data-options="selected:false" onclick="changeSet(3)">专题设置</a>
</div>
<div id="info_div">
  <%@ include file="searchInfo.jsp"%>
</div>
<div id="student_div" style="display: none; margin: 10px 0 0 10px;">
  <%@ include file="../teachplanStudent/searchStudent.jsp"%>
</div>
<div id="subject_div" style="display: none; margin: 10px 0 0 10px;">
  <%@ include file="../teachplanSubject/searchSubject.jsp"%>
</div>
<script>
  function changeSet(flag){
    if(1 == flag){
      $("#teachSetBtn").linkbutton({selected:true});
      $("#studentSetBtn").linkbutton({selected:false});
      $("#subjectSetBtn").linkbutton({selected:false});
      $("#info_div").show();
      $("#student_div, #subject_div").hide();
    }
    if(2 == flag){
      $("#studentSetBtn").linkbutton({selected:true});
      $("#teachSetBtn").linkbutton({selected:false});
      $("#subjectSetBtn").linkbutton({selected:false});
      $("#student_div").show();
      $("#info_div, #subject_div").hide();
      $("#search_student_page_table").datagrid("load");
    }
    if(3 == flag){
      $("#subjectSetBtn").linkbutton({selected:true});
      $("#studentSetBtn").linkbutton({selected:false});
      $("#teachSetBtn").linkbutton({selected:false});
      $("#subject_div").show();
      $("#student_div, #info_div").hide();
      $("#search_subject_page_table").datagrid("load");
    }
  }
</script>