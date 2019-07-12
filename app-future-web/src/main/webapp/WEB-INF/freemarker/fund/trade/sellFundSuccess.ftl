<!DOCTYPE html>
<html>
<head>
    <title>卖基金</title>
	<#include "/common/common-h5.ftl"/>
</head>
<body class="fundState">
<#if (success!true)==true>
	
	
	
<section class="bg-gray">
  <span class="i-success"></span>
  <p class="success-title">赎回订单提交成功</p>
  <p class="success-title second">您可在交易查询中查看确认结果</p>

  <div class="buy-success-tree">
    <ul class="tree-group">
      <li class="tree-group-item on"><b>申请提交</b><span>${(nowDate)!""}</span></li>
      <li class="tree-group-item on"><b>受理中</b><span>(预计 ${(tradeDate)!""}确认)</span></li>
      <li class="tree-group-item last"><b>交易成功</b><span>(预计 ${(tradeBackDate)!"--"}个交易日到帐)</span></li>
    </ul>
  </div>

  <div class="hb-btn-group">
    <a href="${globalPrefix}/fund/tradingList.htm" class="btn btn-primary">完成</a>
  </div>
</section>
	
	
	
<#else>
	<#include "/common/error_h5.ftl" />
</#if>
<#include "/_inc_commons.ftl" />
</body>
</html>