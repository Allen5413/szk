<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table width="99%">
  <tr>
    <td>
      <div class="am-panel am-panel-primary" style="width:99%; height: 466px; margin:10px 0 0 4px;">
        <div class="am-panel-hd am-cf" data-am-collapse="{target: '#with'}">未关联的工作组：<span class="am-icon-chevron-down am-fr"></span></div>
        <div id="with" class="am-in">
          <table id="notWithTable" class="am-table am-table-bordered am-table-striped am-table-hover" style="width:100%;">
            <c:forEach items="${notWithList}" var="workGroup">
              <tr onclick="clickNotWithGroup(this)">
                <td>
                  [${workGroup.code}]  ${workGroup.name}
                  <input type="hidden" name="wgIds" value="${workGroup.id}" />
                </td>
              </tr>
            </c:forEach>
          </table>
        </div>
      </div>
    </td>
    <td>
      <div class="am-panel am-panel-primary" style="width:99%; height: 466px; margin:10px 4px 0 8px;">
        <div class="am-panel-hd am-cf" data-am-collapse="{target: '#notWith'}">已关联的工作组：<span class="am-icon-chevron-down am-fr"></span></div>
        <div id="notWith" class="am-in">
          <form class="am-form" id="setForm" name="setForm" method="post">
            <input type="hidden" name="wcId" value="${param.wcId}" />
            <table id="withTable" class="am-table am-table-bordered am-table-striped am-table-hover" style="width:100%;">
              <c:forEach items="${withList}" var="workGroup">
                <tr onclick="clickWithGroup(this)">
                  <td>
                    [${workGroup.code}]  ${workGroup.name}
                    <input type="hidden" name="wgIds" value="${workGroup.id}" />
                  </td>
                </tr>
              </c:forEach>
            </table>
          </form>
        </div>
      </div>
    </td>
  </tr>
</table>
<script>
  function clickNotWithGroup(objTr){
    var html = $(objTr).find("td").html();
    $(objTr).remove();

    var table = $("#withTable");
    var tr = $("<tr onclick='clickWithGroup(this)'></tr>");
    var td = $("<td></td>");
    td.append(html);
    tr.append(td);
    table.append(tr);
  }

  function clickWithGroup(objTr){
    var html = $(objTr).find("td").html();
    $(objTr).remove();

    var table = $("#notWithTable");
    var tr = $("<tr onclick='clickNotWithGroup(this)'></tr>");
    var td = $("<td></td>");
    td.append(html);
    tr.append(td);
    table.append(tr);
  }
</script>