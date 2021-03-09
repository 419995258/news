<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>

<style>
    .text {
        color: red;
        font-size: 20px;
    }
</style>
<script type="text/javascript" charset="utf-8">
    //# sourceURL=main.js
    $(function () {
        showChart();
        var kuan = $("#tab").width();
        $("#MyTable").css("width", kuan + "px");
        FixTable("MyTable", 2, kuan, 900);
        if ($("#MyTable_tableData").height() < 370) {
            $("#MyTable_tableData").css("height", 370);
        }
        //设置分页的margin
        $(".myPage").css("margin-top", ($("#MyTable_tableData").height() - 900) + "px");

    });

    //下转地区
    function toSubArea(areaId) {
        $("#areaId").val(areaId);
        doSubmit();
    }

    //重置
    function resetform() {
        $("input[name='reset']").trigger("click");//触发reset按钮
        $("input[type='checkbox']").each(function (index, item) {
            $(this).attr("checked", false);
            $(this).parent().parent().attr("class", 'ck_model');
        });

    }

    function validateTable(statTime) {
        var flag = true;

        if (statTime != "") {
            var myTable = "STAT_BASE_TEACHER_INFO_" + $.trim(statTime.split("-")[0].substring(2, 4))
                          + "_" + $.trim(statTime.split("-")[1]);
            $.ajax({
                       type: 'post',
                       url: '${root}/base/BaseSchool/isExistsTheTable.jspx',
                       data: {"myTable": myTable},
                       error: function (XMLHttpRequest, textStatus, errorThrown) {
                           $.dialog.tips('XMLHttpRequest.status：' + XMLHttpRequest.status
                                         + ',XMLHttpRequest.readyState:' + XMLHttpRequest.readyState
                                         + ',textStatus:' + textStatus, 2, 'loading.gif');
                       },
                       async: false,
                       success: function (msg) {
                           if (msg == "0") {//不存在表
                               flag = false;
                           }
                       }
                   });
        }
        return flag;
    }

    //分页
    function goToPage(pageNo) {
        var countryToSchoolStatus = $("#countryToSchool").val();
        if (countryToSchoolStatus == 'true') {
            countryToSchool(pageNo);
        } else {
            doSubmit(pageNo);
        }
    }

    function doSubmit(pageNo) {
        if (pageNo == null || pageNo == 'undefined') {
            pageNo = '';
        }
        //判断是否存在统计表
        var statTime = $("#TJSJ").val();
        var flag = true;
        //教师也就不用了
        var countryToSchoolStatus = $("#countryToSchool").val();
        if (countryToSchoolStatus != 'true') {
            flag = validateTable(statTime);
        }
        var countryToSchoolStatus = $("#countryToSchool").val();
        if (countryToSchoolStatus == 'true') {
            $("#FXZBSelect").val('all');
        }

        if (flag) {
            var d = $.dialog.tips('正在执行，请稍候...', 100, 'loading.gif');
            var datas = $("#selectFrm").serialize();
            if (pageNo == '') {
                url = '${root}/base/BaseKpiItem/countryTeacherIndex.jspx'
            } else {
                url = '${root}/base/BaseKpiItem/countryTeacherIndex.jspx?pageNo=' + pageNo
            }
            $.ajax({
                       type: 'post',
                       data: datas,
                       url: url,
                       success: function (msg) {
                           $("#fundsBox").html(msg);
                           d.close();
                       }
                   });
        } else {
            $.dialog.tips('您所查询的统计表不存在！', 2, 'alert.gif', function () {
            });
            $("#TJSJ").val("最新");
        }

    }

    //县点击学校时设置schoolId
    function countryToSchoolFirst(schoolId) {
        if (schoolId == null || schoolId == '') {
            var d = $.dialog.tips('查询错误请重试', 2, 'loading.gif');
            return false;
        }
        $("#schoolId").val(schoolId);
        countryToSchool('');
    }

    //查询不同的学校教师
    function countryToSchool(pageNo) {
        console.log("下转学校显示教师");
        $("#FXZBSelect").val('all');
        if (pageNo == null || pageNo == 'undefined') {
            pageNo = '';
        }
        var d = $.dialog.tips('正在执行，请稍候...', 100, 'loading.gif');
        var datas = $("#selectFrm").serialize();
        if (pageNo == '') {
            url = '${root}/base/BaseKpiItem/countryTeacherIndexShowSchool.jspx'
        } else {
            url = '${root}/base/BaseKpiItem/countryTeacherIndexShowSchool.jspx?pageNo=' + pageNo
        }
        $.ajax({
                   type: 'post',
                   data: datas,
                   url: url,
                   success: function (msg) {
                       $("#fundsBox").html(msg);
                       d.close();
                       //changeShowTable();
                   }
               });
    }

    //绘制图表
    function showChart() {

        //教师也就不用了
        var countryToSchoolStatus = $("#countryToSchool").val();
        if (countryToSchoolStatus = 'true') {
            createChart1(${mapGet['SFZBChart']});
            createChart2(${mapGet['SFXJJYSGGJSChart']});
            createChart3(${mapGet['XRGWDJChart']});
        } else {
            var SFZBCheck = $("#SFZBCheck").attr("checked");
            if (SFZBCheck == 'checked') {
                createChart1(${mapGet['SFZBChart']});
            }
            var SFXJJYSGGJSCheck = $("#SFXJJYSGGJSCheck").attr("checked");
            if (SFXJJYSGGJSCheck == 'checked') {
                createChart2(${mapGet['SFXJJYSGGJSChart']});
            }
            var XRGWDJCheck = $("#XRGWDJCheck").attr("checked");
            if (XRGWDJCheck == 'checked') {
                createChart3(${mapGet['XRGWDJChart']});
            }
        }

    }

    //绘画SFZB图表
    function createChart1(data) {
        //教师显示不同
        var countryToSchoolStatus = $("#countryToSchool").val();
        if (countryToSchoolStatus = 'true') {
            FusionCharts.ready(function () {
                var revenueChart = new FusionCharts({
                                                        type: 'mscolumn2d',
                                                        renderAt: 'chart-container1',
                                                        width: '900',
                                                        height: '350',
                                                        dataFormat: 'json',
                                                        dataSource: {
                                                            "chart": {
                                                                "caption": "教师在编情况",
                                                                "formatNumberScale": "0",
                                                                "subCaption": "单位（人）",
                                                                /*  "xAxisName": "分类显示", */
                                                                /*   "yAxisName": "教师数量 (人)", */
                                                                "bgColor": "#ffffff",
                                                                "borderAlpha": "20",
                                                                "canvasBorderAlpha": "0",
                                                                "usePlotGradientColor": "0",
                                                                "plotBorderAlpha": "10",
                                                                //"plotTooltext": "<b>$label</b></br>$value人</br>占总人数的：$toolText " + value + "%",
                                                                "placevaluesInside": "1",
                                                                "rotatevalues": "1",
                                                                "showXAxisLine": "1",
                                                                "divLineIsDashed": "1",
                                                                "showAlternateHGridColor": "0",
                                                                "subcaptionFontBold": "0",
                                                                "subcaptionFontSize": "14",
                                                                "theme": "fint"
                                                            },
                                                            "categories": [{
                                                                "category": [{
                                                                    "label": "所有教师"
                                                                },
                                                                    {
                                                                        "label": "城镇地区"
                                                                    },
                                                                    {
                                                                        "label": "乡村地区"
                                                                    }]
                                                            }],
                                                            "dataset": data
                                                        }
                                                    }).render();
            });
        } else {
            FusionCharts.ready(function () {
                var revenueChart = new FusionCharts({
                                                        type: 'mscolumn2d',
                                                        renderAt: 'chart-container1',
                                                        width: '900',
                                                        height: '350',
                                                        dataFormat: 'json',
                                                        dataSource: {
                                                            "chart": {
                                                                "caption": "教师在编情况",
                                                                "formatNumberScale": "0",
                                                                "subCaption": "单位（人）",
                                                                /*  "xAxisName": "分类显示", */
                                                                /*   "yAxisName": "教师数量 (人)", */
                                                                "bgColor": "#ffffff",
                                                                "borderAlpha": "20",
                                                                "canvasBorderAlpha": "0",
                                                                "usePlotGradientColor": "0",
                                                                "plotBorderAlpha": "10",
                                                                //"plotTooltext": "<b>$label</b></br>$value人</br>占总人数的：$toolText " + value + "%",
                                                                "placevaluesInside": "1",
                                                                "rotatevalues": "1",
                                                                "showXAxisLine": "1",
                                                                "divLineIsDashed": "1",
                                                                "showAlternateHGridColor": "0",
                                                                "subcaptionFontBold": "0",
                                                                "subcaptionFontSize": "14",
                                                                "theme": "fint"
                                                            },
                                                            "categories": [{
                                                                "category": [{
                                                                    "label": "所有教师"
                                                                },
                                                                    {
                                                                        "label": "城镇地区"
                                                                    },
                                                                    {
                                                                        "label": "乡村地区"
                                                                    }]
                                                            }],
                                                            "dataset": data
                                                        }
                                                    }).render();
            });
        }

    }

    //绘画SFXJJYSGGJS图表
    function createChart2(data) {
        //教师显示不同
        var countryToSchoolStatus = $("#countryToSchool").val();
        if (countryToSchoolStatus = 'true') {
            FusionCharts.ready(function () {
                var revenueChart = new FusionCharts({
                                                        type: 'mscolumn2d',
                                                        renderAt: 'chart-container2',
                                                        width: '900',
                                                        height: '350',
                                                        dataFormat: 'json',
                                                        dataSource: {
                                                            "chart": {
                                                                "caption": "骨干教师分布情况",
                                                                "formatNumberScale": "0",
                                                                "subCaption": "单位（人）",
                                                                /*  "xAxisName": "分类显示", */
                                                                /*   "yAxisName": "教师数量 (人)", */
                                                                "bgColor": "#ffffff",
                                                                "borderAlpha": "20",
                                                                "canvasBorderAlpha": "0",
                                                                "usePlotGradientColor": "0",
                                                                "plotBorderAlpha": "10",
                                                                //"plotTooltext": "<b>$label</b></br>$value人</br>占总人数的：$toolText " + value + "%",
                                                                "placevaluesInside": "1",
                                                                "rotatevalues": "1",
                                                                "showXAxisLine": "1",
                                                                "divLineIsDashed": "1",
                                                                "showAlternateHGridColor": "0",
                                                                "subcaptionFontBold": "0",
                                                                "subcaptionFontSize": "14",
                                                                "theme": "fint"
                                                            },
                                                            "categories": [{
                                                                "category": [{
                                                                    "label": "所有教师"
                                                                },
                                                                    {
                                                                        "label": "城镇地区"
                                                                    },
                                                                    {
                                                                        "label": "乡村地区"
                                                                    }]
                                                            }],
                                                            "dataset": data
                                                        }
                                                    }).render();
            });
        } else {
            FusionCharts.ready(function () {
                var revenueChart = new FusionCharts({
                                                        type: 'mscolumn2d',
                                                        renderAt: 'chart-container2',
                                                        width: '900',
                                                        height: '350',
                                                        dataFormat: 'json',
                                                        dataSource: {
                                                            "chart": {
                                                                "caption": "骨干教师分布情况",
                                                                "formatNumberScale": "0",
                                                                "subCaption": "单位（人）",
                                                                /*  "xAxisName": "分类显示", */
                                                                /*   "yAxisName": "教师数量 (人)", */
                                                                "bgColor": "#ffffff",
                                                                "borderAlpha": "20",
                                                                "canvasBorderAlpha": "0",
                                                                "usePlotGradientColor": "0",
                                                                "plotBorderAlpha": "10",
                                                                //"plotTooltext": "<b>$label</b></br>$value人</br>占总人数的：$toolText " + value + "%",
                                                                "placevaluesInside": "1",
                                                                "rotatevalues": "1",
                                                                "showXAxisLine": "1",
                                                                "divLineIsDashed": "1",
                                                                "showAlternateHGridColor": "0",
                                                                "subcaptionFontBold": "0",
                                                                "subcaptionFontSize": "14",
                                                                "theme": "fint"
                                                            },
                                                            "categories": [{
                                                                "category": [{
                                                                    "label": "所有教师"
                                                                },
                                                                    {
                                                                        "label": "城镇地区"
                                                                    },
                                                                    {
                                                                        "label": "乡村地区"
                                                                    }]
                                                            }],
                                                            "dataset": data
                                                        }
                                                    }).render();
            });
        }

    }

    //绘画XRGWDJ图表
    function createChart3(data) {
        //教师显示不同
        var countryToSchoolStatus = $("#countryToSchool").val();
        if (countryToSchoolStatus = 'true') {
            FusionCharts.ready(function () {
                var revenueChart = new FusionCharts({
                                                        type: 'mscolumn2d',
                                                        renderAt: 'chart-container3',
                                                        width: '900',
                                                        height: '350',
                                                        dataFormat: 'json',
                                                        dataSource: {
                                                            "chart": {
                                                                "caption": "教师岗位等级分布情况",
                                                                "formatNumberScale": "0",
                                                                "subCaption": "单位（人）",
                                                                /*  "xAxisName": "分类显示", */
                                                                /*   "yAxisName": "教师数量 (人)", */
                                                                "bgColor": "#ffffff",
                                                                "borderAlpha": "20",
                                                                "canvasBorderAlpha": "0",
                                                                "usePlotGradientColor": "0",
                                                                "plotBorderAlpha": "10",
                                                                //"plotTooltext": "<b>$label</b></br>$value人</br>占总人数的：$toolText " + value + "%",
                                                                "placevaluesInside": "1",
                                                                "rotatevalues": "1",
                                                                "showXAxisLine": "1",
                                                                "divLineIsDashed": "1",
                                                                "showAlternateHGridColor": "0",
                                                                "subcaptionFontBold": "0",
                                                                "subcaptionFontSize": "14",
                                                                "theme": "fint"
                                                            },
                                                            "categories": [{
                                                                "category": [{
                                                                    "label": "所有教师"
                                                                },
                                                                    {
                                                                        "label": "城镇地区"
                                                                    },
                                                                    {
                                                                        "label": "乡村地区"
                                                                    }]
                                                            }],
                                                            "dataset": data
                                                        }
                                                    }).render();
            });
        } else {
            FusionCharts.ready(function () {
                var revenueChart = new FusionCharts({
                                                        type: 'mscolumn2d',
                                                        renderAt: 'chart-container3',
                                                        width: '900',
                                                        height: '350',
                                                        dataFormat: 'json',
                                                        dataSource: {
                                                            "chart": {
                                                                "caption": "教师岗位等级分布情况",
                                                                "formatNumberScale": "0",
                                                                "subCaption": "单位（人）",
                                                                /*  "xAxisName": "分类显示", */
                                                                /*   "yAxisName": "教师数量 (人)", */
                                                                "bgColor": "#ffffff",
                                                                "borderAlpha": "20",
                                                                "canvasBorderAlpha": "0",
                                                                "usePlotGradientColor": "0",
                                                                "plotBorderAlpha": "10",
                                                                //"plotTooltext": "<b>$label</b></br>$value人</br>占总人数的：$toolText " + value + "%",
                                                                "placevaluesInside": "1",
                                                                "rotatevalues": "1",
                                                                "showXAxisLine": "1",
                                                                "divLineIsDashed": "1",
                                                                "showAlternateHGridColor": "0",
                                                                "subcaptionFontBold": "0",
                                                                "subcaptionFontSize": "14",
                                                                "theme": "fint"
                                                            },
                                                            "categories": [{
                                                                "category": [{
                                                                    "label": "所有教师"
                                                                },
                                                                    {
                                                                        "label": "城镇地区"
                                                                    },
                                                                    {
                                                                        "label": "乡村地区"
                                                                    }]
                                                            }],
                                                            "dataset": data
                                                        }
                                                    }).render();
            });
        }

    }

    function exportExcel() {
        var countryToSchoolStatus = $("#countryToSchool").val();
        if (countryToSchoolStatus == 'true') {
            window.location.href =
                "${root}/base/BaseKpiItem/countryTeacherIndexSchool.jspx?menu=${menu}&schoolId=${schoolId}&sffsbjs=${sffsbjs}&TJSJ=${TJSJ}&areaId=${areaId}&areaCode=${areaCode}&subareaId=${subareaId}&isExcel=1";
        } else {
            window.location.href =
                "${root}/base/BaseKpiItem/countryTeacherIndex.jspx?menu=${menu}&sffsbjs=${sffsbjs}&TJSJ=${TJSJ}&areaId=${areaId}&areaCode=${areaCode}&subareaId=${subareaId}&isExcel=1";
        }
    }

    function exportPdf() {
        var countryToSchoolStatus = $("#countryToSchool").val();
        if (countryToSchoolStatus == 'true') {
            window.location.href =
                "${root}/base/BaseKpiItem/exportPDF.jspx?menu=${menu}&schoolId=${schoolId}&sffsbjs=${sffsbjs}&TJSJ=${TJSJ}&areaId=${areaId}&areaCode=${areaCode}&subareaId=${subareaId}&isPdf=1&leftmenu=countrySchool";
        } else {
            window.location.href =
                "${root}/base/BaseKpiItem/exportPDF.jspx?menu=${menu}&sffsbjs=${sffsbjs}&TJSJ=${TJSJ}&areaId=${areaId}&areaCode=${areaCode}&subareaId=${subareaId}&isPdf=1&leftmenu=countryMain";
        }
    }

    //分析报告导出pdf
    function exportRePDF() {
        //l:横向， p：纵向； 单位： in:英寸，mm毫米；px：像素；  画布大小：默认是A4纸大小
        var pdf = new jsPDF('p', 'mm', [230, 250]); //230 x 250
        var str = $('#exportRePDF');

        //添加字，以及字体大小设置
        //pdf.setFontSize(40);
        //pdf.text(35, 25, "乡村教师基本情况分析-现状");

        html2canvas([str.get(0)], {
            scale: 2,
            onrendered: function (canvas) {
                var imgData = canvas.toDataURL();
                pdf.addImage(imgData, 'JPEG', 20, 10, 200, 35); //第3、4个参数是位置（x,y），第5、6个参数是宽，高

                //获取图表数据截图
                $('#myCanvas01').show();
                var svgHtml = document.getElementById(
                    $("#chart-container1 > span")[0].id).innerHTML;
                canvg('myCanvas01', svgHtml);
                $('#myCanvas02').show();
                var svgHtml = document.getElementById(
                    $("#chart-container2 > span")[0].id).innerHTML;
                canvg('myCanvas02', svgHtml);
                $('#myCanvas03').show();
                var svgHtml = document.getElementById(
                    $("#chart-container3 > span")[0].id).innerHTML;
                canvg('myCanvas03', svgHtml);

                var elementLength = 1;
                lableDivLength = 0;
                $('#all').html2canvas({}, function (imgData, w, h) {
                    $('#myCanvas01').hide();
                    var img = imgData;
                    pdf.addImage(img, 'JPEG', 20, 50, 200, 200); //第3、4个参数是位置（x,y），第5、6个参数是宽，高

                    lableDivLength++;

                });

                //这里是异步的，如果保存在外面则保存空图，因为数据还没截图下来
                //最后save 
                var myInterval = setInterval(function () {
                    if (lableDivLength == elementLength) {
                        clearInterval(myInterval);
                        pdf.save('分析报告.pdf');
                    }
                }, 1000);

            }
        });

    }


