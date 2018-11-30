 <%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="am-form" id="editForm" name="editForm" method="post">
  <input type="hidden" id="id" name="id" value="${objectiveItem.id}" />
  <input type="hidden" id="reference" name="reference">
  <input type="hidden" id="answers" name="answers" />
  <input type="hidden" id="labels" name="labels" />
  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >题目：</label></div>
    <div class="am-u-sm-8">
      <textarea rows="4" placeholder="输入题目" id="edit_name" name="name">${objectiveItem.name}</textarea>
    </div>
    <div class="am-u-sm-5">*必填，不可重复</div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >资源参考：</label></div>
    <div class="am-u-sm-4">
      <div id="edit_reference_div" style="display: none;">${objectiveItem.reference}</div>
      <!-- 加载编辑器的容器 -->
      <script id="edit_objectiveitem_reference" name="content" type="text/plain"></script>
      <!-- 配置文件 -->
      <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor1_4_3_3-utf8-jsp/ueditor.config.js"></script>
      <!-- 编辑器源码文件 -->
      <script type="text/javascript" src="${pageContext.request.contextPath}/ueditor1_4_3_3-utf8-jsp/ueditor.all.js"></script>
      <!-- 实例化编辑器 -->
      <script type="text/javascript">
        var ue = UE.getEditor('edit_objectiveitem_reference');
        //判断ueditor 编辑器是否创建成功
        ue.addListener("ready", function () {
          // editor准备好之后才可以使用
          ue.setContent($("#edit_reference_div").html(), false);
        });
      </script>
    </div>
    <div class="am-u-sm-5"></div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >类型：</label></div>
    <div class="am-u-sm-4">
      <div class="am-form-group">
        <label class="am-radio-inline">
          <input type="radio" name="type" value="0" <c:if test="${'0' eq objectiveItem.type}">checked="" </c:if> > 单选
        </label>
        <label class="am-radio-inline">
          <input type="radio" name="type" value="1" <c:if test="${'1' eq objectiveItem.type}">checked="" </c:if> > 多选
        </label>
        <label class="am-radio-inline">
          <input type="radio" name="type" value="2" <c:if test="${'2' eq objectiveItem.type}">checked="" </c:if> > 不定项
        </label>
      </div>
    </div>
    <div class="am-u-sm-5"></div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >选项数：</label></div>
    <div class="am-u-sm-4">
      <div class="am-form-group">
        <label class="am-radio-inline">
          <input type="radio" name="selectCount" value="2" <c:if test="${'2' eq objectiveItem.selectCount}">checked</c:if> onchange="changeSelectCount()"> 2
        </label>
        <label class="am-radio-inline">
          <input type="radio" name="selectCount" value="3" <c:if test="${'3' eq objectiveItem.selectCount}">checked</c:if> onchange="changeSelectCount()"> 3
        </label>
        <label class="am-radio-inline">
          <input type="radio" name="selectCount" value="4" <c:if test="${'4' eq objectiveItem.selectCount}">checked</c:if> onchange="changeSelectCount()"> 4
        </label>
        <label class="am-radio-inline">
          <input type="radio" name="selectCount" value="5" <c:if test="${'5' eq objectiveItem.selectCount}">checked</c:if> onchange="changeSelectCount()"> 5
        </label>
        <label class="am-radio-inline">
          <input type="radio" name="selectCount" value="6" <c:if test="${'6' eq objectiveItem.selectCount}">checked</c:if> onchange="changeSelectCount()"> 6
        </label>
      </div>
    </div>
    <div class="am-u-sm-5"></div>
  </div>

  <div class="am-g am-margin-top">
    <div class="am-u-sm-3 am-text-right"><label >选项：</label></div>
    <div class="am-u-sm-8">
      <table width="580">
        <tr>
          <td><input type="checkbox" id="add_answer_cb1" name="ids" <c:if test="${'1' eq answer1.isAnswer}">checked</c:if> onchange="changeAnswer(this)"></td>
          <td>
            <div id="edit_answer_div1" style="display: none;">${answer1.answer}</div>
            <!-- 加载编辑器的容器 -->
            <script id="add_answer1" name="content" type="text/plain"></script>
            <!-- 实例化编辑器 -->
            <script type="text/javascript">
              var ue2 = UE.getEditor('add_answer1');
              //判断ueditor 编辑器是否创建成功
              ue2.addListener("ready", function () {
                // editor准备好之后才可以使用
                ue2.setContent($("#edit_answer_div1").html(), false);
              });
            </script>
          </td>
        </tr>
        <tr>
          <td><input type="checkbox" id="add_answer_cb2" name="ids" <c:if test="${'1' eq answer2.isAnswer}">checked</c:if> onchange="changeAnswer(this)"></td>
          <td>
            <div id="edit_answer_div2" style="display: none;">${answer2.answer}</div>
            <!-- 加载编辑器的容器 -->
            <script id="add_answer2" name="content" type="text/plain"></script>
            <!-- 实例化编辑器 -->
            <script type="text/javascript">
              var ue3 = UE.getEditor('add_answer2');
              ue3.addListener("ready", function () {
                // editor准备好之后才可以使用
                ue3.setContent($("#edit_answer_div2").html(), false);
              });
            </script>
          </td>
        </tr>
        <tr id="add_answer_tr3">
          <td><input type="checkbox" id="add_answer_cb3" name="ids" <c:if test="${'1' eq answer3.isAnswer}">checked</c:if> onchange="changeAnswer(this)"></td>
          <td>
            <div id="edit_answer_div3" style="display: none;">${answer3.answer}</div>
            <!-- 加载编辑器的容器 -->
            <script id="add_answer3" name="content" type="text/plain"></script>
            <!-- 实例化编辑器 -->
            <script type="text/javascript">
              var ue4 = UE.getEditor('add_answer3');
              ue4.addListener("ready", function () {
                // editor准备好之后才可以使用
                ue4.setContent($("#edit_answer_div3").html(), false);
              });
            </script>
          </td>
        </tr>
        <tr id="add_answer_tr4">
          <td><input type="checkbox" id="add_answer_cb4" name="ids" <c:if test="${'1' eq answer4.isAnswer}">checked</c:if> onchange="changeAnswer(this)"></td>
          <td>
            <div id="edit_answer_div4" style="display: none;">${answer4.answer}</div>
            <!-- 加载编辑器的容器 -->
            <script id="add_answer4" name="content" type="text/plain"></script>
            <!-- 实例化编辑器 -->
            <script type="text/javascript">
              var ue5 = UE.getEditor('add_answer4');
              ue5.addListener("ready", function () {
                // editor准备好之后才可以使用
                ue5.setContent($("#edit_answer_div4").html(), false);
              });
            </script>
          </td>
        </tr>
        <tr id="add_answer_tr5" style="display: none">
          <td><input type="checkbox" id="add_answer_cb5" name="ids" <c:if test="${'1' eq answer5.isAnswer}">checked</c:if> onchange="changeAnswer(this)"></td>
          <td>
            <div id="edit_answer_div5" style="display: none;">${answer5.answer}</div>
            <!-- 加载编辑器的容器 -->
            <script id="add_answer5" name="content" type="text/plain"></script>
            <!-- 实例化编辑器 -->
            <script type="text/javascript">
              var ue6 = UE.getEditor('add_answer5');
              ue6.addListener("ready", function () {
                // editor准备好之后才可以使用
                ue6.setContent($("#edit_answer_div5").html(), false);
              });
            </script>
          </td>
        </tr>
        <tr id="add_answer_tr6" style="display: none">
          <td><input type="checkbox" id="add_answer_cb6" name="ids" <c:if test="${'1' eq answer6.isAnswer}">checked</c:if> onchange="changeAnswer(this)"></td>
          <td>
            <div id="edit_answer_div6" style="display: none;">${answer6.answer}</div>
            <!-- 加载编辑器的容器 -->
            <script id="add_answer6" name="content" type="text/plain"></script>
            <!-- 实例化编辑器 -->
            <script type="text/javascript">
              var ue7 = UE.getEditor('add_answer6');
              ue7.addListener("ready", function () {
                // editor准备好之后才可以使用
                ue7.setContent($("#edit_answer_div6").html(), false);
              });
            </script>
          </td>
        </tr>
      </table>
    </div>
    <div class="am-u-sm-2">*必填</div>
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
    <div class="am-u-sm-3 am-text-right"><label >备注：</label></div>
    <div class="am-u-sm-8">
      <textarea rows="4" placeholder="输入备注" name="remark">${objectiveItem.remark}</textarea>
    </div>
    <div class="am-u-sm-1"></div>
  </div>
</form>
<script>
  var changeLabels = "${objectiveItem.labelIds}";
  var changeLabelArray = changeLabels.split(",");
  if(0 < changeLabelArray.length){
    for(var i=0; i<changeLabelArray.length; i++){
      var changeLabelId = changeLabelArray[i];
      $("[name=labels_cb]").each(function(){
        var value = $(this).val();
        if(value.split("_")[0] == changeLabelId){
          $(this).attr("checked", true);
        }
      });
    }
  }

  changeSelectCount();

  function changeSelectCount(){
    var selectCount = $('input:radio[name="selectCount"]:checked').val();
    for(var i=3; i<7; i++){
      if(Number(selectCount)+1 > i){
        $("#add_answer_tr"+i).show();
      }else{
        $("#add_answer_tr"+i).hide();
      }
    }
  }

  function changeAnswer(obj){
    var type = $('input:radio[name="type"]:checked').val();
    if(type == 0){
      $('input:checkbox[name="ids"]').each(function(){
        $(this).removeAttr("checked");
      });
      obj.checked = true;
    }
  }

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