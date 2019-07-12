<!DOCTYPE html>
<html>
<head>
    <title>优惠券使用</title>
	<#include "/common/common-h5.ftl"/>
</head>
<body class="fundState">
<#if (success!true)==true>
	
	
<section class="bg-gray">
  <span class="i-success"></span>
  <p class="success-title">优惠券使用成功</p>
  <p class="success-title second">您可在交易查询中查看确认结果</p>

  <div class="hb-btn-group">
    <a href="${globalPrefix}/card/cardList.html" class="btn btn-primary">返回</a>
  </div>
</section>
	
	
	
<#else>
    <#include "/common/error_h5.ftl" />
</#if>
</body>
</html>