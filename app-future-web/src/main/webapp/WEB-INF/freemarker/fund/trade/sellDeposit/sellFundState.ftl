<!DOCTYPE html>
<html>
<head>
    <title>卖基金</title>
	<#include "/common/common-trade-h5.ftl"/>
</head>
<body class="fundState">
<#if (success!true)==true>
	<div class="stateList">
	    <ul>
	        <li class="on">
	            <i class="icon-right"></i>
	            <p>T日<br><em>（${(tradeDate)!""}）</em></p>
	            <span>下单成功</span></li>
	        <li>
	            <i></i>
	            <p>T+1日</p>
	            <span>份额确认</span></li>
	        <li>
	            <i></i>
	            <p>T+2日</p>
	            <span>资金返还</span></li>
	    </ul>
	</div>
	<div class="clearfix btnBox">
		<a href="${globalPrefix}/fund/tradingList.htm" class="hbec-btn fl btn-primary-active">查看交易记录</a>
		<a href="${globalPrefix}/fund/fundHold.htm" class="hbec-btn fr btn-primary-gray">返回持仓</a>
	</div>
	
<#else>
	<#include "/common/error_h5.ftl" />
</#if>
<#include "/_inc_commons.ftl" />
</body>
</html>