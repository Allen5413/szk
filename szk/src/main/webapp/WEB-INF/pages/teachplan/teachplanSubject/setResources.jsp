<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  设置题目div  -->
<div id="changeOiDiv">
  <form class="am-form" id="addForm" name="addForm" method="post">
    <input type="hidden" name="tpsId" value="${param.id}" />
    <input type="hidden" id="delTpsrIds" name="delTpsrIds" />
    <div class="am-g am-margin-top">
      <div class="am-u-sm-2 am-text-right"><label >开始时间：</label></div>
      <div class="am-u-sm-7">
        <input type="text" id="add_beginTime" name="beginTime" class="Wdate" placeholder="选择开始时间" value="${teachPlanSubject.resourceBeginTime}"
               style="width: 175px; height: 28px;" onfocus="WdatePicker({readOnly:true, dateFmt:'yyyy-MM-dd HH:mm'})"/>
      </div>
      <div class="am-u-sm-10">*必填</div>
    </div>

    <div class="am-g am-margin-top">
      <div class="am-u-sm-2 am-text-right"><label >结束时间：</label></div>
      <div class="am-u-sm-7">
        <input type="text" id="add_endTime" name="endTime" class="Wdate" placeholder="选择结束时间" value="${teachPlanSubject.resourceEndTime}"
               style="width: 175px; height: 28px;" onfocus="WdatePicker({readOnly:true, dateFmt:'yyyy-MM-dd HH:mm'})"/>
      </div>
      <div class="am-u-sm-10">*必填</div>
    </div>

    <div class="am-g am-margin-top">
      <div class="am-u-sm-2 am-text-right"><label >资源设置：</label></div>
      <div class="am-u-sm-8" style="float: left">
        <table id="resourcesTable" class="am-table am-table-bordered am-table-striped am-table-hover" style="width:100%;">
          <tr>
            <td colspan="999" style="background-color:#FFF">
              <button class="am-btn am-btn-primary am-btn-sm" type="button" onClick="addResourcesFindResources()"><span class="am-icon-plus"></span> 资源题目</button>
            </td>
          </tr>
          <tr class="am-primary">
            <th style="width: 80%;">资源名称</th>
            <th>操作</th>
          </tr>
          <c:forEach var="tpsr" items="${tpsrList}" varStatus="status">
            <tr>
              <td>${tpsr.name}</td>
              <td>
                <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="delResources(this, ${tpsr.id})"><span class="am-icon-trash-o"></span> 删除</a>
              </td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </div>
  </form>
</div>
<script>
  function addResourcesFindResources(){
    app.openDialog("${pageContext.request.contextPath}/setTeachPlanSubjectResources/openResources.html", "添加资源", 700, 500, function(index){
      var rows = $("#addResources_findResources_page_table").datagrid("getChecked");
      if(0 < rows.length){
        var table = $("#resourcesTable");
        for(var i=0; i<rows.length; i++){
          var tr = $("<tr></tr>");
          var td = $("<td></td>");
          var td2 = $("<td></td>");
          td.append(rows[i].name+"<input type=\"hidden\" name=\"resourcesIds\" value=\""+rows[i].id+"\" />");
          td2.append("<a class=\"am-badge am-badge-danger am-radius am-text-xs\" onClick=\"delResources(this)\"><span class=\"am-icon-trash-o\"></span> 删除</a>");
          tr.append(td).append(td2);
          table.append(tr);
        }
      }
      layer.close(index);
    });
  }

  function delResources(obj, tpsrId){
    var delTpsrId = $("#delTpsrIds").val();
    if("" == delTpsrId){
      $("#delTpsrIds").val(tpsrId);
    }else {
      $("#delTpsrIds").val(delTpsrId+","+tpsrId);
    }
    $(obj).parent().parent().remove();
  }
</script>