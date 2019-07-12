<!DOCTYPE html>
<html>
<head>
    <title>撤单失败</title>
    <#include "/common/common-h5.ftl"/>
</head>
<body>
<link rel="stylesheet" href="//10.0.30.115/hbec/projects/licai/fundTrans/1.0.0/fundTrans.min.css"/>
<section class="bg-gray">
  <span class="i-cancel"></span>
  <p class="success-title">撤单失败</p>
  <p class="success-title second">失败原因：${errorMessage!''}</p>
  <div class="hb-btn-group">
    <a href="${globalPrefix}/fund/tradingList.htm" class="btn btn-primary">返回</a>
  </div>
</section>
<#include "/_inc_commons.ftl" />
</body>
</html>