<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="am-form am-form-horizontal" style="margin-top: 10px;" id="editForm" method="post">
  <input type="hidden" name="id" value="${workTime.id}" />

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >编号：</label></div>
    <div class="am-u-sm-4">
      <input class="am-input-sm" type="text" placeholder="输入编号" required id="edit_code" name="code" value="${workTime.code}"  />
    </div>
    <div class="am-u-sm-5">*必填，不可重复</div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >名称：</label></div>
    <div class="am-u-sm-4">
      <input class="am-input-sm" type="text" placeholder="输入名称" required id="edit_name" name="name" value="${workTime.name}"  />
    </div>
    <div class="am-u-sm-5">*必填，不可重复</div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >开始时间：</label></div>
    <div class="am-u-sm-4">
      <input type="text" id="edit_beginTime" name="beginTime" class="Wdate" placeholder="选择开始时间" style="width: 175px; height: 28px;"
             onfocus="WdatePicker({readOnly:true, dateFmt:'HH:mm'})" value="${workTime.beginTimeStr}"/>
    </div>
    <div class="am-u-sm-5">*必填</div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >结束时间：</label></div>
    <div class="am-u-sm-4">
      <input type="text" id="edit_endTime" name="endTime" class="Wdate" placeholder="选择结束时间" style="width: 175px; height: 28px;"
             onfocus="WdatePicker({readOnly:true, dateFmt:'HH:mm'})" value="${workTime.endTimeStr}"/>
    </div>
    <div class="am-u-sm-5">*必填</div>
  </div>
  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >顺序号：</label></div>
    <div class="am-u-sm-4">
      <input type="number" id="edit_sno" value="${workTime.sno}" name="sno" min="1" placeholder="输入序号" style="width: 175px; height: 28px;"/>
    </div>
    <div class="am-u-sm-5">*必填，不可重复</div>
  </div>
</form>