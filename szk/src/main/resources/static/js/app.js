(function($) {
  'use strict';
  $(function() {
    $('#admin-fullscreen').on('click', function() {
      $.AMUI.fullscreen.toggle();
    });

    var getWindowHeight = $(window).height(),
      myappLoginBg = $('.myapp-login-bg');
    myappLoginBg.css('min-height',getWindowHeight + 'px');

    //加载弹出框样式
    layer.config({skin: 'layer-ext-moon', extend:'skin/moon/style.css'});

    //初始化单选复选框样式
    $("input[type='checkbox'], input[type='radio']").uCheck();

    //解决内容页面不能选中文字问题
    //谷歌
    $(".am-tabs-bd").css("-webkit-user-select", "auto");
    $(".am-tabs-bd").css("-webkit-user-drag", "auto");
    //ie
    $(".am-tabs-bd").css("-ms-user-select", "auto");
    $(".am-tabs-bd").css(" -ms-touch-select", "auto");

  });
})(jQuery);

var app = new App();
function App(){
}


/**
 * alert
 * @param msg
 * @param flag
 */
App.prototype.alert = function(msg, flag){
    if(flag == 0){
        //成功的提示
        layer.alert(msg, {icon: 6});
    }else{
        //失败的提示
        layer.alert(msg, {icon: 5});
    }
}

/**
 * 消息提示
 * @param msg
 * @param flag
 */
App.prototype.msg = function(msg, flag){
    if(flag == 0){
        //成功的提示
        layer.msg(msg, {icon: 6});
    }else{
        //失败的提示
        layer.msg(msg, {icon: 5});
    }
}

App.prototype.confirm = function(content, fun){
    layer.confirm(content, {icon: 3, title:'提示'}, function(index){
        fun();
    });
}

/**
 * 初始化妹纸ui样式的select下拉框
 */
App.prototype.initAmazeSelect = function(){
    $("select").each(function(){
        if($(this).attr("lang") == "amaze_select"){
            $(this).selected();
        }
    });
}

/**
 * 打开一个弹出框，只有关闭按钮
 * @param html
 * @param title
 * @param width
 * @param height
 */
App.prototype.openOneBtnDialog = function(url, title, width, height){
    $.ajax({
        cache: true,
        type: "POST",
        url: url,
        async: false,
        success: function (data) {
            var dialogWidth = app.getWindowWidthSize()*width+'px';
            var dialogHeight = app.getWindowHeightSize()*height+'px';
            if(width > 5){
                dialogWidth = width+'px';
            }
            if(height > 5){
                dialogHeight = height+'px';
            }
            var index = layer.open({
                type: 1,
                title: title,
                area: [dialogWidth, dialogHeight],
                shadeClose: true, //点击遮罩关闭
                content: data,
                shadeClose: false,
                btn: ['关闭'],
                btn2: function(index, layero){
                    layer.close(index);
                }
            });
        }
    });
}

/**
 * 打开一个弹出框
 * @param url
 * @param title
 * @param width
 * @param height
 */
App.prototype.openDialog = function(url, title, width, height, func){
    $.ajax({
        cache: true,
        type: "POST",
        url: url,
        async: false,
        success: function (data) {
            var dialogWidth = app.getWindowWidthSize()*width+'px';
            var dialogHeight = app.getWindowHeightSize()*height+'px';
            if(width > 5){
                dialogWidth = width+'px';
            }
            if(height > 5){
                dialogHeight = height+'px';
            }
            var index = layer.open({
                type: 1,
                title: title,
                area: [dialogWidth, dialogHeight],
                shadeClose: true, //点击遮罩关闭
                content: data,
                shadeClose: false,
                btn: ['提交', '关闭'],
                yes: function(index, layero){
                    func(index);
                },btn2: function(index, layero){
                    layer.close(index);
                }
            });
        }
    });
}

/**
 * 打开一个弹出框, 带下一步按钮
 * @param html
 * @param title
 * @param width
 * @param height
 */
App.prototype.openNextBtnDialog = function(url, title, width, height, func){
    $.ajax({
        cache: true,
        type: "POST",
        url: url,
        async: false,
        success: function (data) {
            var dialogWidth = app.getWindowWidthSize()*width+'px';
            var dialogHeight = app.getWindowHeightSize()*height+'px';
            if(width > 5){
                dialogWidth = width+'px';
            }
            if(height > 5){
                dialogHeight = height+'px';
            }
            var index = layer.open({
                type: 1,
                title: title,
                area: [dialogWidth, dialogHeight],
                shadeClose: true, //点击遮罩关闭
                content: data,
                shadeClose: false,
                btn: ['下一步', '关闭'],
                yes: function(index, layero){
                    func(index);
                },btn2: function(index, layero){
                    layer.close(index);
                }
            });
        }
    });
}

