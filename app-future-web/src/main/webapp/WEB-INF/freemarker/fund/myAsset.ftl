<!DOCTYPE html>
<html>
<head>
	<#include "/common/common-trade-h5.ftl"/>
    <title>我的资产</title>
</head>
<body class="myAsset">
    <#if (success!true)==true>
    <#include "/common/util.ftl"/>
    <header class="header">
        <ul>
            <li class="clearfix">
                <label class="fl">总市值</label>
                <p class="fr">${(totalMarketValue!"0.00")?string('#,##0.00')}元<i class="icons-arrow-r" style="opacity:0"></i></p>
            </li>
            <li class="clearfix">
                <label class="fl">可用余额</label>
                <a href="${globalPrefix}/capital/trade/transfer.htm"><p class="fr">${(usableValue!"0.00")?string('#,##0.00')}元<i class="icons-arrow-r"></i></p></a>
            </li>
        </ul>
    </header>
    <article class="article">
        <ul>
            <li style="margin-left:20px;line-height: 35px;">
            	基金代码：
               <input type="text" class="fundCodeOrShortName"/>
               <a class="searchFundBtn btnNext" href="#">购买</a>
            </li>
        </ul>

        <ul>
            <li class="clearfix li1">
                <h2 class="fl">基金</h2>
                <h2 class="fr"><a href="${globalPrefix}/fund/fundHold.htm">详情<i class="icons-arrow-r-gray"></i></a></h2>
            </li>
            <li class="clearfix li2">
                <h3 class="fl flex30">市值(元)</h3>
                <h3 class="fl flex35">持仓基金数</h3>
                <h3 class="fl flex35">浮动收益(元)</h3>
            </li>
            <li class="clearfix posr">
                <h4 class="fl flex30">${(fundMarketValue!0)?string('#,##0.00')}</h4>
                <h4 class="fl flex35 col-red">${(fundHoldNum!0)}</h4>
                <h4 class="fl flex35 col-red">${formatData(fundFloatProfit!0,"0.00")}</h4>
            </li>
        </ul>

        <ul>
            <li class="clearfix li1">
                <h2 class="fl">闪存宝</h2>
                <h2 class="fr"><a href="${globalPrefix}/otc/holdRecords.htm">详情<i class="icons-arrow-r-gray"></i></a></h2>
            </li>
            <li class="clearfix li2">
                <h3 class="fl flex30">市值(元)</h3>

            </li>
            <li class="clearfix posr">
                <h4 class="fl flex30">${(otcMarketValue!0)?string('#,##0.00')}</h4>
                <a class="btnNext" href="${globalPrefix}/otc/productList.htm">购买</a>
            </li>
        </ul>
    </article>
    
    <script type="text/javascript">
    	 $(".searchFundBtn").on('click', function(e){
    	 	var fundCodeOrShortName = $(".fundCodeOrShortName").val();
    	 	$.ajaxFn({
		        type : "POST",
		        url : "${globalPrefix}/fund/searchFundInfo.do",
		        data: {'fundCodeOrShortName':fundCodeOrShortName}, 
		        success: function(data){
		           if(data.success&&data.result){
			           	window.location.href = "${globalPrefix}/fund/trade/buyFund.htm?fundCode="+fundCodeOrShortName;
		           }else{
		           		$.alert("没有找到该基金！");
		           }
		        }
		    })
    	 })
    </script>
    <#else>
        <#include "/common/error_h5.ftl" />
    </#if>
    <#include "/_inc_commons.ftl" />
</body>
</html>