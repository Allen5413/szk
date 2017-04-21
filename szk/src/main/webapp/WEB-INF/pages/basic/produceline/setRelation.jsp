<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/WEB-INF/permission.tld" %>
<div class="container">
  <div class="am-panel am-panel-primary no-margin-bottom" style="width:15%; height: 480px; float: left; margin-left: 5px;">
    <div class="am-panel-hd am-cf">生产线信息</div>
    <div id="notWith" class="am-in">
      <div style="background-color: #fFF;width: 100%;padding: 0.7rem;border-bottom: solid 1px #ddd;">
        <button class="am-btn am-btn-primary am-btn-sm" type="button" onClick="setProduceLineCore()"><span class="am-icon-cog"></span> 关联生产中心</button>
      </div>
      <div class="left-tree">
        <ul id="plTree" class="easyui-tree" style="height: 380px; overflow: auto"></ul>
      </div>
    </div>
  </div>

  <div class="am-panel am-panel-primary no-margin-bottom" style="width:45%; height: 480px; float: left; margin-left: 5px;">
    <div class="am-panel-hd am-cf">关联的产品信息</div>
    <div class="am-in">
      <table id="pl_wc_product_table" style="height:415px; display: none;" class="easyui-datagrid"
             toolbar="#pl_wc_product_tb"
             idField="id"
             fitColumns="true"
             striped="true"
             singleSelect="true"
             loadMsg="数据加载中......">
        <thead>
        <tr>
          <th field="plwcId" checkbox="true"></th>
          <th field="FNAME" width="50%">名称</th>
          <th field="cateGoryName" width="10%">类型</th>
          <th field="qualifiedRate" width="10%">合格率</th>
          <th field="operate" width="30%" data-options="formatter:function(value, row, index){return app.formatString($('#pl_wc_product_operate').html(), row.plcpId);}">操作</th>
        </tr>
        </thead>
      </table>
      <!-- table的操作按钮 -->
      <div id="pl_wc_product_tb" style="padding:0 30px; display: none;">
        <div class="opt-buttons">
          <button class="am-btn am-btn-primary am-btn-sm" type="button" onClick="setCoreProduct()"><span class="am-icon-cog"></span> 关联产品</button>
        </div>
      </div>
      <!-- 每行的操作按钮 -->
      <div id="pl_wc_product_operate" style="display: none;">
        <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="delWithProduct('{0}')"><span class="am-icon-trash-o"></span> 删除</a>
      </div>
    </div>
  </div>
  <div class="am-panel am-panel-primary no-margin-bottom" style="width:38%; height: 480px; float: left; margin-left: 5px;">
    <div class="am-panel-hd am-cf">关联的班组信息</div>
    <div class="am-in">
      <table id="pl_wc_product_cg_table" style="height:415px; display: none;" class="easyui-datagrid" data-options="rownumbers:true"
             toolbar="#pl_wc_product_cg_tb"
             idField="id"
             checkOnSelect="true"
             selectOnCheck="true"
             fitColumns="true"
             loadMsg="数据加载中......">
        <thead>
        <tr>
          <th field="sno" width="6%">序号</th>
          <th field="cgName" width="14%">工作中心</th>
          <th field="wmName" width="10%">班次</th>
          <th field="unit_time_capacity" width="20%">产能（小时）</th>
          <th field="min_batch" width="20%">最小批量</th>
          <th field="operate" width="30%" data-options="formatter:function(value, row, index){return app.formatString($('#pl_wc_product_cg_operate').html(), row.plcpcgId);}">操作</th>
        </tr>
        </thead>
      </table>
      <!-- table的操作按钮 -->
      <div id="pl_wc_product_cg_tb" style="padding:0 30px; display: none;">
        <div class="opt-buttons">
          <button class="am-btn am-btn-primary am-btn-sm" type="button" onClick="setProductCg()"><span class="am-icon-cog"></span> 关联班组</button>
        </div>
      </div>
      <!-- 每行的操作按钮 -->
      <div id="pl_wc_product_cg_operate" style="display: none;">
        <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="delWithProductCg('{0}')"><span class="am-icon-trash-o"></span> 删除</a>
      </div>
    </div>
  </div>
