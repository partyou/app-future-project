<!DOCTYPE html>
<html>
<head>
    <title>基金卖出失败</title>
    <#include "/common/common-xjb-h5.ftl"/>
</head>
<body class="inState">
<#if (success!true)==true>

	<div class="failFace">
		<p class="tips">卖出失败</p>
		<p class="tipsCause">失败原因：${errorMessage!''}</p>
	</div>

	<div class="clearfix btnBox">
		<a href="${globalPrefix}/xjb/problemView.htm" class="hbec-btn fl btn-primary-active">我该怎么办？</a>
		<a href="${globalPrefix}/fund/fundHold.htm" class="hbec-btn fr btn-primary-gray">返回持仓</a>
	</div>
	
<#else>
	<#include "/common/error_h5.ftl"/>
</#if>
<#include "/_inc_commons.ftl" />
</body>
</html>