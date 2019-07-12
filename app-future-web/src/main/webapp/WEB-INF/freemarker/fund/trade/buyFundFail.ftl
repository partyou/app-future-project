<!DOCTYPE html>
<html>
<head>
    <title>基金买入失败</title>
    <#include "/common/common-trade-h5.ftl"/>
</head>
<body class="inState">
<#if (success!true)==true>


<section class="bg-gray">
  <span class="i-cancel"></span>
  <p class="success-title">申购失败</p>
  <p class="success-title second">交易提示：${(errorMessage)!""}</p>
  <div class="hb-btn-group">
    <a href="/h5/licai/fund/risk" class="btn btn-primary">返回</a>
  </div>
</section>




<#else>
	<#include "/common/error_h5.ftl"/>
</#if>
<#include "/_inc_commons.ftl" />
</body>
</html>