</div>
<script>
  var zNodes = [
    <c:forEach items="${produceLineList}" var="pl" varStatus="status">
      <c:if test="${status.index > 0}">, </c:if>
      {"id":"${pl.id}", "text":"${pl.name}", "state":"closed", "parentId":"0"}
    </c:forEach>
  ];
  $("#plTree").tree({
    data:zNodes,
    animate:true,
    lines:true,
    onBeforeExpand: function(node){
      findChildNode(node);
    },
    onClick: function(node){
      if(0 < node.parentId) {
        findProduct(node.id, node.parentId);
      }
    }
  });

  $("#pl_wc_product_table").datagrid({
    onSelect: function(index, row){
      findCG(row.plcpId);
    }
  });

  function findChildNode(node){
    $.ajax({
      cache: true,
      type: "POST",
      url:"${pageContext.request.contextPath}/findWorkCoreByPlId/find.json",
      data:{"plId":node.id},
      async: false,
      success: function(data) {
        var childNodes = [];
        for(var i=0; i<data.length; i++){
          childNodes.push({id:data[i].id, text:data[i].name, parentId:node.id});
        }
        //先移除所有子节点
        var oldChildNodes = $("#plTree").tree("getChildren", node.target);
        for(var i=0; i<oldChildNodes.length; i++){
          $("#plTree").tree("remove", oldChildNodes[i].target);
        }
        //再重新加载新的子节点
        $("#plTree").tree("append", {
          parent: node.target,
          data: childNodes
        });
      }
    });
  }

  function findProduct(plId, wcId){
    $("#pl_wc_product_table，#pl_wc_product_tb").show();
    $('#pl_wc_product_table').datagrid({
      url:'${pageContext.request.contextPath}/findProductByPlIdAndWcId/find.json'
    });
    $('#pl_wc_product_table').datagrid("load", {plId:plId, wcId:wcId});
  }

  function setProduceLineCore(){
    var selectedNode = $("#plTree").tree("getSelected");
    if(null == selectedNode || 0 < selectedNode.parentId){
      app.msg("请先选择一个生产线", 1);
      return;
    }else{
      var plId = selectedNode.id;
      app.openDialog('${pageContext.request.contextPath}/addProduceLineCore/open.html?plId='+plId, '关联工作中心', 800, 500, function(index){
        var flag = true;
        var msg = "";
        var wcIdObj = {};
        var snoObj = {};
        $("[name=wcIds]").each(function(){
          var wcId = $(this).val();
          if(wcIdObj[wcId]){
            msg += "工作中心不能重复选择！<br />";
            flag = false;
          }else{
            wcIdObj[wcId] = true;
          }
        });
        $("[name=snos]").each(function(){
          var sno = $(this).val();
          if(!vaild.vaildInteger(sno, 1)){
            msg += "请输入一个大于0的正确的序号！<br />";
            flag = false;
          }
          if(snoObj[sno]){
            msg += "序号不能重复选择！<br />";
            flag = false;
          }else{
            snoObj[sno] = true;
          }
        });
        if(!flag){
          app.msg(msg, 1);
          return;
        }
        app.add("${pageContext.request.contextPath}/addProduceLineCore/add.json", $('#setCoreForm').serialize(), index, function(){
          findChildNode(selectedNode);
        });
      });
    }
  }

  function setCoreProduct(){
    var selectedNode = $("#plTree").tree("getSelected");
    if(null == selectedNode || 0 == selectedNode.parentId){
      app.msg("请先选择一个生产线下的工作中心", 1);
      return;
    }
    var plId = selectedNode.parentId;
    var wcId = selectedNode.id;
    app.openDialog('${pageContext.request.contextPath}/addProduceLineCoreProduct/open.html?plId='+plId+'&wcId='+wcId, '关联产品', 800, 500, function(index){
      if(0 < $("#delPlcpIds").val().length) {
        $("#delPlcpIds").val($("#delPlcpIds").val().substring(0, $("#delPlcpIds").val().length - 1));
      }

      var flag = true;
      var msg = "";
      var pIdObj = {};
      $("[name=pIdsForAddP]").each(function(){
        var pId = $(this).val();
        if(pIdObj[pId]){
          msg += "产品不能重复选择！<br />";
          flag = false;
        }else{
          pIdObj[pId] = true;
        }
      });
      $("[name=qualifiedRates]").each(function(){
        var qualifiedRate = $(this).val();
        if(!vaild.vaildNumber(qualifiedRate, 0, 100)){
          msg += "请输入一个0~100的正确的合格率！<br />";
          flag = false;
        }
      });
      if(!flag){
        app.msg(msg, 1);
        return;
      }

      app.add("${pageContext.request.contextPath}/addProduceLineCoreProduct/add.json", $('#setCoreProductForm').serialize(), index, function(){
        findProduct(plId, wcId);
      });
    });
  }

  function delWithProduct(plcpId){
    app.confirm("您确定要删除该产品？", function(){
      $.ajax({
        cache: true,
        type: "POST",
        url:"${pageContext.request.contextPath}/delProduceLineCoreProduct/del.json",
        data:{"id":plcpId},
        async: false,
        success: function(data) {
          app.msg("删除成功", 0);
          $('#pl_wc_product_table').datagrid("reload");
        }
      });
    });
  }

  function findCG(plcpId){
    $("#pl_wc_product_cg_table，#pl_wc_product_cg_tb").show();
    $('#pl_wc_product_cg_table').datagrid({
      url:'${pageContext.request.contextPath}/findPlcpcgByPlcpId/find.json'
    });
    $('#pl_wc_product_cg_table').datagrid("load",{plcpId:plcpId});
  }


  function setProductCg(){
    var selectProduct = $("#pl_wc_product_table").datagrid("getSelected");
    app.openDialog('${pageContext.request.contextPath}/addPlcpcg/open.html?plcpId='+selectProduct.plcpId, '关联班组', 800, 500, function(index){
      if(0 < $("#delPlcpcgIds").val().length) {
        $("#delPlcpcgIds").val($("#delPlcpcgIds").val().substring(0, $("#delPlcpcgIds").val().length - 1));
      }

      var flag = true;
      var msg = "";
      var cgIdsObj = {};
      var snoObj = {};
      $("[name=cgIds]").each(function(){
        var cgId = $(this).val();
        if(cgIdsObj[cgId]){
          msg += "班组不能重复选择！<br />";
          flag = false;
        }else{
          cgIdsObj[cgId] = true;
        }
      });
      $("[name=snos]").each(function(){
        var sno = $(this).val();
        if(!vaild.vaildInteger(sno, 1)){
          msg += "请输入一个大于0的正确的序号！<br />";
          flag = false;
        }
        if(snoObj[sno]){
          msg += "序号不能重复选择！<br />";
          flag = false;
        }else{
          snoObj[sno] = true;
        }
      });
      $("[name=unitTimeCapacitys]").each(function(){
        var unitTimeCapacity = $(this).val();
        if(!vaild.vaildNumber(unitTimeCapacity, 0)){
          msg += "请输入一个大于0的正确的产能！<br />";
          flag = false;
        }
      });
      $("[name=minBatchs]").each(function(){
        var minBatch = $(this).val();
        if(!vaild.vaildInteger(minBatch, 1)){
          msg += "请输入一个大于0的正确的最小批量！<br />";
          flag = false;
        }
      });

      if(!flag){
        app.msg(msg, 1);
        return;
      }
      app.add("${pageContext.request.contextPath}/addPlcpcg/add.json", $('#setProductCgForm').serialize(), index, function(){
        findCG(selectProduct.plcpId);
      });
    });
  }

  function delWithProductCg(plcpcgId){
    app.confirm("您确定要删除该班组？", function(){
      $.ajax({
        cache: true,
        type: "POST",
        url:"${pageContext.request.contextPath}/delPlcpcg/del.json",
        data:{"id":plcpcgId},
        async: false,
        success: function(data) {
          app.msg("删除成功", 0);
          $('#pl_wc_product_cg_table').datagrid("reload");
        }
      });
    });
  }
</script>