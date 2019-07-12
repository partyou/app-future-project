<!DOCTYPE html>
<html>
<head>
	<#include "/common/common-h5.ftl"/>
    <title>交易详情</title>
</head>
<body class="tradeDetail">

<#if (success!true)==true>
	<#if entrust??>
<section class="bg-gray">
  <div class="td-head">
    <ul class="tree-group row">
      <li class="tree-group-item first on">
        <p>订单提交</p>
      </li>
      <li class="tree-group-item on">
        <p>受理中</p>
      </li>
      <#if entrust.wtzt==0||entrust.wtzt==1>
	      <li class="tree-group-item">
	        <p>交易完成</p>
	      </li>
      <#else>
	      <li class="tree-group-item on">
		    <p>${entrust.wtztDesc!nullShow}</p>
		  </li>
      </#if>
    </ul>
  </div>
  <ul class="list-group col-2 ft-list">
    <li class="list-group-row"><span class="list-group-item">基金名称：</span><span class="list-group-item">${entrust.cpmc!""}(${entrust.cpdm!""})</span></li>
    <li class="list-group-row"><span class="list-group-item">业务类型：</span><span class="list-group-item">申购</span></li>
    <li class="list-group-row"><span class="list-group-item">申请时间：</span><span class="list-group-item">
    ${((entrust.wtrq!nullShow)?c)?substring(0,4)}-${((entrust.wtrq!nullShow)?c)?substring(4,6)}-${((entrust.wtrq!nullShow)?c)?substring(6,8)} ${entrust.wtsj!nullShow}
    	</span></li>
    <li class="list-group-row"><span class="list-group-item">申请金额：</span><span class="list-group-item"><code>${(entrust.wtje!"0.00")?string('#,##0.00')}元</code></span></li>
    <li class="list-group-row"><span class="list-group-item">确认份额：</span><span class="list-group-item"><#if entrust.wtzt==0>--<#else>${(entrust.cjsl)!nullShow}</#if>份</span></li>
	<li class="list-group-row"><span class="list-group-item">交易费用：</span><span class="list-group-item">${entrust.s1!nullShow}元</span></li>
<!-- <li class="list-group-row"><span class="list-group-item">关联银行：</span><span class="list-group-item">中国建设银行（尾号9335）</span></li>  -->
	<li class="list-group-row"><span class="list-group-item">资金状态：</span><span class="list-group-item"><#if entrust.wtzt<0||entrust.wtzt==7>预计1-3个交易日到账<#else>支付成功</#if></span></li>
    <li class="list-group-row"><span class="list-group-item">交易状态：</span>
    <span class="list-group-item">${entrust.wtztDesc!nullShow}<#if entrust.wtzt==0><a class="change" href="${globalPrefix}/fund/cancelTrade.htm?id=${entrust.wth?c}">撤单</a></#if></span>
  	<#if entrust.wtzt<0>
	  	<li class="list-group-row"><span class="list-group-item">失败提示：</span>
			<span class="list-group-item">${entrust.message!nullShow}</span>
		</li>
	</#if>
  </ul>
  <div class="hb-btn-group">
    <a href="${globalPrefix}/fund/tradingList.htm" class="btn btn-primary">确定</a>
  </div>
</section>
	</#if>
<#else>
	<#include "/common/error_h5.ftl" />
</#if>
<#include "/_inc_commons.ftl" />
</body>
</html>