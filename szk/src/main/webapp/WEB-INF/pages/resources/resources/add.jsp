<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="am-form" id="addForm" name="addForm" method="post">
  <input type="hidden" id="labels" name="labels" />
  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >标题：</label></div>
    <div class="am-u-sm-4">
      <input class="am-input-sm" type="text" placeholder="输入标题" required id="add_name" name="name"  />
    </div>
    <div class="am-u-sm-5">*必填，不可重复</div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >内容：</label></div>
    <div class="am-u-sm-4">
      <!-- 加载编辑器的容器 -->
      <script id="add_teachresources_reference" name="content" type="text/plain"></script>
      <!-- 配置文件 -->
      <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor1_4_3_3-utf8-jsp/ueditor.config.js"></script>
      <!-- 编辑器源码文件 -->
      <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor1_4_3_3-utf8-jsp/ueditor.all.js"></script>
      <!-- 实例化编辑器 -->
      <script type="text/javascript">
        var ue = UE.getEditor('add_teachresources_reference');
      </script>
    </div>
    <div class="am-u-sm-5">*必填</div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >标签：</label></div>
    <div class="am-u-sm-4">
      <div class="am-panel-group" id="accordion" style="width: 500px;">
        <div class="am-panel am-panel-default">
          <div class="am-panel-hd">
            <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#select_label_div'}">
              选择标签
            </h4>
          </div>
          <div id="select_label_div" class="am-panel-collapse am-collapse">
            <div id="select_label_div_content" class="am-panel-bd">
              <c:if test="${empty labelList}">
                <span style="color: red">暂时还没有标签，请先添加标签</span>
              </c:if>
              <c:if test="${!empty labelList}">
                <c:forEach var="label" items="${labelList}">
                  <input type="checkbox" name="labels_cb" value="${label.id}_${label.name}" />&nbsp;${label.name}&nbsp;&nbsp;
                </c:forEach>
              </c:if>
            </div>
            <a class="am-badge am-badge-secondary am-radius am-text-xs" onClick="addLabel()"><span class="am-icon-plus"></span> 添加标签</a>
          </div>
        </div>
      </div>
    </div>
    <div class="am-u-sm-5"></div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >超链接：</label></div>
    <div class="am-u-sm-4">
      <div class="am-form-group">
        <label class="am-radio-inline">
          <input type="radio" name="isLink" value="0" checked> 否
        </label>
        <label class="am-radio-inline">
          <input type="radio" name="isLink" value="1" > 是
        </label>
      </div>
    </div>
    <div class="am-u-sm-5"></div>
  </div>
</form>
<script>
  function addLabel(){
    app.openDialog("${pageContext.request.contextPath}/addLabel/open.html", "添加标签", 500, 200, function(index){
      var name = $("#add_label_name").val().trim();
      if(name == ""){
        app.msg("请输入标签名称", 1);
        return;
      }
      app.add("${pageContext.request.contextPath}/addLabel/add.json", $('#addLabelForm').serialize(), index, "", function(data){
        var html = $("#select_label_div_content").html();
        if(0 < html.indexOf("暂时还没有标签，请先添加标签")){
          html = "";
        }
        html += "<input type='checkbox' name='labels_cb' value='"+data.id+"_"+data.name+"' />&nbsp;"+data.name+"&nbsp;&nbsp;";
        $("#select_label_div_content").html(html);
      });
    });
  }
</script>