</script>

<!-- countryTeacher/main.jsp -->
<%-- <%@ include file="menu_third.jsp"%> --%>
<input type="hidden" id="htmlIs" value="countryTeacherIndex"/>
<input type="hidden" id="htmlSSXD" value="${SSXD }"/>
<div class="aside">
    <ul>
        <li <c:if test="${menuFlag_2 eq 'index'}">class="on"</c:if>><a href="#" class="a3"
                                                                       onclick="changeUrl('${root}/base/BaseKpiItem/countryTeacherIndex.jspx?FXZBSelect=all&menu=${SSXD }',this,'${SSXD }');"
                                                                       style="cursor:pointer">基本情况</a>
        </li>
        <li <c:if test="${menuFlag_2 eq 'money'}">class="on"</c:if>><a href="#" class="a4"
                                                                       onclick="changeUrl('${root}/base/BaseKpiItem/countryTeacherMoney.jspx?FXZBSelect=all&menu=${SSXD }',this,'${SSXD }');"
                                                                       style="cursor:pointer">基本待遇</a>
        </li>
        <li <c:if test="${menuFlag_2 eq 'honor'}">class="on"</c:if>><a href="#" class="a5"
                                                                       onclick="changeUrl('${root}/base/BaseKpiItem/countryTeacherHonor.jspx?menu=${SSXD }',this,'${SSXD }');"
                                                                       style="cursor:pointer">教师荣誉</a>
        </li>
    </ul>
