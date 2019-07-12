<!DOCTYPE html>
<html>
<head>
    <title>卖基金</title>
	<#include "/common/common-h5.ftl"/>
</head>
<body class="sellFund">

<#if (success!true)==true>



<section class="bg-gray">
  <ul class="list-group col-2 ft-list-bg">
    <li class="list-group-row">
      <span class="list-group-item">基金名称：</span>
      <span class="list-group-item">${(otcProductBaseInfo.cpmc)!""}(${(otcProductBaseInfo.cpdm)!""})</span>
    </li>
    <li class="list-group-row">
      <span class="list-group-item">回款银行：</span>
      <span class="list-group-item bank">${signInfo.signingBankInfo.yhmc!''}(尾号${(signInfo.yhkh?substring(signInfo.yhkh?length-4, signInfo.yhkh?length))!''})</span>
    </li>
    <li class="list-group-row">
      <span class="list-group-item">最少赎回：</span>
      <span class="list-group-item" data-fundMin="${(otcProductBaseInfo.shqd!0)?c}">${(otcProductBaseInfo.shqd!0)?c}份 <a href="#" class="i-qustion" data-toggle="modal" data-target="#modalAlert">?</a></span>
    </li>
    <li class="list-group-row">
      <span class="list-group-item">持有份数：</span>
      <span class="list-group-item">${(otcCustomerPosition.ccsl!0)?c}份</span>
    </li>
  </ul>
  <form class="form-group" id="orderForm">
    <div class="input-group">
      <label class="input-group-title">赎回份数：</label>
      <input class="form-control" id="fundAmt" name="fundAmt" type="tel" data-fundMax="${(otcCustomerPosition.kyfe!0)?c}" placeholder="最大${(otcCustomerPosition.kyfe!0)?c}份"/>
      <span class="input-group-addon" id="redeemAll">全部赎回</span>
    </div>
    <div class="hb-btn-group">
      	<#if isTradeTime>
	  	<button type="button" disabled="disabled" class="btn btn-primary disabled" id="redeemBtn">提交</button>
		<#else>
		<button type="button" disabled="disabled" class="btn disabled" >非交易时间</button>
		<p class="text-action-btn">交易时间为周一至周五9:00-15:00 节假日除外</p>
		</#if>
    </div>
    <input id="cpdm" name="cpdm" type="hidden" value="${(otcProductBaseInfo.cpdm)!""}"/>
    <input id="wtfe" name="wtfe" type="hidden" value=""/>
    <input id="jymm" name="jymm" type="hidden" value=""/>
  </form>
  <input type="hidden" id="positionMinAmount" name="positionMinAmount" value="${(otcProductBaseInfo.bfshyexx!0)?c}" />
</section>
<div id="modalPwd" class="modal">
  <div class="modal-mask">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-hotspot" data-dismiss="modal"></div>
        <div class="modal-header">
          <a href="#" class="close"></a>
          <div class="modal-title">请输入交易密码</div>
        </div>
        <div class="modal-body">
          <h3 id="amount" class="text-center"></h3>
          <input type="password" id="mpwd" name="mpwd" data-provider="hb-tradePwd" />
          <div id="errorMsg" class="error-msg"></div>
          <div class="text-center">回款银行：${signInfo.signingBankInfo.yhmc!''}(尾号${(signInfo.yhkh?substring(signInfo.yhkh?length-4, signInfo.yhkh?length))!''})</div>
        </div>
      </div>
    </div>
  </div>
</div>

<div id="modalAlert" class="modal">
  <div class="modal-mask"></div>
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-hotspot" data-dismiss="modal"></div>
      <div class="modal-header">
        <a href="#" class="close"></a>
        <div class="modal-title">赎回说明</div>
      </div>
      <div class="modal-body">
        <p>基金赎回需满足最低赎回的额度的限制，在满足最低赎回限制的同时，还需满足最低持有份额的限制。所以在持有份额过少时，需要一次性全部赎回。</p>
        <a href="#" class="btn btn-primary" data-dismiss="modal">确认</a>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript" data-hb-js="hbec-trade-h5/1.0.0/js/redeem_0.0.1"></script>



<#else>
	<#include "/common/error_h5.ftl" />
</#if>
<#include "/_inc_commons.ftl" />
</body>
</html>