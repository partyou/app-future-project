<!DOCTYPE html>
<html>
<head>
    <title>分红设置成功</title>
    <#include "/common/common-h5.ftl"/>
</head>
<body>
<section class="bg-gray">
  <span class="i-success"></span>
  <p class="success-title">分红设置申请成功</p>
  <p class="success-title second">您可在交易查询中查看确认结果</p>

  <div class="buy-success-tree">
	    <ul class="tree-group">
	      <li class="tree-group-item on"><b>申请提交</b><span>${applyDate!""}</span></li>
	      <li class="tree-group-item on"><b>受理中</b><span>(预计 ${tPlusOneDate!""}确认)</span></li>
	      <li class="tree-group-item last"><b>设置成功</b></li>
	    </ul>
  </div>

  <div class="hb-btn-group">
    <a href="${globalPrefix}/fund/tradingList.htm" class="btn btn-primary">完成</a>
  </div>
</section>
<#include "/_inc_commons.ftl" />
</body>
</html>