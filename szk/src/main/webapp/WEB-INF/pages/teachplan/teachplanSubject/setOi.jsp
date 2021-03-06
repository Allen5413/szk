<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  设置题目div  -->
<div id="changeOiDiv">
  <form class="am-form" id="addForm" name="addForm" method="post">
    <input type="hidden" name="tpsId" value="${param.id}" />
    <input type="hidden" id="delTpsoiIds" name="delTpsoiIds" />
    <div class="am-g am-margin-top">
      <div class="am-u-sm-2 am-text-right"><label >开始时间：</label></div>
      <div class="am-u-sm-7">
        <input type="text" id="add_beginTime" name="beginTime" class="Wdate" placeholder="选择开始时间" value="${teachPlanSubject.objectiveBeginTime}"
               style="width: 175px; height: 28px;" onfocus="WdatePicker({readOnly:true, dateFmt:'yyyy-MM-dd HH:mm'})"/>
      </div>
      <div class="am-u-sm-10">*必填</div>
    </div>

    <div class="am-g am-margin-top">
      <div class="am-u-sm-2 am-text-right"><label >结束时间：</label></div>
      <div class="am-u-sm-7">
        <input type="text" id="add_endTime" name="endTime" class="Wdate" placeholder="选择结束时间" value="${teachPlanSubject.objectiveEndTime}"
               style="width: 175px; height: 28px;" onfocus="WdatePicker({readOnly:true, dateFmt:'yyyy-MM-dd HH:mm'})"/>
      </div>
      <div class="am-u-sm-10">*必填</div>
    </div>

    <div class="am-g am-margin-top">
      <div class="am-u-sm-2 am-text-right"><label >题目设置：</label></div>
      <div class="am-u-sm-8" style="float: left">
        <table id="oiTable" class="am-table am-table-bordered am-table-striped am-table-hover" style="width:100%;">
          <tr>
            <td colspan="999" style="background-color:#FFF">
              <button class="am-btn am-btn-primary am-btn-sm" type="button" onClick="addOiFindOi()"><span class="am-icon-plus"></span> 添加题目</button>
              <button class="am-btn am-btn-primary am-btn-sm" type="button" onClick="answerCount()"><span class="am-icon-cog"></span> 答题分析</button>
            </td>
          </tr>
          <tr class="am-primary">
            <th style="width: 80%;">题目</th>
            <th>操作</th>
          </tr>
          <c:forEach var="tpsoi" items="${tpsoiList}" varStatus="status">
            <tr>
              <td>${tpsoi.name}</td>
              <td>
                <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="delOi(this, ${tpsoi.id})"><span class="am-icon-trash-o"></span> 删除</a>
              </td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </div>
  </form>
</div>
<script>
  function addOiFindOi(){
    app.openDialog("${pageContext.request.contextPath}/setTeachPlanSubjectOi/openOi.html", "添加题目", 700, 500, function(index){
      var rows = $("#addOi_findOi_page_table").datagrid("getChecked");
      if(0 < rows.length){
        var table = $("#oiTable");
        for(var i=0; i<rows.length; i++){
          var tr = $("<tr></tr>");
          var td = $("<td></td>");
          var td2 = $("<td></td>");
          td.append(rows[i].name+"<input type=\"hidden\" name=\"oiIds\" value=\""+rows[i].id+"\" />");
          td2.append("<a class=\"am-badge am-badge-danger am-radius am-text-xs\" onClick=\"delOi(this)\"><span class=\"am-icon-trash-o\"></span> 删除</a>");
          tr.append(td).append(td2);
          table.append(tr);
        }
      }
      layer.close(index);
    });
  }

  function delOi(obj, tpsoiId){
    var deltpsoiId = $("#delTpsoiIds").val();
    if("" == deltpsoiId){
      $("#delTpsoiIds").val(tpsoiId);
    }else {
      $("#delTpsoiIds").val(deltpsoiId+","+tpsoiId);
    }
    $(obj).parent().parent().remove();
  }

  function answerCount(){
    app.openOneBtnDialog("${pageContext.request.contextPath}/countOiAnswer/open.html?tpsId=${teachPlanSubject.id}", "答题分析", 1000, 700);
  }
</script>