/**
 * 打开一个弹出框, 带审核按钮
 * @param html
 * @param title
 * @param width
 * @param height
 */
App.prototype.openAuditBtnDialog = function(url, title, width, height, func){
    $.ajax({
        cache: true,
        type: "POST",
        url: url,
        async: false,
        success: function (data) {
            var dialogWidth = app.getWindowWidthSize() * width + 'px';
            var dialogHeight = app.getWindowHeightSize() * height + 'px';
            if (width > 5) {
                dialogWidth = width + 'px';
            }
            if (height > 5) {
                dialogHeight = height + 'px';
            }
            var index = layer.open({
                type: 1,
                title: title,
                area: [dialogWidth, dialogHeight],
                shadeClose: true, //点击遮罩关闭
                content: data,
                shadeClose: false,
                btn: ['审核通过', '不通过', '关闭'],
                yes: function (index, layero) {
                    func(index, 0);
                }, btn2: function (index, layero) {
                    func(index, 1);
                }, btn3: function (index, layero) {
                    layer.close(index);
                }
            });
        }
    });
}


/**
 * 得到浏览器的宽
 * @returns {{x: number, y: number}}
 */
App.prototype.getWindowWidthSize = function() {
    return app.getWindowSize().x;
}
/**
 * 得到浏览器的高
 * @returns {{x: number, y: number}}
 */
App.prototype.getWindowHeightSize = function() {
    return app.getWindowSize().y;
}
/**
 * 得到浏览器的高和宽
 * @returns {{x: number, y: number}}
 */
App.prototype.getWindowSize = function() {
    var client = {
        x:0,
        y:0
    };

    if(typeof document.compatMode != 'undefined' && document.compatMode == 'CSS1Compat') {
        client.x = document.documentElement.clientWidth;
        client.y = document.documentElement.clientHeight;
    } else if(typeof document.body != 'undefined' && (document.body.scrollLeft || document.body.scrollTop)) {
        client.x = document.body.clientWidth;
        client.y = document.body.clientHeight;
    }
    return client;
}

/**
 * 添加选项卡
 * @param url
 * @param obj
 * @param name
 */
App.prototype.addTab = function(url, name){
    if ($('#tab').tabs('exists', name)){
        $('#tab').tabs('select', name);
    } else {
        $.ajax({
            cache: true,
            type: "POST",
            url: url,
            async: false,
            success: function (data) {
                $('#tab').tabs('add', {
                    title: name,
                    content: data,
                    closable: true
                });
            }
        });
    }
}



/**
 * 点击查询按钮  根据查询条件重新加载数据
 * @param obj
 * @param url
 */
App.prototype.searchFormPage = function(flag){
    var objForm = $('#'+flag+'_page_form');
    var objTable = $('#'+flag+'_page_table');
    //重新加载表单数据
    objTable.datagrid('reload', formToJson());
    //将表单数据转为json
    function formToJson() {
        var arr = objForm.serializeArray()
        var jsonStr = "";
        jsonStr += '{';
        for (var i = 0; i < arr.length; i++) {
            jsonStr += '"' + arr[i].name + '":"' + arr[i].value + '",'
        }
        jsonStr = jsonStr.substring(0, (jsonStr.length - 1));
        jsonStr += '}'

        var json = JSON.parse(jsonStr)
        return json
    }
}

/**
 * ajax查询数据，组装成表格
 * @param obj
 * @param url
 * @param btnObj
 * @param tableId
 * @param tdNum
 * @param isCheckBox
 */
App.prototype.searchForm = function(obj, url, btnObj, tableId, tdNum, isCheckBox){
    if(url != "") {
        $(btnObj).button('loading');
        setTimeout(function(){
            var params = {};
            if(null != obj){
                params = obj.serialize();
            }
            $.ajax({
                cache: true,
                type: "POST",
                url: url,
                async: false,
                data: params,
                success: function (data) {
                    var table = $("#"+tableId);
                    if(typeof (data.jsonData) == "undefined" || 0 == data.jsonData.length){
                        var tr = $("<tr></tr>");
                        var td = $("<td colspan=\"99\" align=\"center\" style=\"color: red;\">没有找到相关数据</td>");
                        tr.append(td);
                        table.append(tr);
                    }else{
                        for(var i=0; i<data.jsonData.length; i++){
                            var json = data.jsonData[i];
                            var tr = $("<tr></tr>");
                            for(var j=0; j<tdNum; j++){
                                var td;
                                if(j == 0) {
                                    if (isCheckBox) {
                                        td = $("<td>" +
                                        "<label class=\"am-checkbox am-secondary\" style=\"margin-top:5px; margin-left:24px;\">" +
                                            "<input type=\"checkbox\" name=\"cb\" value=\"${json.toStuFie},${json.stuCode},${json.stuName}\" onclick=\"changeColor(this)\" data-am-ucheck>" +
                                        "</label></td>");
                                    } else {
                                        td = $("<td>"+(i+1)+"</td>");
                                    }
                                }else{
                                    td = $("<td>"+json[j]+"</td>");
                                }
                                tr.append(td);
                            }
                            table.append(tr);
                        }
                    }
                }
            });
        }, 100);
    }
}

