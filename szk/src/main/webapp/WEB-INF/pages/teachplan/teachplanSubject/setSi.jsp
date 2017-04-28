<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  设置题目div  -->
<div id="changeOiDiv">
  <form class="am-form" id="addForm" name="addForm" method="post">
    <input type="hidden" name="tpsId" value="${param.id}" />
    <input type="hidden" id="delTpssiIds" name="delTpssiIds" />
    <div class="am-g am-margin-top">
      <div class="am-u-sm-2 am-text-right"><label >开始时间：</label></div>
      <div class="am-u-sm-7">
        <input type="text" id="add_beginTime" name="beginTime" class="Wdate" placeholder="选择开始时间" value="${teachPlanSubject.subjectiveBeginTime}"
               style="width: 175px; height: 28px;" onfocus="WdatePicker({readOnly:true, dateFmt:'yyyy-MM-dd HH:mm'})"/>
      </div>
      <div class="am-u-sm-10">*必填</div>
    </div>

    <div class="am-g am-margin-top">
      <div class="am-u-sm-2 am-text-right"><label >结束时间：</label></div>
      <div class="am-u-sm-7">
        <input type="text" id="add_endTime" name="endTime" class="Wdate" placeholder="选择结束时间" value="${teachPlanSubject.subjectiveEndTime}"
               style="width: 175px; height: 28px;" onfocus="WdatePicker({readOnly:true, dateFmt:'yyyy-MM-dd HH:mm'})"/>
      </div>
      <div class="am-u-sm-10">*必填</div>
    </div>

    <div class="am-g am-margin-top">
      <div class="am-u-sm-2 am-text-right"><label >题目设置：</label></div>
      <div class="am-u-sm-8" style="float: left">
        <table id="siTable" class="am-table am-table-bordered am-table-striped am-table-hover" style="width:100%;">
          <tr>
            <td colspan="999" style="background-color:#FFF">
              <button class="am-btn am-btn-primary am-btn-sm" type="button" onClick="addSiFindSi()"><span class="am-icon-plus"></span> 添加题目</button>
            </td>
          </tr>
          <tr class="am-primary">
            <th style="width: 70%;">题目</th>
            <th>操作</th>
          </tr>
          <c:forEach var="tpssi" items="${tpssiList}" varStatus="status">
            <tr>
              <td>${tpssi.name}</td>
              <td>
                <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="delSi(this, ${tpssi.id})"><span class="am-icon-trash-o"></span> 删除</a>
                <a class="am-badge am-badge-secondary am-radius am-text-xs" onClick="review(${tpssi.id})"><span class="am-icon-th-list"></span> 评阅</a>
              </td>
            </tr>
          </c:forEach>
        </table>
      </div>
    </div>
  </form>
</div>
<script>
  function addSiFindSi(){
    app.openDialog("${pageContext.request.contextPath}/setTeachPlanSubjectSi/openSi.html", "添加题目", 700, 500, function(index){
      var rows = $("#addSi_findSi_page_table").datagrid("getChecked");
      if(0 < rows.length){
        var table = $("#siTable");
        for(var i=0; i<rows.length; i++){
          var tr = $("<tr></tr>");
          var td = $("<td></td>");
          var td2 = $("<td></td>");
          td.append(rows[i].name+"<input type=\"hidden\" name=\"siIds\" value=\""+rows[i].id+"\" />");
          td2.append("<a class=\"am-badge am-badge-danger am-radius am-text-xs\" onClick=\"delSi(this)\"><span class=\"am-icon-trash-o\"></span> 删除</a>");
          tr.append(td).append(td2);
          table.append(tr);
        }
      }
      layer.close(index);
    });
  }

  function delSi(obj, tpssiId){
    var deltpssiId = $("#delTpssiIds").val();
    if("" == deltpssiId){
      $("#delTpssiIds").val(tpssiId);
    }else {
      $("#delTpssiIds").val(deltpssiId+","+tpssiId);
    }
    $(obj).parent().parent().remove();
  }

  function review(tpssiId){
    app.openOneBtnDialog("${pageContext.request.contextPath}/findTpsoisByTpsIdAndOiIdController/find.html?tpssiId="+tpssiId, "评阅", 1000, 700);
  }
</script>