</div>
<div class="main" style="padding-top: 40px;">
    <div class="main_inner">
        <form id="selectFrm" action="">
            <input type="hidden" name="areaId" id="areaId" value="${areaId}">
            <input type="hidden" name="areaCode" id="areaCode" value="${areaCode}">
            <input type="hidden" name="menu" id="menu" value="${SSXD}">
            <input type="reset" name="reset" style="display: none;"/>
            <input type="hidden" name="countryToSchool" id="countryToSchool"
                   value="${countryToSchool }">
            <input type="hidden" name="schoolId" id="schoolId" value="${schoolId }">
            <input type="hidden" name="FXZBSelect" id="FXZBSelect" value="${FXZBSelect }">


            <div class="title">筛选条件<!-- <a href="#" class="add"></a> --><span class="pot"></span>
            </div>
            <c:if test="${countryToSchool ne 'true'}">
                <div class="sort sort_act sort_act3">
                    <div class="btn">
                        <c:if test="${countryToSchool ne 'true'}">
                            <a href="###" onclick="doSubmit();">筛选</a>
                        </c:if>
                        <c:if test="${countryToSchool eq 'true'}">
                            <a href="###" onclick="countryToSchool('');">筛选</a>
                        </c:if>
                        <a href="###" onclick="resetform();">重置</a>
                    </div>
                    <ul>
                        <li>
                            <label>分析指标：</label>
                            <p>
                                <label class="ck_model"><span><input name="FXZB" type="checkbox"
                                                                     id="allCb_FXZB" value="all"
                                                                     onclick="checkAll2('FXZB');" ${all}></span>所有</label>
                                <label class="ck_model"><span><input type="checkbox" id="SFZBCheck"
                                                                     name="FXZB" value="SFZB"
                                                                     onclick="everyCheckboxClick(this);" ${SFZB}/></span>在编</label>
                                <label class="ck_model"><span><input type="checkbox"
                                                                     id="SFXJJYSGGJSCheck"
                                                                     name="FXZB" value="SFXJJYSGGJS"
                                                                     onclick="everyCheckboxClick(this);"  ${SFXJJYSGGJS}/></span>骨干</label>
                                <label class="ck_model"><span><input type="checkbox"
                                                                     id="XRGWDJCheck" name="FXZB"
                                                                     value="XRGWDJ"
                                                                     onclick="everyCheckboxClick(this);"  ${XRGWDJ}/></span>岗位级别</label>
                            </p>
                        </li>
                        <li>
                            <label>统计时间：</label>
                            <p>
                                <select name="TJSJ" id="TJSJ">
                                    <option value="">最新</option>
                                    <c:forEach items="${my431fn:getDatesFromSomeDate()}" var="dat">
                                        <option value="${dat }"
                                                <c:if test="${TJSJ eq dat}">selected="selected"</c:if>>${dat }</option>
                                    </c:forEach>
                                </select>
                                <span class="label">附设班：</span>
                                <select name="sffsbjs" style="width:200px">
                                    <option value="">全部</option>
                                    <option value="1"
                                            <c:if test="${sffsbjs eq 1}">selected="selected"</c:if>>
                                        是
                                    </option>
                                    <option value="0"
                                            <c:if test="${sffsbjs eq 0}">selected="selected"</c:if>>
                                        否
                                    </option>
                                </select>
                            </p>
                        </li>
                    </ul>

                </div>
            </c:if>
        </form>

        <div style="height:40px;"></div>
        <div class="title"><a href="#" class="export" onclick="exportRePDF()"></a> 输出显示
            <span class="pot"></span>
            <c:if test="${fn:startsWith(areaCode, wsAreaCode)}">
                <c:if test="${fn:length(areaCode)<=3}">
                    <a href="###"
                       style="margin-left: 120px;">${my431fn:getAreaByCodeOne(areaCode).areaName}</a>
                </c:if>
                <c:if test="${fn:length(areaCode)==6}">
                    <c:if test="${fn:length(wsAreaCode)<=3}">
                        <a href="###"
                           onclick="toSubArea('${my431fn:getAreaByCodeOne(fn:substring(areaCode,0,3)).id}');"
                           style="margin-left: 90px;">${my431fn:getAreaByCodeOne(fn:substring(areaCode,0,3)).areaName}</a> >
                    </c:if>
                    <c:if test="${fn:length(wsAreaCode) eq 6}">
                        <a href="###"
                           style="margin-left: 120px;">${my431fn:getAreaByCodeOne(areaCode).areaName}</a>
                    </c:if>
                    <c:if test="${fn:length(wsAreaCode) ne 6}">
                        <a href="###">${my431fn:getAreaByCodeOne(areaCode).areaName}</a>
                    </c:if>
                </c:if>
                <c:if test="${fn:length(areaCode)==9}">
                    <c:if test="${fn:length(wsAreaCode)<=3}">
                        <a href="###"
                           onclick="toSubArea('${my431fn:getAreaByCodeOne(fn:substring(areaCode,0,3)).id}');"
                           style="margin-left: 90px;">${my431fn:getAreaByCodeOne(fn:substring(areaCode,0,3)).areaName}</a> >
                    </c:if>
                    <c:if test="${fn:length(wsAreaCode)<=6}">
                        <a href="###"
                           onclick="toSubArea('${my431fn:getAreaByCodeOne(fn:substring(areaCode,0,6)).id}');">${my431fn:getAreaByCodeOne(fn:substring(areaCode,0,6)).areaName}</a> >
                    </c:if>
                    <c:if test="${countryToSchool ne 'true'}">
                        <c:if test="${fn:length(wsAreaCode) eq 9}">
                            <a href="###"
                               style="margin-left: 120px;">${my431fn:getAreaByCodeOne(areaCode).areaName}</a>
                        </c:if>
                        <c:if test="${fn:length(wsAreaCode) ne 9}">
                            <a href="###">${my431fn:getAreaByCodeOne(areaCode).areaName}</a>
                        </c:if>
                    </c:if>
                    <c:if test="${countryToSchool eq 'true'}">
                        <c:if test="${fn:length(wsAreaCode) eq 9}">
                            <a href="###"
                               style="margin-left: 120px;">${my431fn:getAreaByCodeOne(areaCode).areaName}</a>
                        </c:if>
                        <c:if test="${fn:length(wsAreaCode) ne 9}">
                            <a href="###"
                               onclick="toSubArea('${my431fn:getAreaByCodeOne(areaCode).id}')">${my431fn:getAreaByCodeOne(areaCode).areaName}</a>
                        </c:if>
                    </c:if>

                </c:if>
            </c:if>
        </div>
        <div class="exportBox">
            <h3>乡村教师基本情况分析-现状</h3>
            <div class="inner" style="padding-bottom: 0px;">

                <div class="curt">

                    <div class="ex_info" id="exportRePDF">
                        <c:if test="${countryToSchool ne 'true'}">
                            <table>
                                <tbody>
                                <tr>
                                    <td rowspan="6" width="120"></td>
                                    <td style="padding-left: 40px;"><b>总体情况</b></td>
                                </tr>
                                <tr>
                                    <td> 本地区共有学校<span
                                            class="blue">${mapGet['content']['Cschool']+mapGet['content']['Tschool']+0}</span>所，
                                    </td>
                                </tr>
                                <tr>
                                    <td>班级<span
                                            class="blue">${mapGet['content']['Cclass']+mapGet['content']['Tclass']+0}</span>个，学生<span
                                            class="blue">${mapGet['content']['Cstudent']+mapGet['content']['Tstudent']+0}</span>人，
                                    </td>
                                </tr>
                                <tr>
                                    <td>教职工<span
                                            class="blue">${mapGet['CCount'] + mapGet['TCount'] +0}</span>人，
                                    </td>
                                </tr>
                                <tr>
                                    <td>其中乡村学校<span
                                            class="blue">${mapGet['content']['Cschool']+0}</span>所(<span
                                            class="red">${my431fn:getPercentFloorV2(mapGet['content']['Cschool'],mapGet['content']['Cschool']+mapGet['content']['Tschool'],"%.2f")}</span>)，班级<span
                                            class="blue">${mapGet['content']['Cclass']+0}</span>个(<span
                                            class="red">${my431fn:getPercentFloorV2(mapGet['content']['Cclass'],mapGet['content']['Cclass']+mapGet['content']['Tclass'],"%.2f")}</span>)，
                                    </td>
                                </tr>
                                <tr>
                                    <td>学生<span
                                            class="blue">${mapGet['content']['Cstudent']+0}</span>人，教职工<span
                                            class="blue">${mapGet['CCount'] +0}</span>人(<span
                                            class="red">${my431fn:getPercentFloorV2(mapGet['CCount'],mapGet['CCount'] + mapGet['TCount'],"%.2f")}</span>)。
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${countryToSchool eq 'true'}">
                            <table>
                                <tbody>
                                <tr>
                                    <td rowspan="5" width="120"></td>
                                    <td style="padding-left: 40px;"><b>总体情况</b></td>
                                </tr>
                                <tr>
                                    <td>本学校有班级<span
                                            class="blue">${mapGet['content']['classCount']+0}</span>个，
                                    </td>
                                </tr>
                                <tr>
                                    <td>学生<span
                                            class="blue">${mapGet['content']['studentCount']+0}</span>人，
                                    </td>
                                </tr>
                                <tr>
                                    <td>教职工<span
                                            class="blue">${mapGet['content']['teacherCount'] +0}</span>人，
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </c:if>
                    </div>


                    <h4>详细情况</h4>
                    <div class="chatinner">
                        <div id="chart-container1" style="text-align:center"></div>
                        <br/>
                        <div id="chart-container2" style="text-align:center"></div>
                        <br/>
                        <div id="chart-container3" style="text-align:center"></div>
                        <div id="all">
                            <canvas id='myCanvas01'></canvas>
                            <canvas id='myCanvas02'></canvas>
                            <canvas id='myCanvas03'></canvas>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div style="height:40px;"></div>
        <div class="title" id="tab">下级部门情况
            <a href="###" class="export exportpdf" onclick="exportPdf()"></a>
            <a href="###" class="export exportexcel" style="margin-right: 10px;"
               onclick="exportExcel()"></a>
            <c:if test="${fn:startsWith(areaCode, wsAreaCode)}">
                <c:if test="${fn:length(areaCode)<=3}">
                    <a href="###"
                       style="margin-left: 120px;">${my431fn:getAreaByCodeOne(areaCode).areaName}</a>
                </c:if>
                <c:if test="${fn:length(areaCode)==6}">
                    <c:if test="${fn:length(wsAreaCode)<=3}">
                        <a href="###"
                           onclick="toSubArea('${my431fn:getAreaByCodeOne(fn:substring(areaCode,0,3)).id}');"
                           style="margin-left: 90px;">${my431fn:getAreaByCodeOne(fn:substring(areaCode,0,3)).areaName}</a> >
                    </c:if>
                    <c:if test="${fn:length(wsAreaCode) eq 6}">
                        <a href="###"
                           style="margin-left: 120px;">${my431fn:getAreaByCodeOne(areaCode).areaName}</a>
                    </c:if>
                    <c:if test="${fn:length(wsAreaCode) ne 6}">
                        <a href="###">${my431fn:getAreaByCodeOne(areaCode).areaName}</a>
                    </c:if>
                </c:if>
                <c:if test="${fn:length(areaCode)==9}">
                    <c:if test="${fn:length(wsAreaCode)<=3}">
                        <a href="###"
                           onclick="toSubArea('${my431fn:getAreaByCodeOne(fn:substring(areaCode,0,3)).id}');"
                           style="margin-left: 90px;">${my431fn:getAreaByCodeOne(fn:substring(areaCode,0,3)).areaName}</a> >
                    </c:if>
                    <c:if test="${fn:length(wsAreaCode)<=6}">
                        <a href="###"
                           onclick="toSubArea('${my431fn:getAreaByCodeOne(fn:substring(areaCode,0,6)).id}');">${my431fn:getAreaByCodeOne(fn:substring(areaCode,0,6)).areaName}</a> >
                    </c:if>
                    <c:if test="${countryToSchool ne 'true'}">
                        <c:if test="${fn:length(wsAreaCode) eq 9}">
                            <a href="###"
                               style="margin-left: 120px;">${my431fn:getAreaByCodeOne(areaCode).areaName}</a>
                        </c:if>
                        <c:if test="${fn:length(wsAreaCode) ne 9}">
                            <a href="###">${my431fn:getAreaByCodeOne(areaCode).areaName}</a>
                        </c:if>
                    </c:if>
                    <c:if test="${countryToSchool eq 'true'}">
                        <c:if test="${fn:length(wsAreaCode) eq 9}">
                            <a href="###"
                               style="margin-left: 120px;">${my431fn:getAreaByCodeOne(areaCode).areaName}</a>
                        </c:if>
                        <c:if test="${fn:length(wsAreaCode) ne 9}">
                            <a href="###"
                               onclick="toSubArea('${my431fn:getAreaByCodeOne(areaCode).id}')">${my431fn:getAreaByCodeOne(areaCode).areaName}</a>
                        </c:if>
                    </c:if>

                </c:if>
            </c:if>
            <span class="pot"></span></div>

        <%-- 当前地区：${areaName}&nbsp;&nbsp;&nbsp;&nbsp;
         <c:if test="${not empty shangJiAreaId}">
             <a href="###" onclick="toSubArea('${shangJiAreaId}');">返回${shangJiAreaName}</a>
         </c:if> --%>
        <div class="ex_table"
             style="overflow: visible;margin-top: 0px;border: 0px solid #dbdbdb;heigth:900px;;  ">
            <table id="MyTable">
                <thead>
                <tr>
                    <th rowspan="3">序号</th>
                    <c:if test="${countryToSchool ne 'true'}">
                        <th rowspan="3">部门名称</th>
                    </c:if>
                    <c:if test="${countryToSchool eq 'true'}">
                        <th rowspan="3">姓名</th>
                        <th rowspan="3">性别</th>
                        <th rowspan="3">年龄</th>
                    </c:if>

                    <c:if test="${countryToSchool ne 'true'}">
                        <c:if test="${SFZB !=null }">
                            <th colspan="9">在编情况</th>
                        </c:if>
                        <c:if test="${SFXJJYSGGJS !=null }">
                            <th colspan="9">骨干教师</th>
                        </c:if>
                        <c:if test="${XRGWDJ !=null }">
                            <th colspan="9">岗位等级</th>
                        </c:if>
                    </c:if>
                    <c:if test="${countryToSchool eq 'true'}">
                        <th rowspan="3">在编情况</th>
                        <th rowspan="3">骨干教师</th>
                        <th rowspan="3">岗位等级</th>
                    </c:if>
                </tr>
                <tr>
                    <c:if test="${countryToSchool ne 'true'}">
                        <c:if test="${SFZB !=null }">
                            <th colspan="3">全部</th>
                            <th colspan="3">城镇</th>
                            <th colspan="3">乡村</th>
                        </c:if>

                        <c:if test="${SFXJJYSGGJS !=null }">
                            <th colspan="3">全部</th>
                            <th colspan="3">城镇</th>
                            <th colspan="3">乡村</th>
                        </c:if>

                        <c:if test="${XRGWDJ !=null }">
                            <th colspan="3">全部</th>
                            <th colspan="3">城镇</th>
                            <th colspan="3">乡村</th>
                        </c:if>
                    </c:if>
                </tr>
                <tr>
                    <c:if test="${countryToSchool ne 'true'}">
                        <c:if test="${SFZB !=null }">
                            <th>教师数量</th>
                            <th>在编</th>
                            <th>占有率</th>
                            <th>教师数量</th>
                            <th>在编</th>
                            <th>占有率</th>
                            <th>教师数量</th>
                            <th>在编</th>
                            <th>占有率</th>
                        </c:if>

                        <c:if test="${SFXJJYSGGJS !=null }">
                            <th>教师数量</th>
                            <th>骨干</th>
                            <th>占有率</th>
                            <th>教师数量</th>
                            <th>骨干</th>
                            <th>占有率</th>
                            <th>教师数量</th>
                            <th>骨干</th>
                            <th>占有率</th>
                        </c:if>

                        <c:if test="${XRGWDJ !=null }">
                            <th>教师数量</th>
                            <th>中高级</th>
                            <th>占有率</th>
                            <th>教师数量</th>
                            <th>中高级</th>
                            <th>占有率</th>
                            <th>教师数量</th>
                            <th>中高级</th>
                            <th>占有率</th>
                        </c:if>
                    </c:if>
                </tr>
                </thead>
                <tbody>
                <!-- ==========================================非教师页面表格=============================== -->
                <c:if test="${countryToSchool ne 'true'}">
                    <c:set var="mapGet" value="${mapGet}"></c:set>
                    <tr>
                        <td>-</td>
                        <td class="widthStand">${my431fn:getAreaByCodeOne(areaCode).areaName }合计</td>
                        <!-- 在编 -->
                        <c:if test="${SFZB !=null }">
                            <td>${my431fn:changeEmptyToStr(mapGet['CCount'] + mapGet['TCount'] +0)}</td>
                            <td>${my431fn:changeEmptyToStr(mapGet['CSFZB1Count'] + mapGet['TSFZB1Count'] +0)}</td>
                            <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet['CSFZB1Count'] + mapGet['TSFZB1Count'],mapGet['CCount'] + mapGet['TCount'],"%.2f"))}</td>
                            <td>${my431fn:changeEmptyToStr(mapGet['TCount'] +0)}</td>
                            <td>${my431fn:changeEmptyToStr(mapGet['TSFZB1Count'] +0)}</td>
                            <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet['TSFZB1Count'],mapGet['TCount'],"%.2f"))}</td>
                            <td>${my431fn:changeEmptyToStr(mapGet['CCount'] +0)}</td>
                            <td>${my431fn:changeEmptyToStr(mapGet['CSFZB1Count'] +0)}</td>
                            <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet['CSFZB1Count'],mapGet['CCount'],"%.2f"))}</td>
                        </c:if>
                        <!-- 骨干 -->
                        <c:if test="${SFXJJYSGGJS !=null }">
                            <td>${my431fn:changeEmptyToStr(mapGet['CCount'] + mapGet['TCount'] +0)}</td>
                            <td>${my431fn:changeEmptyToStr(mapGet['CSFXJJYSGGJS1Count'] + mapGet['TSFXJJYSGGJS1Count'] +0)}</td>
                            <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet['CSFXJJYSGGJS1Count'] + mapGet['TSFXJJYSGGJS1Count'],mapGet['CCount'] + mapGet['TCount'],"%.2f"))}</td>
                            <td>${my431fn:changeEmptyToStr(mapGet['TCount'])}</td>
                            <td>${my431fn:changeEmptyToStr(mapGet['TSFXJJYSGGJS1Count'] +0)}</td>
                            <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet['TSFXJJYSGGJS1Count'],mapGet['TCount'],"%.2f"))}</td>
                            <td>${my431fn:changeEmptyToStr(mapGet['CCount'] +0)}</td>
                            <td>${my431fn:changeEmptyToStr(mapGet['CSFXJJYSGGJS1Count'] +0)}</td>
                            <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet['CSFXJJYSGGJS1Count'],mapGet['CCount'],"%.2f"))}</td>
                        </c:if>
                        <!-- 岗位等级 -->
                        <c:if test="${XRGWDJ !=null }">
                            <td>${my431fn:changeEmptyToStr(mapGet['CCount'] + mapGet['TCount'] +0)}</td>
                            <td>${my431fn:changeEmptyToStr(mapGet['CXRGWDJHCount'] + mapGet['CXRGWDJMCount'] + mapGet['TXRGWDJHCount'] + mapGet['TXRGWDJMCount'] +0)}</td>
                            <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet['CXRGWDJHCount'] + mapGet['CXRGWDJMCount'] + mapGet['TXRGWDJHCount'] + mapGet['TXRGWDJMCount'],mapGet['CCount'] + mapGet['TCount'],"%.2f"))}</td>
                            <td>${my431fn:changeEmptyToStr(mapGet['TCount'] +0)}</td>
                            <td>${my431fn:changeEmptyToStr(mapGet['TXRGWDJHCount'] + mapGet['TXRGWDJMCount'] +0)}</td>
                            <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet['TXRGWDJHCount'] + mapGet['TXRGWDJMCount'],mapGet['TCount'],"%.2f"))}</td>
                            <td>${my431fn:changeEmptyToStr(mapGet['CCount'] +0)}</td>
                            <td>${my431fn:changeEmptyToStr(mapGet['CXRGWDJHCount'] + mapGet['CXRGWDJMCount'] +0)}</td>
                            <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet['CXRGWDJHCount'] + mapGet['CXRGWDJMCount'],mapGet['CCount'],"%.2f"))}</td>
                        </c:if>
                    </tr>

                    <!-- 直属 -->
                    <%-- <c:if test="${mapGet['null'] !=null }"> --%>
                    <c:if test="${fn:length(areaCode)<=6}">

                        <tr>
                            <td>0</td>
                            <td class="widthStand">${my431fn:getAreaByCodeOne(areaCode).areaName }直属</td>
                            <!-- 在编 -->
                            <c:if test="${SFZB !=null }">
                                <td>${my431fn:changeEmptyToStr(mapGet['null'].obj4 + mapGet['null'].obj8 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet['null'].obj9 + mapGet['null'].obj12 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet['null'].obj9 + mapGet['null'].obj12,mapGet['null'].obj4 + mapGet['null'].obj8,"%.2f"))}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet['null'].obj8 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet['null'].obj12 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet['null'].obj12,mapGet['null'].obj8,"%.2f"))}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet['null'].obj4 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet['null'].obj9 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet['null'].obj9,mapGet['null'].obj4,"%.2f"))}</td>
                            </c:if>
                            <!-- 骨干 -->
                            <c:if test="${SFXJJYSGGJS !=null }">
                                <td>${my431fn:changeEmptyToStr(mapGet['null'].obj4 + mapGet['null'].obj8 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet['null'].obj19 + mapGet['null'].obj26 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet['null'].obj19 + mapGet['null'].obj26,mapGet['null'].obj4 + mapGet['null'].obj8,"%.2f"))}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet['null'].obj8 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet['null'].obj26 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet['null'].obj26,mapGet['null'].obj8,"%.2f"))}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet['null'].obj4 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet['null'].obj19 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet['null'].obj19,mapGet['null'].obj4,"%.2f"))}</td>
                            </c:if>
                            <!-- 岗位等级 -->
                            <c:if test="${XRGWDJ !=null }">
                                <td>${my431fn:changeEmptyToStr(mapGet['null'].obj4 + mapGet['null'].obj8 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet['null'].obj35 + mapGet['null'].obj36+ mapGet['null'].obj46+ mapGet['null'].obj47)}</td>
                                <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet['null'].obj35 + mapGet['null'].obj36+ mapGet['null'].obj46+ mapGet['null'].obj47,mapGet['null'].obj4 + mapGet['null'].obj8,"%.2f"))}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet['null'].obj8 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet['null'].obj46 + mapGet['null'].obj47 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet['null'].obj46 + mapGet['null'].obj47,mapGet['null'].obj8,"%.2f"))}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet['null'].obj4 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet['null'].obj35 + mapGet['null'].obj36 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet['null'].obj35 + mapGet['null'].obj36,mapGet['null'].obj4,"%.2f"))}</td>
                            </c:if>
                        </tr>
                    </c:if>
                    <%-- </c:if> --%>
                    <c:forEach items="${areaList}" var="dat" varStatus="index">
                        <tr>
                            <td>${index.count}</td>
                            <td class="widthStand"><a href="###"
                                                      onclick="toSubArea('${dat.id}');">${dat.nodeName}</a>
                            </td>
                            <!-- 在编 -->
                            <c:if test="${SFZB !=null }">
                                <td>${my431fn:changeEmptyToStr(mapGet[dat.id].obj4 + mapGet[dat.id].obj8 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet[dat.id].obj9 + mapGet[dat.id].obj12 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet[dat.id].obj9 + mapGet[dat.id].obj12,mapGet[dat.id].obj4 + mapGet[dat.id].obj8,"%.2f"))}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet[dat.id].obj8 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet[dat.id].obj12 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet[dat.id].obj12,mapGet[dat.id].obj8,"%.2f"))}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet[dat.id].obj4 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet[dat.id].obj9 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet[dat.id].obj9,mapGet[dat.id].obj4,"%.2f"))}</td>
                            </c:if>
                            <!-- 骨干 -->
                            <c:if test="${SFXJJYSGGJS !=null }">
                                <td>${my431fn:changeEmptyToStr(mapGet[dat.id].obj4 + mapGet[dat.id].obj8 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet[dat.id].obj19 + mapGet[dat.id].obj26 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet[dat.id].obj19 + mapGet[dat.id].obj26,mapGet[dat.id].obj4 + mapGet[dat.id].obj8,"%.2f"))}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet[dat.id].obj8 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet[dat.id].obj26 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet[dat.id].obj26,mapGet[dat.id].obj8,"%.2f"))}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet[dat.id].obj4 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet[dat.id].obj19 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet[dat.id].obj19,mapGet[dat.id].obj4,"%.2f"))}</td>
                            </c:if>
                            <!-- 岗位等级 -->
                            <c:if test="${XRGWDJ !=null }">
                                <td>${my431fn:changeEmptyToStr(mapGet[dat.id].obj4 + mapGet[dat.id].obj8 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet[dat.id].obj35 + mapGet[dat.id].obj36+ mapGet[dat.id].obj46+ mapGet[dat.id].obj47 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet[dat.id].obj35 + mapGet[dat.id].obj36+ mapGet[dat.id].obj46+ mapGet[dat.id].obj47,mapGet[dat.id].obj4 + mapGet[dat.id].obj8,"%.2f"))}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet[dat.id].obj8 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet[dat.id].obj46 + mapGet[dat.id].obj47 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet[dat.id].obj46 + mapGet[dat.id].obj47,mapGet[dat.id].obj8,"%.2f"))}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet[dat.id].obj4 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(mapGet[dat.id].obj35 + mapGet[dat.id].obj36 +0)}</td>
                                <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(mapGet[dat.id].obj35 + mapGet[dat.id].obj36,mapGet[dat.id].obj4,"%.2f"))}</td>
                            </c:if>
                        </tr>
                    </c:forEach>
                    <c:if test="${fn:length(areaCode) eq 9 }">
                        <c:forEach items="${schoolList}" var="schoolDat" varStatus="schoolIndex">
                            <tr>
                                <td>${schoolIndex.count}</td>
                                <td class="widthStand"><a href="###"
                                                          onclick="countryToSchoolFirst('${schoolDat['SCHOOL_ID']}');">${schoolDat['SCHOOL_NAME']}</a>
                                </td>
                                <!-- 在编 -->
                                <c:if test="${SFZB !=null }">
                                    <td>${my431fn:changeEmptyToStr(schoolListTable[schoolDat['SCHOOL_ID']].obj4 + schoolListTable[schoolDat['SCHOOL_ID']].obj8 +0)}</td>
                                    <td>${my431fn:changeEmptyToStr(schoolListTable[schoolDat['SCHOOL_ID']].obj9 + schoolListTable[schoolDat['SCHOOL_ID']].obj12 +0)}</td>
                                    <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(schoolListTable[schoolDat['SCHOOL_ID']].obj9 + schoolListTable[schoolDat['SCHOOL_ID']].obj12,schoolListTable[schoolDat['SCHOOL_ID']].obj4 + schoolListTable[schoolDat['SCHOOL_ID']].obj8,"%.2f"))}</td>
                                    <td>${my431fn:changeEmptyToStr(schoolListTable[schoolDat['SCHOOL_ID']].obj8 +0)}</td>
                                    <td>${my431fn:changeEmptyToStr(schoolListTable[schoolDat['SCHOOL_ID']].obj12 +0)}</td>
                                    <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(schoolListTable[schoolDat['SCHOOL_ID']].obj12,schoolListTable[schoolDat['SCHOOL_ID']].obj8,"%.2f"))}</td>
                                    <td>${my431fn:changeEmptyToStr(schoolListTable[schoolDat['SCHOOL_ID']].obj4 +0)}</td>
                                    <td>${my431fn:changeEmptyToStr(schoolListTable[schoolDat['SCHOOL_ID']].obj9 +0)}</td>
                                    <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(schoolListTable[schoolDat['SCHOOL_ID']].obj9,schoolListTable[schoolDat['SCHOOL_ID']].obj4,"%.2f"))}</td>
                                </c:if>
                                <!-- 骨干 -->
                                <c:if test="${SFXJJYSGGJS !=null }">
                                    <td>${my431fn:changeEmptyToStr(schoolListTable[schoolDat['SCHOOL_ID']].obj4 + schoolListTable[schoolDat['SCHOOL_ID']].obj8 +0)}</td>
                                    <td>${my431fn:changeEmptyToStr(schoolListTable[schoolDat['SCHOOL_ID']].obj19 + schoolListTable[schoolDat['SCHOOL_ID']].obj26 +0)}</td>
                                    <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(schoolListTable[schoolDat['SCHOOL_ID']].obj19 + schoolListTable[schoolDat['SCHOOL_ID']].obj26,schoolListTable[schoolDat['SCHOOL_ID']].obj4 + schoolListTable[schoolDat['SCHOOL_ID']].obj8,"%.2f"))}</td>
                                    <td>${my431fn:changeEmptyToStr(schoolListTable[schoolDat['SCHOOL_ID']].obj8 +0)}</td>
                                    <td>${my431fn:changeEmptyToStr(schoolListTable[schoolDat['SCHOOL_ID']].obj26 +0)}</td>
                                    <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(schoolListTable[schoolDat['SCHOOL_ID']].obj26,schoolListTable[schoolDat['SCHOOL_ID']].obj8,"%.2f"))}</td>
                                    <td>${my431fn:changeEmptyToStr(schoolListTable[schoolDat['SCHOOL_ID']].obj4 +0)}</td>
                                    <td>${my431fn:changeEmptyToStr(schoolListTable[schoolDat['SCHOOL_ID']].obj19 +0)}</td>
                                    <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(schoolListTable[schoolDat['SCHOOL_ID']].obj19,schoolListTable[schoolDat['SCHOOL_ID']].obj4,"%.2f"))}</td>
                                </c:if>
                                <!-- 岗位等级 -->
                                <c:if test="${XRGWDJ !=null }">
                                    <td>${my431fn:changeEmptyToStr(schoolListTable[schoolDat['SCHOOL_ID']].obj4 + schoolListTable[schoolDat['SCHOOL_ID']].obj8 +0)}</td>
                                    <td>${my431fn:changeEmptyToStr(schoolListTable[schoolDat['SCHOOL_ID']].obj35 + schoolListTable[schoolDat['SCHOOL_ID']].obj36+ schoolListTable[schoolDat['SCHOOL_ID']].obj46+ schoolListTable[schoolDat['SCHOOL_ID']].obj47 +0)}</td>
                                    <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(schoolListTable[schoolDat['SCHOOL_ID']].obj35 + schoolListTable[schoolDat['SCHOOL_ID']].obj36+ schoolListTable[schoolDat['SCHOOL_ID']].obj46+ schoolListTable[schoolDat['SCHOOL_ID']].obj47,schoolListTable[schoolDat['SCHOOL_ID']].obj4 + schoolListTable[schoolDat['SCHOOL_ID']].obj8,"%.2f"))}</td>
                                    <td>${my431fn:changeEmptyToStr(schoolListTable[schoolDat['SCHOOL_ID']].obj8 +0)}</td>
                                    <td>${my431fn:changeEmptyToStr(schoolListTable[schoolDat['SCHOOL_ID']].obj46 + schoolListTable[schoolDat['SCHOOL_ID']].obj47 +0)}</td>
                                    <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(schoolListTable[schoolDat['SCHOOL_ID']].obj46 + schoolListTable[schoolDat['SCHOOL_ID']].obj47,schoolListTable[schoolDat['SCHOOL_ID']].obj8,"%.2f"))}</td>
                                    <td>${my431fn:changeEmptyToStr(schoolListTable[schoolDat['SCHOOL_ID']].obj4 +0)}</td>
                                    <td>${my431fn:changeEmptyToStr(schoolListTable[schoolDat['SCHOOL_ID']].obj35 + schoolListTable[schoolDat['SCHOOL_ID']].obj36 +0)}</td>
                                    <td>${my431fn:changeEmptyToStr(my431fn:getPercentFloorV2(schoolListTable[schoolDat['SCHOOL_ID']].obj35 + schoolListTable[schoolDat['SCHOOL_ID']].obj36,schoolListTable[schoolDat['SCHOOL_ID']].obj4,"%.2f"))}</td>
                                </c:if>
                            </tr>
                        </c:forEach>
                    </c:if>
                </c:if>
                <!-- ==========================================查看教师页面表格=============================== -->
                <c:if test="${countryToSchool eq 'true'}">
                    <c:forEach items="${teacherList}" var="dat" varStatus="index">
                        <tr class="CXFL_RYJB_CHILD_MAIN">
                            <td>${index.count}</td>
                            <td>${dat['XM']}</td>
                            <!-- 性别  -->
                            <td>
                                <c:if test="${dat['XB'] eq 'XB@GJ@1' }">男 </c:if>
                                <c:if test="${dat['XB'] eq 'XB@GJ@2' }">女 </c:if>
                            </td>
                            <td>${dat['AGE']}</td>
                            <!-- 在编情况 -->
                            <td>
                                <c:if test="${empty dat['SFZB']  }">未知</c:if>
                                <c:if test="${not empty dat['SFZB']  }">${my431fn:getValueByCode(dat['SFZB'])}</c:if>

                            </td>

                            <!-- 骨干教师 -->
                            <td>
                                <c:if test="${empty dat['SFXJJYSGGJS']  }">未知</c:if>
                                <c:if test="${not empty dat['SFXJJYSGGJS']  }">${my431fn:getValueByCode(dat['SFXJJYSGGJS'])}</c:if>
                            </td>


                            <!--  岗位级别 -->
                            <td>
                                <c:if test="${dat['XRGWDJ_FMT'] eq 'post.level.high' }">高级岗位教师 </c:if>
                                <c:if test="${dat['XRGWDJ_FMT'] eq 'post.level.middle' }">中级岗位教师 </c:if>
                                <c:if test="${dat['XRGWDJ_FMT'] eq 'post.level.low' }">初级岗位教师 </c:if>
                                <c:if test="${dat['XRGWDJ_FMT'] eq 'post.level.unknown' }">未知</c:if>
                                <c:if test="${empty dat['XRGWDJ_FMT']  }">未知</c:if>

                            </td>


                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>

            </table>
            <c:if test="${countryToSchool ne 'true'}">
                <c:if test="${fn:length(areaCode) eq 9 }">
                    <div style="width: 100%;" class="myPage">
                            ${pageHtml}
                    </div>
                </c:if>
            </c:if>
            <c:if test="${countryToSchool eq 'true'}">
                <div style="width: 100%;" class="myPage">
                        ${pageHtml}
                </div>
            </c:if>
        </div>
    </div>
