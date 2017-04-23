<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  统计答题div  -->
<div id="countAnswerDiv">
  <c:forEach var="json" items="${list}" varStatus="status">
    <div class="am-panel am-panel-primary no-margin-bottom" style="width:99%; margin-left: 5px; margin-top: 10px;">
      <div class="am-panel-hd am-cf">${json.name}</div>
      <div class="am-in">
        <table>
          <tr>
            <td style='width: 200px;' rowspan="5">
              <div id="container${status.index}" style="min-width:200px;height:200px"></div>
            </td>
          </tr>
          <tr height='40px;'>
            <td style='text-align: right; width: 100px;'>回答正确：</td>
            <td style='width: 300px;'>${json.rightCount}</td>
            <td style='text-align: right;  width: 100px;'>正确率：</td>
            <td style='width: 300px;'>${json.rightRatio}%</td>
          </tr>
          <tr height='40px;'>
            <td style='text-align: right;  width: 100px;'>回答错误：</td>
            <td style='width: 300px;'>${json.errorCount}</td>
            <td style='text-align: right;  width: 100px;'>错误率：</td>
            <td style='width: 300px;'>${json.errorRatio}%</td>
          </tr>
          <tr height='40px;'>
            <td style='text-align: right;  width: 100px;'>未回答：</td>
            <td style='width: 300px;'>${json.notAnswerCount}</td>
            <td></td>
            <td></td>
          </tr>
          <tr height='40px;'>
            <td style='text-align: right;  width: 100px;'>平均用时：</td>
            <td style='width: 300px;'>${json.avgTime}</td>
            <td td style='text-align: right;  width: 100px;'>
              <a class="am-badge am-badge-secondary am-radius am-text-xs" onClick="countAnswerInfo(${json.tpsoiId})"><span class="am-icon-th-list"></span> 详情</a>
            </td>
            <td></td>
          </tr>
        </table>
      </div>
    </div>
  </c:forEach>
</div>
<!--   详情div    -->
<div id="countAnswerTable" style="display: none">
  <table id="count_answer_table" style="width: 100%; height:515px" class="easyui-datagrid" data-options="rownumbers:true"
         sortName="id"
         sortOrder="desc"
         checkOnSelect="true"
         selectOnCheck="true"
         fitColumns="true"
         loadMsg="数据加载中......">
    <thead>
    <tr>
      <th field="student_code" width="20%">学号</th>
      <th field="name" width="50%">姓名</th>
      <th field="time_str" width="20%">答题用时</th>
      <th field="is_right" width="10%" data-options="formatter:function(value){if(value == 1){return '回答正确';}else{return '回答错误';}}">答题情况</th>
    </tr>
    </thead>
  </table>
</div>
<script>
  $(function () {
    <c:forEach var="json" items="${list}" varStatus="status">
      var num = "${status.index}";
      $("#container"+num).highcharts({
        chart: {
          plotBackgroundColor: null,
          plotBorderWidth: null,
          plotShadow: false
        },
        credits: {
          text: ''
        },
        title: {
          text: ''
        },
        tooltip: {
          headerFormat: '{series.name}<br>',
          pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
          pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
              enabled: false,
              format: '',
              style: {
                color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
              }
            }
          }
        },
        colors:[
          '#fcff00',//第一个颜色，欢迎加入Highcharts学习交流群294191384
          '#5ac162'//第二个颜色
        ],
        series: [{
          type: 'pie',
          name: '答题比例',
          data: [
            ['正确率', ${json.rightRatio}],
            ['错误率', ${json.errorRatio}]
          ]
        }]
      });
    </c:forEach>
  });


  function countAnswerInfo(tpsoiId){
    $("#countAnswerDiv").hide();
    $("#countAnswerTable").show();
    $("#count_answer_table").datagrid({url:"${pageContext.request.contextPath}/findTpsoisByTpsIdAndOiIdController/find.json?tpsoiId="+tpsoiId});
  }
</script>