<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <table id="resource_page_table" style="height:515px" class="easyui-datagrid" data-options="rownumbers:true"
           toolbar="#resource_page_tb"
           idField="id"
           sortName="id"
           sortOrder="desc"
           checkOnSelect="true"
           selectOnCheck="true"
           fitColumns="true"
           loadMsg="数据加载中......">
        <thead>
        <tr>
            <th field="name" width="10%">名称</th>
            <th field="url" width="30%">url</th>
            <th field="remark" width="20%">备注</th>
            <th field="operator" width="8%">操作人</th>
            <th field="operateTime" width="13%" data-options="formatter:function(value){return app.formatDateValue(value, 1, 6);}">操作时间</th>
            <th field="operate" width="20%" data-options="formatter:function(value, row, index){return app.formatString($('#resource_page_operate').html(), row.id);}">操作</th>
        </tr>
        </thead>
    </table>
    <!-- table的操作按钮 -->
    <div id="resource_page_tb" style="padding:0 30px;">
        <div class="opt-buttons">
            <button class="am-btn am-btn-primary am-btn-sm" type="button" onClick="addResource()"><span class="am-icon-plus"></span> 新增</button>
        </div>
    </div>
    <!-- 每行的操作按钮 -->
    <div id="resource_page_operate" style="display: none;">
        <a class="am-badge am-badge-secondary am-radius am-text-xs" onClick="editResource('{0}')"><span class="am-icon-edit"></span> 修改</a>
        <a class="am-badge am-badge-danger am-radius am-text-xs" onClick="delResource('{0}')"><span class="am-icon-trash-o"></span> 删除</a>
    </div>

<script>
    $('#resource_page_table').datagrid({
        url:'${pageContext.request.contextPath}/findResourceByMenuId/find.json?menuId=${param.menuId}'
    });

    function addResource(){
        app.openDialog('${pageContext.request.contextPath}/addResource/open.html?menuId=${param.menuId}', '新增资源', 500, 450, function(index){
            var name = $("#add_name").val().trim();
            var url = $("#add_url").val().trim();
            if(name == ""){
                app.msg("请输入名称", 1);
                return false;
            }
            if(url == ""){
                app.msg("请输入url", 1);
                return false;
            }
            var buttonsArr = [];
            var buttonNameArr = {};
            var buttonCodeArr = {};
            var flag = false;
            //获取按钮信息
            $("input[name^='button_code']").each(function(){
                var buttonIndex = $(this).attr('name').replace('button_code','');
                var buttonName = $("input[name='button_name"+buttonIndex+"']").val().trim();
                if(buttonName == ""){
                    return true;
                }
                if(buttonNameArr[buttonName]){
                    flag = true;
                    return false;
                }
                buttonNameArr[buttonName] = true;
                var buttonCode = $(this).val().trim();
                if(buttonCode == ""){
                    return true;
                }
                if(buttonCodeArr[buttonCode]){
                    flag = true;
                    return false;
                }
                buttonCodeArr[buttonName] = true;
                buttonsArr.push(buttonName+"!_!"+buttonCode);
            });
            if(flag){
                app.msg("按钮名称或编码重复", 1);
                return false;
            }
            $('#buttons').val(buttonsArr.join("!!"));
            $.ajax({
                cache: true,
                type: "POST",
                url:"${pageContext.request.contextPath}/addResource/add.json",
                data:$('#addResourceForm').serialize(),
                async: false,
                success: function(data) {
                    if(data.state == 0){
                        app.msg("提交成功！", 0);
                        $('#resource_page_table').datagrid("reload");
                        layer.close(index);
                    }else{
                        app.msg(data.msg, 1);
                    }
                }
            });
        });
    }

    function editResource(id){
        app.openDialog('${pageContext.request.contextPath}/editResource/open.html?id='+id, '编辑资源', 500, 450, function(index){
            var name = $("#edit_name").val().trim();
            var url = $("#edit_url").val().trim();
            if(name == ""){
                app.msg("请输入名称", 1);
                return false;
            }
            if(url == ""){
                app.msg("请输入url", 1);
                return false;
            }
            var buttonsArr = [];
            var buttonNameArr = {};
            var buttonCodeArr = {};
            var flag = false;
            //获取按钮信息
            $("input[name^='button_code']").each(function(){
                var buttonIndex = $(this).attr('name').replace('button_code','');
                var buttonName = $("input[name='button_name"+buttonIndex+"']").val().trim();
                if(buttonName == ""){
                    return true;
                }
                if(buttonNameArr[buttonName]){
                    flag = true;
                    return false;
                }
                buttonNameArr[buttonName] = true;
                var buttonCode = $(this).val().trim();
                if(buttonCode == ""){
                    return true;
                }
                if(buttonCodeArr[buttonCode]){
                    flag = true;
                    return false;
                }
                var buttonId = $("input[name='button_id"+buttonIndex+"']").val().trim();
                buttonCodeArr[buttonName] = true;
                buttonsArr.push(buttonName+"!_!"+buttonCode+"!_!"+buttonId);
            });
            if(flag){
                app.msg("按钮名称或编码重复", 1);
                return false;
            }
            $('#buttons').val(buttonsArr.join("!!"));
            $.ajax({
                cache: true,
                type: "POST",
                url:"${pageContext.request.contextPath}/editResource/editor.json",
                data:$('#editResourceForm').serialize(),
                async: false,
                success: function(data) {
                    if(data.state == 0){
                        app.msg("提交成功！", 0);
                        $('#resource_page_table').datagrid("reload");
                        layer.close(index);
                    }else{
                        app.msg(data.msg, 1);
                    }
                }
            });
        });
    }

    function delResource(id){
        app.confirm("您确定要删除该资源信息？", function(){
            $.ajax({
                url:"${pageContext.request.contextPath}/delReource/del.json",
                method : 'POST',
                async:false,
                data:{"id":id},
                success:function(data){
                    if(data.state == 0){
                        app.msg("删除成功！", 0);
                        $('#resource_page_table').datagrid("reload");
                        layer.close(index);
                    }else {
                        app.msg(data.msg, 1);
                    }
                }
            });
        });
    }
</script>