</div>

<!-- 分析结果-->
<div class="fixedResult">
    <a href="#" class="at"></a>
    <div class="showBox" style="height:400px;  overflow-y:auto; ">
        <h3>分析结果</h3>
        <p> 从我省教师基本情况的统计来看，教师的在编比例方面，城区教师的在编率为<span
                class="blue">${my431fn:getPercentFloorV2(mapGet['TSFZB1Count'],mapGet['TCount'],"%.2f")}</span>，乡村教师的在编率为：<span
                class="blue">${my431fn:getPercentFloorV2(mapGet['CSFZB1Count'],mapGet['CCount'],"%.2f")}</span>；
            县级及县级以上骨干教师方面，城区教师骨干率为<span
                    class="blue">${my431fn:getPercentFloorV2(mapGet['TSFXJJYSGGJS1Count'],mapGet['TCount'],"%.2f")}</span>，乡村教师的骨干率为<span
                    class="blue">${my431fn:getPercentFloorV2(mapGet['CSFXJJYSGGJS1Count'],mapGet['CCount'],"%.2f")}</span>；
            现任岗位的专业技术等级方面，城区教师中高级比例占到教师岗位的<span
                    class="blue">${my431fn:getPercentFloorV2(mapGet['TXRGWDJHCount'] + mapGet['TXRGWDJMCount'],mapGet['TCount'],"%.2f")}</span>，乡村教师中高级教师比例占到教师岗位的<span
                    class="blue">${my431fn:getPercentFloorV2(mapGet['CXRGWDJHCount'] + mapGet['CXRGWDJMCount'],mapGet['CCount'],"%.2f")}</span>；
            从教师的在编率、骨干率及教师岗位的中高级率可以看出，当前乡村教师与城区教师仍存在一定的差距。下级部门的在编率、骨干率及教师岗位的中高级率参看下表：</p>
        <table>
            <thead>
            <tr>
                <th rowspan="3">序号</th>
                <th rowspan="3">部门名称</th>

                <th colspan="3">在编情况</th>
                <th colspan="3">骨干教师</th>
                <th colspan="3">岗位等级</th>
            </tr>
            <tr>
                <th colspan="1">全部</th>
                <th colspan="1">城镇</th>
                <th colspan="1">乡村</th>

                <th colspan="1">全部</th>
                <th colspan="1">城镇</th>
                <th colspan="1">乡村</th>

                <th colspan="1">全部</th>
                <th colspan="1">城镇</th>
                <th colspan="1">乡村</th>
            </tr>
            </thead>
            <tbody>
            <c:set var="mapGet" value="${mapGet}"></c:set>
            <!-- 直属 -->
            <c:if test="${mapGet['null'] !=null }">
                <tr>
                    <td>0</td>
                    <td>直属</td>
                    <!-- 在编 -->
                    <td>${my431fn:getPercentFloorV2(mapGet['null'].obj9 + mapGet['null'].obj12,mapGet['null'].obj4 + mapGet['null'].obj8,"%.2f")}</td>
                    <td>${my431fn:getPercentFloorV2(mapGet['null'].obj12,mapGet['null'].obj8,"%.2f")}</td>
                    <td>${my431fn:getPercentFloorV2(mapGet['null'].obj9,mapGet['null'].obj4,"%.2f")}</td>
                    <!-- 骨干 -->
                    <td>${my431fn:getPercentFloorV2(mapGet['null'].obj19 + mapGet['null'].obj26,mapGet['null'].obj4 + mapGet['null'].obj8,"%.2f")}</td>
                    <td>${my431fn:getPercentFloorV2(mapGet['null'].obj26,mapGet['null'].obj8,"%.2f")}</td>
                    <td>${my431fn:getPercentFloorV2(mapGet['null'].obj19,mapGet['null'].obj4,"%.2f")}</td>
                    <!-- 岗位等级 -->
                    <td>${my431fn:getPercentFloorV2(mapGet['null'].obj35 + mapGet['null'].obj36+ mapGet['null'].obj46+ mapGet['null'].obj47,mapGet['null'].obj4 + mapGet['null'].obj8,"%.2f")}</td>
                    <td>${my431fn:getPercentFloorV2(mapGet['null'].obj46 + mapGet['null'].obj47,mapGet['null'].obj8,"%.2f")}</td>
                    <td>${my431fn:getPercentFloorV2(mapGet['null'].obj35 + mapGet['null'].obj36,mapGet['null'].obj4,"%.2f")}</td>
                </tr>
            </c:if>
            <c:forEach items="${areaList}" var="dat" varStatus="index">
                <tr>
                    <td>${index.count}</td>
                    <td>${dat.nodeName}</td>
                    <!-- 在编 -->
                    <td>${my431fn:getPercentFloorV2(mapGet[dat.id].obj9 + mapGet[dat.id].obj12,mapGet[dat.id].obj4 + mapGet[dat.id].obj8,"%.2f")}</td>
                    <td>${my431fn:getPercentFloorV2(mapGet[dat.id].obj12,mapGet[dat.id].obj8,"%.2f")}</td>
                    <td>${my431fn:getPercentFloorV2(mapGet[dat.id].obj9,mapGet[dat.id].obj4,"%.2f")}</td>
                    <!-- 骨干 -->
                    <td>${my431fn:getPercentFloorV2(mapGet[dat.id].obj19 + mapGet[dat.id].obj26,mapGet[dat.id].obj4 + mapGet[dat.id].obj8,"%.2f")}</td>
                    <td>${my431fn:getPercentFloorV2(mapGet[dat.id].obj26,mapGet[dat.id].obj8,"%.2f")}</td>
                    <td>${my431fn:getPercentFloorV2(mapGet[dat.id].obj19,mapGet[dat.id].obj4,"%.2f")}</td>
                    <!-- 岗位等级 -->
                    <td>${my431fn:getPercentFloorV2(mapGet[dat.id].obj35 + mapGet[dat.id].obj36+ mapGet[dat.id].obj46+ mapGet[dat.id].obj47,mapGet[dat.id].obj4 + mapGet[dat.id].obj8,"%.2f")}</td>
                    <td>${my431fn:getPercentFloorV2(mapGet[dat.id].obj46 + mapGet[dat.id].obj47,mapGet[dat.id].obj8,"%.2f")}</td>
                    <td>${my431fn:getPercentFloorV2(mapGet[dat.id].obj35 + mapGet[dat.id].obj36,mapGet[dat.id].obj4,"%.2f")}</td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
</div>
<script type="text/javascript" src="${root}/skins/timCss/js/common.js"></script>
<script type="text/javascript" src="${root}/js/foot.js"></script>

