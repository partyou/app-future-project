<!DOCTYPE html>
<html>
<head>
    
    <title>分红设置</title>
    <#include "/common/common-h5.ftl"/>
</head>
<body>
<#if (success!true)==true>
<section class="bg-gray">
  <ul class="list-group col-2 ft-list">
    <li class="list-group-row"><span class="list-group-item">基金名称: </span><span class="list-group-item">${(fundInfo.cpmc)!""}(${(fundInfo.cpdm)!""})</span></li>
    <li class="list-group-row"><span class="list-group-item">当前设置: </span><span class="list-group-item"><#if fundInfo.fhfs == "1">红利转投<#elseif fundInfo.fhfs == "2">现金分红<#else>未设置</#if></span></li>
    <li class="list-group-row"><span class="list-group-item">分红改为: </span><span class="list-group-item">
  		<code><#if fundInfo.fhfs == "1">现金分红<#elseif fundInfo.fhfs == "2">红利转投<#else>红利转投</#if></code>
    </span></li>
  </ul>

  <div class="hb-btn-group">
  	<form id="shareSetForm">
		<input name="fundCode" id="fundCode" type="hidden" value="${(fundInfo.cpdm)!''}">
		<input name="dividendWay" id="dividendWay" type="hidden" value="<#if fundInfo.fhfs == '1'>2<#elseif fundInfo.fhfs == '2'>1<#else>1</#if>">
	</form>
    <a href="#" class="btn btn-primary" id="btnSubmit">确定</a>
  </div>
</section>

<div id="modalAlert" class="modal">
  <div class="modal-mask"></div>
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-hotspot" data-dismiss="modal"></div>
      <div class="modal-header">
        <a href="#" class="close"></a>
        <div class="modal-title">温馨提示</div>
      </div>
      <div class="modal-body">
        <p>您已经提交过${(fundInfo.cpmc)!""}(${(fundInfo.cpdm)!""})分红设置的申请，您可以在交易查询中查看确认结果</p>
        <a href="${globalPrefix}/fund/tradingList.htm" class="btn btn-primary">马上查看</a>
      </div>
    </div>
  </div>
</div>
<#else>
    <#include "/common/error_h5.ftl" />
</#if>
<script type="text/javascript" data-hb-js="hbec-trade-h5/1.0.0/js/bonus"></script>
<#include "/_inc_commons.ftl" />
</body>
</html>