/**
 * 常用的新增数据的操作，用于列表操作，然后属性列表
 * @param openUrl
 * @param doUrl
 * @param params
 * @param title
 * @param width
 * @param height
 */
App.prototype.add = function(url, params, index, flag, callBack){
    $.ajax({
        cache: true,
        type: "POST",
        url:url,
        data:params,
        async: false,
        success: function(data) {
            if(data.state == 0){
                app.msg('提交成功', 0);
                if(typeof(index) != "undefined") {
                    layer.close(index);
                }
                if(callBack){
                    callBack(data.data);
                }else{
                    $("#search_"+flag+"_btn").click();
                }
            }else{
                app.msg(data.msg, 1);
            }
        }
    });
}

/**
 * 常用的新增数据的操作
 * @param openUrl
 * @param doUrl
 * @param params
 * @param title
 * @param width
 * @param height
 */
App.prototype.add = function(url, params, index, callBack){
    $.ajax({
        cache: true,
        type: "POST",
        url:url,
        data:params,
        async: false,
        success: function(data) {
            if(data.state == 0){
                app.msg('提交成功', 0);
                if(typeof(index) != "undefined") {
                    layer.close(index);
                }
                if(callBack){
                    callBack(data.data);
                }else{
                    $("#search_"+flag+"_btn").click();
                }
            }else{
                app.msg(data.msg, 1);
            }
        }
    });
}

/**
 * 常用的新增数据的操作
 * @param url
 * @param params
 * @param btnId
 * @param callBack
 */
App.prototype.addAjax = function(url,params,btnId,callBack){
    $("#"+btnId).button('loading');
    $.ajax({
        cache: true,
        type: "POST",
        url:url,
        data:params,
        async: false,
        success: function(data) {
            $("#"+btnId).button('reset');
            if(data.state == 0){
                app.msg('提交成功', 0);
                if(callBack){
                    callBack(data.data);
                }
            }else{
                app.msg(data.msg, 1);
            }
        },
        error:function(data){
            $("#"+btnId).button('reset');
            app.msg('服务器异常', 0);
        }
    });
}
/**
 * 常用的新增数据的操作
 * @param url
 * @param params
 * @param isShow
 * @param callBack
 */
App.prototype.getAjaxData = function(url,params,isShow,callBack){
    $.ajax({
        cache: true,
        type: "POST",
        url:url,
        data:params,
        async: false,
        success: function(data) {
            if(data.state == 0){
                if(callBack){
                    callBack(data.data);
                }
            }else{
                app.msg(data.msg, 1);
            }
        },
        error:function(data){
            app.msg('服务器异常', 0);
        }
    });
}
/**
 * 新增有文件上传的数据操作
 * @param url
 * @param formId
 * @param index
 */
App.prototype.addForFile = function(url, formId, index){
    $("#"+formId).ajaxSubmit({
        url : url,
        dataType : 'json',
        success : function(result, statusText){
            if(0 == result.state) {
                if(typeof (result.str) != "undefined") {
                    if ("" == result.str) {
                        app.msg("提交成功！", 0);
                        layer.close(index);
                        $("#searchBtn").click();
                        return 0;
                    } else {
                        app.msg(result.str, 1);
                        return 1;
                    }
                }else{
                    app.msg("提交成功！", 0);
                    layer.close(index);
                    $("#searchBtn").click();
                    return 0;
                }
            }
            if(1 == result.state) {
                app.msg(result.msg, 1);
                return 1;
            }
        }
    });
}

/**
 * 常用的修改数据的操作
 * @param url
 * @param params
 */
App.prototype.edit = function(url, params, index, flag, callBack){
    $.ajax({
        cache: true,
        type: "POST",
        url:url,
        data:params,
        async: false,
        success: function(data) {
            if(data.state == 0){
                app.msg('提交成功', 0);
                if(typeof(index) != "undefined") {
                    layer.close(index);
                }
                if(callBack){
                    callBack(data.data);
                }else{
                    $("#search_"+flag+"_btn").click();
                }
            }else{
                app.msg(data.msg, 1);
            }
        }
    });
}

