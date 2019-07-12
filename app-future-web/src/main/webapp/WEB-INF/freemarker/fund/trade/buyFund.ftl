<!DOCTYPE html>
<html>
<head>
    <title>买基金</title>
	<#include "/common/common-h5.ftl"/>
</head>
<body class="buyFund">
<#if (success!true)==true>




<section class="bg-gray">
  <ul class="list-group col-2 ft-list-bg">
    <li class="list-group-row"><span class="list-group-item">基金名称： </span><span class="list-group-item">${(otcProductBaseInfo.cpmc)!""}(${(otcProductBaseInfo.cpdm)!""})</span></li>
    <li class="list-group-row"><span class="list-group-item">支付银行： </span>
	    <span class="list-group-item bank">
	    <#if signInfo?? >
		    <#if signInfo.signingBankInfo??>${signInfo.signingBankInfo.yhmc!''}</#if>(尾号${(signInfo.yhkh?substring(signInfo.yhkh?length-4, signInfo.yhkh?length))!''})
		</#if>
	    </span>
    </li>
    <li class="list-group-row"><span class="list-group-item">预估费用：</span><span class="list-group-item" id="estimate"><#if (entrustInfo?? && entrustInfo.fundRatesDiscount??)><code>0元</code><#if (entrustInfo.fundRates?? && (entrustInfo.fundRatesDiscount != entrustInfo.fundRates) )><del>0元</del></#if><#else><code>免费</code></#if></span></li>
  </ul>

  <form class="form-group" id="orderForm">
    <div class="input-group">
      <label class="input-group-title">申购金额：</label>
      <input class="form-control" id="inpAmount" type="tel" placeholder="<#if (otcProductBaseInfo.qd4!0?c)==0>0<#else>${otcProductBaseInfo.qd4?c}</#if>元起购"/>
    </div>
    <div class="hb-checkbox" id="riskTip" style="<#if (sdxbz??) && (sdxbz != 0)>display:none</#if>">
    	<#if (sdxbz??) && (sdxbz == 0)>
    	<input type="checkbox" id="riskCheck" name="riskCheck"/>
    	<label class="checkbox-label" for="riskCheck"></label>
    	<span class="checkbox-tit">该基金为<code>
    	<#if (otcProductBaseInfo.fxjb)??>
			<#if (otcProductBaseInfo.fxjb) == 0>未定义
			<#elseif (otcProductBaseInfo.fxjb) == 1 >低风险
			<#elseif (otcProductBaseInfo.fxjb) == 2 >偏低风险
			<#elseif (otcProductBaseInfo.fxjb) == 3 >中等风险
			<#elseif (otcProductBaseInfo.fxjb) == 4>高风险
			</#if>
		<#else>
			未定义
		</#if>
    	</code>，确认购买超出风险承受能力的基金</span>
		</#if>
    </div>
    <div class="hb-btn-group">
	  	<#if isTradeTime>
	  	<button type="button" disabled="disabled" class="btn btn-primary disabled" id="btnSubmit">提交</button>
		<#else>
		<button type="button" disabled="disabled" class="btn disabled" >非交易时间</button>
		<p class="text-action-btn">交易时间为周一至周五9:00-15:00 节假日除外</p>
		</#if>
    </div>
    <input id="cpdm" name="cpdm" type="hidden" value="${(otcProductBaseInfo.cpdm)!""}"/>
    <input id="wtje" name="wtje" type="hidden" value=""/>
    <input id="jymm" name="jymm" type="hidden" value=""/>
    <input id="yhkh" name="yhkh" type="hidden" value="<#if signInfo??>${(signInfo.yhkh)!''}</#if>"/>
  </form>
  <input id="fundRates" name="fundRates" type="hidden" value="<#if entrustInfo??>${(entrustInfo.fundRates)!''}</#if>"/>
  <input id="fundRatesDiscount" name="fundRatesDiscount" type="hidden" value="<#if entrustInfo??>${(entrustInfo.fundRatesDiscount)!''}</#if>"/>
  <input id="minBuyNum" name="minBuyNum" type="hidden" value="<#if (otcProductBaseInfo.qd4!0?c)==0>0<#else>${otcProductBaseInfo.qd4?c}</#if>"/>
  <form method="post" id="errorMessageForm">
  		<input id="errorMessage" name="errorMessage" type="hidden" value=""/>
  </form>

</section>
<div id="payModal" class="modal">
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
          <div class="text-center">支付银行：
          	<#if signInfo??>
			    <#if signInfo.signingBankInfo??>${signInfo.signingBankInfo.yhmc!''}</#if>(尾号${(signInfo.yhkh?substring(signInfo.yhkh?length-4, signInfo.yhkh?length))!''})
			</#if>
		  </div>
        </div>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript" data-hb-js="hbec-trade-h5/1.0.0/js/buy_0.0.1"></script>





<#else>
    <#include "/common/error_h5.ftl" />
</#if>
<#include "/_inc_commons.ftl" />
</body>
</html>	