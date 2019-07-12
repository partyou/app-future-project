<!DOCTYPE html>
<html>
<head>
    <title>撤单成功</title>
    <#include "/common/common-h5.ftl"/>
</head>
<body>
<link rel="stylesheet" href="//10.0.30.115/hbec/projects/licai/fundTrans/1.0.0/fundTrans.min.css"/>
<section class="bg-gray">
  <span class="i-success"></span>
  <p class="success-title">撤单成功</p>
  <#if ywdm=='022'>
  <p class="success-title second">交易已撤单，资金预计 1-3 个交易日回到银行卡</p>
  </#if>
  <div class="hb-btn-group">
    <a href="${globalPrefix}/fund/tradingList.htm" class="btn btn-danger">完成</a>
  </div>
</section>
<#include "/_inc_commons.ftl" />
</body>
</html>