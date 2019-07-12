<!DOCTYPE html>
<html>
<head>
    <title>分红设置失败</title>
    <#include "/common/common-h5.ftl"/>
</head>
<body>
<section class="bg-gray">
  <span class="i-cancel"></span>
  <p class="success-title">分红设置失败</p>
  <p class="success-title second">失败原因：${errorMessage!''}</p>
  <div class="hb-btn-group">
    <a href="${globalPrefix}/fund/tradingList.htm" class="btn btn-primary">返回</a>
  </div>
</section>
<#include "/_inc_commons.ftl" />
</body>
</html>