/**
 * 常用的删除数据的操作
 * @param confirmStr
 * @param url
 * @param btnObj
 */
App.prototype.del = function(confirmStr, url, params, flag, callBack){
    app.confirm(confirmStr, function(){
        setTimeout(function(){
            $.ajax({
                url:url,
                method : 'POST',
                async:false,
                data:params,
                success:function(data){
                    if(data.state == 0){
                        app.msg("删除成功！", 0);
                        if(callBack){
                            callBack(data.data);
                        }else{
                            $("#search_"+flag+"_btn").click();
                        }
                    }else {
                        app.msg(data.msg, 1);
                    }
                }
            });
        }, 100);
    });
}

/**
 * 常用的操作数据的操作
 * @param confirmStr
 * @param url
 * @param btnObj
 */
App.prototype.operator = function(confirmStr, url, params, btnObj){
    app.confirm(confirmStr, function(){
        $(btnObj).button('loading');
        setTimeout(function(){
            $.ajax({
                url:url,
                method : 'POST',
                async:false,
                data:params,
                success:function(data){
                    if(data.state == 0){
                        app.msg("操作成功！", 0);
                        $("#searchBtn").click();
                    }else {
                        app.msg(data.msg, 1);
                        $(btnObj).button('reset');
                    }
                }
            });
        }, 100);
    });
}

/**
 * 由于AMAEI UI的select没有选择为空值的情况，所以模拟选中全部的时候，值为空
 * @param confirmStr
 * @param url
 * @param btnObj
 */
App.prototype.changeSelect = function(obj){
    if("null" == $(obj).find("option:selected").val()){
        $(obj).find("option").removeAttr("selected");
    }
}

/**
 * 日期格式化
 * @param date 可以传毫秒值和日期格式的字符串
 * @param startDate 从 年月日时分秒 哪个开始取
 * @param endDate 从 年月日时分秒 哪个结束
 * @returns {string}
 */
App.prototype.formatDateValue = function(dateValue, startDate, endDate){
    var dateStr="";
    //说明传的是毫秒值
    if(!isNaN(dateValue)){
        var data2 = new Date(dateValue);
        for(var i=startDate; i<=endDate; i++){
            if(i==1){
                dateStr += data2.getFullYear();
            }
            if(i==2){
                if(i > startDate) {
                    dateStr += "-";
                }
                dateStr += getzf(data2.getMonth()+1);
            }
            if(i==3){
                if(i > startDate) {
                    dateStr += "-";
                }
                dateStr += getzf(data2.getDate());
            }
            if(i==4){
                if(i > startDate) {
                    dateStr += " ";
                }
                dateStr += getzf(data2.getHours());
            }
            if(i==5){
                if(i > startDate) {
                    dateStr += ":";
                }
                dateStr += getzf(data2.getMinutes());
            }
            if(i==6){
                if(i > startDate) {
                    dateStr += ":";
                }
                dateStr += getzf(data2.getSeconds());
            }
        }
    }else{
        //说明传的是时间格式字符串
        for(var i=startDate; i<=endDate; i++){
            if(i==1){
                dateStr += dateValue.substring(0,4);
            }
            if(i==2){
                if(i > startDate) {
                    dateStr += "-";
                }
                dateStr += dateValue.substring(5,7);
            }
            if(i==3){
                if(i > startDate) {
                    dateStr += "-";
                }
                dateStr += dateValue.substring(8,10);
            }
            if(i==4){
                if(i > startDate) {
                    dateStr += " ";
                }
                dateStr += dateValue.substring(11,13);
            }
            if(i==5){
                if(i > startDate) {
                    dateStr += ":";
                }
                dateStr += dateValue.substring(14,16);
            }
            if(i==6){
                if(i > startDate) {
                    dateStr += ":";
                }
                dateStr += dateValue.substring(17,19);
            }
        }
    }
    return dateStr;

    //补0操作  
    function getzf(num){
        if(parseInt(num) < 10){
            num = '0'+num;
        }
        return num;
    }
}

/**
 * formatString功能 使用方法：formatString('字符串{0}字符串{0}字符串{1}','第一个变量','第二个变量');
 * @param str
 * @returns 格式化后的字符串
 */
App.prototype.formatString = function(str) {
    for ( var i = 0; i < arguments.length - 1; i++) {
        eval("var re = /\\{" + i + "\\}/g;");
        str = str.replace(re, arguments[i + 1]);
    }
    return str;
};